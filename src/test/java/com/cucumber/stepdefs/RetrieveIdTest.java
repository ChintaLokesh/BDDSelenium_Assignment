package com.cucumber.stepdefs;


import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import org.testng.Assert;
import com.cucumber.lib.Reporter;
import com.cucumber.pojo.Currency;
import com.cucumber.pojo.Data;
import com.cucumber.pojo.RetrieveIdAPIResponsePojo1;
import com.google.gson.Gson;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class RetrieveIdTest extends Reporter{

	protected RequestSpecification specificationObj;
	protected Response resObj;
	protected JsonPath jpObj;
	protected RetrieveIdAPIResponsePojo1 retrieveIdAPIResponsePojo1Obj;
	protected ArrayList<Data> listObj;
	protected static LinkedHashMap<Integer, Currency> mapObj = new LinkedHashMap<Integer, Currency>();
	protected static int count = 1;
	protected Currency currencyObj;
	protected JsonPath jsonPathEvaluator;
	protected List list;
	protected static int tagCount = 0;
	protected Properties prop;

	
	
	@Given("^coinmarketcap base uri is available$")
	public void cryptocurrency_map_GET_API_is_available() throws Throwable {
		
		// Load the project.properties file
		
		prop = new Properties();
		prop.load(new FileReader(System.getProperty("user.dir") + "/project.properties"));
		RestAssured.baseURI =prop.getProperty("COIN_MARKET_CAP_BASE_URI");
		specificationObj = RestAssured.given();
		
	}

	@When("^Authorization is provided as header$")
	public void authorization_is_provided_as_header() throws Throwable {

		// provide the authorization key as Header
		
	
		specificationObj.header(prop.getProperty("AUTHORIZATION_KEY"), prop.getProperty("AUTHORIZATION_VALUE"));
	}

	@Then("^Retrieve the Id for name \"([^\"]*)\" with symbol \"([^\"]*)\"$")
	public void retrieve_the_Id_for_name_with_symbol(String coinName, String coinSymbol) throws Throwable {
		
		specificationObj.log().all();

		// Trigger the CRYPTO_CURRENCY_MAP_API Call
		
		resObj = specificationObj.get(prop.getProperty("CRYPTO_CURRENCY_MAP_API"));
		System.out.println(resObj.getStatusCode());
		Assert.assertEquals(resObj.getStatusCode(), 200);

		jpObj = new JsonPath(resObj.getBody().asString());
		retrieveIdAPIResponsePojo1Obj = new Gson().fromJson(resObj.getBody().asString(),
				RetrieveIdAPIResponsePojo1.class);
		listObj = retrieveIdAPIResponsePojo1Obj.getData();
		System.out.println("size is:" + listObj.size());
		
		// check the coin name and coin symbol in API response and store the details in map obj
		
		for (Data data : listObj) {
			if (data.getName().equalsIgnoreCase(coinName) && data.getSymbol().equalsIgnoreCase(coinSymbol)) {
				currencyObj = new Currency(data.getId(), coinName);
				mapObj.put(count, currencyObj);
				System.out.println("Id for " + coinName + " is: " + data.getId());
				count++;
				break;
			}
		}

	}

	@Then("^extract the price of the Bolivarcoin \"([^\"]*)\" with symbol \"([^\"]*)\"$")
	public void extract_the_price_of_the_Bolivarcoin_with_symbol(String coinName, String coinSymbol) throws Throwable {

		int convert_id = 0;

		// check and extract the Bolivian coin id from the map obj
		
		for (int iter = 1; iter <= mapObj.size(); iter++) {
			System.out.println(mapObj.get(iter).getCurrencyName());
			if (mapObj.get(iter).getCurrencyName() == coinName) {
				System.out.println(mapObj.get(iter).getId());
				convert_id = mapObj.get(iter).getId();
				break;
			}
		}

		// convert the currency of the Id's to Bolivian 
		
		for (int iter = 1; iter < mapObj.size(); iter++) {
			resObj = given().header("X-CMC_PRO_API_KEY", "a9487c5d-aee2-4730-83c2-93b34dc1b93e")
					.queryParam("id", mapObj.get(iter).getId()).queryParam("amount", 100)
					.queryParam("convert_id", convert_id).log().all().when().log().all()
					.get(prop.getProperty("PRICE_CONVERSION")).then().extract().response();
			
			System.out.println(resObj.getBody().asString());
			System.out.println(resObj.getStatusCode());
			Assert.assertEquals(resObj.getStatusCode(), 200);
			jsonPathEvaluator = resObj.jsonPath();
			System.out.println("Converted price is: "+jsonPathEvaluator.get("data.quote." + convert_id + ".price").toString());
		}
	}

	@Then("^verify the details for the id \"([^\"]*)\" like logo \"([^\"]*)\", technical_doc \"([^\"]*)\", symbol \"([^\"]*)\", date_added \"([^\"]*)\" and tags \"([^\"]*)\"$")
	public void verify_the_details_for_the_id_like_logo_technical_doc_symbol_date_added_and_tags(String id, String logo,
			String technical_doc, String symbol, String date_added, String tags) throws Throwable {

		specificationObj.queryParam("id", id);
		specificationObj.log().all();
		resObj = specificationObj.get(prop.getProperty("CRYPTO_CURRENCY_INFO"));
		System.out.println(resObj.getStatusCode());
		System.out.println(resObj.getBody().asString());

		Assert.assertEquals(resObj.getStatusCode(), 200);
		jsonPathEvaluator = resObj.jsonPath();

		Assert.assertEquals(jsonPathEvaluator.get("data." + id + ".id").toString(), id);
		Assert.assertEquals(jsonPathEvaluator.get("data." + id + ".logo").toString(), logo);
		Assert.assertEquals(jsonPathEvaluator.get("data." + id + ".urls.technical_doc").toString(), technical_doc);
		Assert.assertEquals(jsonPathEvaluator.get("data." + id + ".symbol").toString(), symbol);
		Assert.assertEquals(jsonPathEvaluator.get("data." + id + ".date_added").toString(), date_added);

	}

	@Then("^verify the currencies name \"([^\"]*)\" with Id's \"([^\"]*)\" have the \"([^\"]*)\" tag associated with them$")
	public void verify_the_currencies_name_with_Id_s_have_the_tag_associated_with_them(String currencyName, String id,
			String tagName) throws Throwable {

		boolean status = false;

		specificationObj.queryParam("id", id);
		specificationObj.log().all();
		resObj = specificationObj.get(prop.getProperty("CRYPTO_CURRENCY_INFO"));
		System.out.println(resObj.getStatusCode());
		System.out.println(resObj.getBody().asString());

		Assert.assertEquals(resObj.getStatusCode(), 200);

		jsonPathEvaluator = resObj.jsonPath();

		list = jsonPathEvaluator.getList("data." + id + ".tags");

		for (int iteration1 = 0; iteration1 < list.size(); iteration1++) {
			System.out.println("Actual tag is:" + list.get(iteration1));
			System.out.println("Expected tag is:" + tagName);
			if (list.get(iteration1).toString().equalsIgnoreCase(tagName)) {

				status = true;
				tagCount++;
				Assert.assertTrue(status);
				break;

			}
		}

		System.out.println("Actual currency name is: " + jsonPathEvaluator.get("data." + id + ".name").toString());
		System.out.println("Expected currency name is: " + currencyName);
		Assert.assertEquals(jsonPathEvaluator.get("data." + id + ".name").toString().trim(), currencyName.trim());
		System.out.println("mineable tag count associated with currencies is: " + tagCount);
	}

}
