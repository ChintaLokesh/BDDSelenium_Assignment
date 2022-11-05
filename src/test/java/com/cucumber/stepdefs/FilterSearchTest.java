package com.cucumber.stepdefs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.cucumber.lib.BaseClass;
import com.cucumber.lib.GenericLibrary;
import com.cucumber.objectrepo.FilterPage;
import com.cucumber.objectrepo.HomePage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FilterSearchTest {

	protected WebDriver driver;
	protected static  FilterPage filterPage_PageObj;
	protected static com.cucumber.objectrepo.HomePage homePage_PageObj;
	protected static ExtentReports extent;
	protected static ExtentSparkReporter spark;
	protected static ExtentTest test;
	protected static File screenshot;
	protected Properties prop;
	protected Calendar obj;
	protected String date;
	protected boolean status;

	@Before
	public void configure() throws FileNotFoundException, IOException {

		extent = new ExtentReports();
		prop = new Properties();

		obj = Calendar.getInstance();
		date = obj.getTime().toString().replace(" ", "_").replace(":", "_");
		System.out.println("Current Date and time: " + date);
		System.out.println("properties file path is : " + System.getProperty("user.dir") + "/project.properties");
		prop.load(new FileReader(System.getProperty("user.dir") + "/project.properties"));

		spark = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/Reports/BDD_Filter_Search_Validation_Test_" + date + ".html");

		extent.attachReporter(spark);

		String nameOS = "os.name";
		String versionOS = "os.version";
		String architectureOS = "os.arch";

		nameOS = System.getProperty(nameOS);
		versionOS = System.getProperty(versionOS);
		architectureOS = System.getProperty(architectureOS);
		extent.setSystemInfo("Name of the OS: ", nameOS);
		extent.setSystemInfo("Version of the OS: ", versionOS);
		extent.setSystemInfo("Architecture of The OS: ", architectureOS);

	}

	@Given("^User is on Homepage$")
	public void user_is_on_Homepage() throws Throwable {

		driver = BaseClass.getInstance();
		driver.get(prop.getProperty("COIN_MARKET_CAP_URL"));
		driver.manage().window().maximize();
		GenericLibrary.waitUntilPageIsLoaded(driver, 3);
		// Thread.sleep(3000);
		test = extent.createTest("Create Filter Search Test API");
		filterPage_PageObj = PageFactory.initElements(driver, FilterPage.class);
		homePage_PageObj = PageFactory.initElements(driver, HomePage.class);
	}

	@When("^User Click on \"([^\"]*)\" button and filter records by MarketCap with value \"([^\"]*)\" and Price with value \"([^\"]*)\"$")
	public void user_Click_on_button_and_filter_records_by_MarketCap_with_value_and_Price_with_value(String arg1,
			String marketCapValue, String priceVal) throws Throwable {

		Assert.assertTrue(GenericLibrary.waitForElementToBeDisplayedUsingFluentWait(driver,
				homePage_PageObj.getHomePageNextButton()));

		// click Next Button popup present in Home page
		test.log(Status.INFO, "Home Page Before Next Button Click");
		screenshot = GenericLibrary.takeScreenshot(driver, "homePageBeforeNextButtonClick");
		test.log(Status.INFO, "details", MediaEntityBuilder.createScreenCaptureFromPath(screenshot.toString()).build());
		homePage_PageObj.getHomePageNextButton().click();
		test.log(Status.INFO, "Home Page After Next Button Click");
		screenshot = GenericLibrary.takeScreenshot(driver, "homePageNextButton");
		test.log(Status.INFO, "details", MediaEntityBuilder.createScreenCaptureFromPath(screenshot.toString()).build());
		// Thread.sleep(2000);
		Assert.assertTrue(GenericLibrary.waitForElementToBeDisplayedUsingFluentWait(driver,
				homePage_PageObj.getHomePageGotItButton()));
		System.out.println("status is:" + status);

		// Got it Button click present in Home page

		homePage_PageObj.getHomePageGotItButton().click();
		screenshot = GenericLibrary.takeScreenshot(driver, "homePageGotItButton");
		test.log(Status.INFO, "Home Page Got IT Button After Click");
		test.log(Status.INFO, "details", MediaEntityBuilder.createScreenCaptureFromPath(screenshot.toString()).build());
		// Thread.sleep(3000);
		Assert.assertTrue(
				GenericLibrary.waitForElementToBeDisplayedUsingFluentWait(driver, homePage_PageObj.getFilterButton()));

		// click on Filter button present in Home page

		homePage_PageObj.getFilterButton().click();
		test.log(Status.INFO, "Filter Button After Click");
		screenshot = GenericLibrary.takeScreenshot(driver, "filterButton");
		test.log(Status.INFO, "details", MediaEntityBuilder.createScreenCaptureFromPath(screenshot.toString()).build());
		Thread.sleep(3000);

		System.out.println(homePage_PageObj.getMayBeLaterButton().size());

		// code to close the sign up popup if present at the bottom of the screen

//		if ((homePage_PageObj.getMayBeLaterButton().size() > 1)
//				&& (homePage_PageObj.getMayBeLaterButton().get(0).isDisplayed())
//				&& (homePage_PageObj.getMayBeLaterButton().get(0).isEnabled())) {
//			screenshot = GenericLibrary.takeScreenshot(driver, "signupPopup");
//			test.log(Status.INFO, "sign up popup Display");
//			test.log(Status.INFO, "details",
//					MediaEntityBuilder.createScreenCaptureFromPath(screenshot.toString()).build());
//			homePage_PageObj.getMayBeLaterButton().get(0).click();
//		}
		closeSignUPPopup(driver);
		
		Thread.sleep(2000);

		// click on Add Filter

		homePage_PageObj.getAddFilterbutton().click();
		screenshot = GenericLibrary.takeScreenshot(driver, "addFilterButton");
		test.log(Status.INFO, "clicked on Add filter");
		test.log(Status.INFO, "details", MediaEntityBuilder.createScreenCaptureFromPath(screenshot.toString()).build());
		Thread.sleep(3000);

		// select the market cap option available in filter screen

		filterPage_PageObj.getMarketCapButton().click();
		screenshot = GenericLibrary.takeScreenshot(driver, "marketSearchOptionDetails");
		test.log(Status.INFO, "Selected Market Cap option");
		test.log(Status.INFO, "details", MediaEntityBuilder.createScreenCaptureFromPath(screenshot.toString()).build());
		List<WebElement> list = filterPage_PageObj.getFilterOptions();
		Assert.assertTrue(list.size() > 0);

		// select the desired option for market cap

		for (WebElement wb : list) {
			if (wb.getText().equalsIgnoreCase(marketCapValue)) {
				wb.click();

				screenshot = GenericLibrary.takeScreenshot(driver, "market cap search criterial option selected");
				test.log(Status.INFO, "market cap search criterial option selected");
				test.log(Status.INFO, "details",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshot.toString()).build());
				System.out.println(homePage_PageObj.getMayBeLaterButton().size());

				// code to close the sign up popup if present at the bottom of the screen

//				if (homePage_PageObj.getMayBeLaterButton().size() > 0
//						&& homePage_PageObj.getMayBeLaterButton().get(0).isDisplayed()
//						&& homePage_PageObj.getMayBeLaterButton().get(0).isEnabled()) {
//					homePage_PageObj.getMayBeLaterButton().get(0).click();
//				}
				closeSignUPPopup(driver);
				screenshot = GenericLibrary.takeScreenshot(driver, "signupPopup_01");
				test.log(Status.INFO, "sign up popup Display1");
				test.log(Status.INFO, "details",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshot.toString()).build());
				
				closeSignUPPopup(driver);
				filterPage_PageObj.getApplyFilter().click();
				break;
			}

		}

		// select the price option

		filterPage_PageObj.getPriceButton().click();
		screenshot = GenericLibrary.takeScreenshot(driver, "priceSearchOptionDetails");
		test.log(Status.INFO, "price search option selected");
		test.log(Status.INFO, "details", MediaEntityBuilder.createScreenCaptureFromPath(screenshot.toString()).build());
		List<WebElement> list1 = filterPage_PageObj.getFilterOptions();
		Assert.assertTrue(list1.size() > 0);

		// select the desired option for price

		for (WebElement wb : list1) {
			if (wb.getText().equalsIgnoreCase(priceVal)) {
				wb.click();
				screenshot = GenericLibrary.takeScreenshot(driver, "priceSearchOptionSelected");
				test.log(Status.INFO, "price search criterial option selected");
				test.log(Status.INFO, "details",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshot.toString()).build());
				filterPage_PageObj.getApplyFilter().click();
				break;
			}

		}
		screenshot = GenericLibrary.takeScreenshot(driver, "beforeShowFilterResults");
		test.log(Status.INFO, "Before Click on show Filter options");
		test.log(Status.INFO, "details", MediaEntityBuilder.createScreenCaptureFromPath(screenshot.toString()).build());
		filterPage_PageObj.getShowFilterOption().click();

	}

	@Then("^verify records displayed on page are correct as per the filters \"([^\"]*)\" and \"([^\"]*)\" applied$")
	public void verify_records_displayed_on_page_are_correct_as_per_the_filters_and_applied(String marketCapValue,
			String priceValue) throws Throwable {

		int marketCapValueMatchCount = 0;
		int priceValueMatchCount = 0;
		List<WebElement> list2;
		int listSize = 0;

		// wait for page to be loaded in UI after search operation

		Thread.sleep(12000);
		
		screenshot = GenericLibrary.takeScreenshot(driver, "afterShowFilterResults");
		test.log(Status.INFO, "final search results shown in UI");
		test.log(Status.INFO, "details", MediaEntityBuilder.createScreenCaptureFromPath(screenshot.toString()).build());
		
		list2 = filterPage_PageObj.getResultList();
		listSize = list2.size();
		Assert.assertTrue(listSize > 0);
		list2 = filterPage_PageObj.getPriceResultList();

		// validate the price value displayed in UI is as per the selection made earlier
		// for price filter

		for (WebElement wb : list2) {

			if ((Math.round(Float.parseFloat(wb.getText().toString().replace("$", "").trim()))) > (Integer
					.parseInt(priceValue.split(" - ")[0].replace("$", "")))
					&& (Math.round(Float.parseFloat(wb.getText().toString().replace("$", "").trim()))) < (Integer
							.parseInt(priceValue.split(" - ")[1].replace("$", "").replace(",", "")))) {
				priceValueMatchCount++;

			}

		}

		Assert.assertEquals(listSize, priceValueMatchCount);

		list2 = filterPage_PageObj.getResultList();
		listSize = list2.size();
		Assert.assertTrue(listSize > 0);
		list2 = filterPage_PageObj.getMarketCapResultList();

		// validate the price value displayed in UI is as per the selection made earlier
		// for market cap filter

		for (WebElement wb : list2) {

			if (Long.parseLong(wb.getText().toString().replace("$", "").replaceAll(",", "").trim()) > 1000000000
					&& (Long.parseLong(
							wb.getText().toString().replace("$", "").replaceAll(",", "").trim())) < 10000000000L) {
				marketCapValueMatchCount++;

			}

		}
		Assert.assertEquals(listSize, marketCapValueMatchCount);
		driver.quit();
	}

	@After
	public void tearDown() {
		extent.flush();
		// driver.quit();
	}
	
	public static void closeSignUPPopup(WebDriver driver) throws Exception
	{
		
		if ((homePage_PageObj.getMayBeLaterButton().size() > 0)
				&& (homePage_PageObj.getMayBeLaterButton().get(0).isDisplayed())
				&& (homePage_PageObj.getMayBeLaterButton().get(0).isEnabled())) {
			screenshot = GenericLibrary.takeScreenshot(driver, "signupPopup");
			test.log(Status.INFO, "sign up popup Display");
			test.log(Status.INFO, "details",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot.toString()).build());
			homePage_PageObj.getMayBeLaterButton().get(0).click();
		}
	}
}
