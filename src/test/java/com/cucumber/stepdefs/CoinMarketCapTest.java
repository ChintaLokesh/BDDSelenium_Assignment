package com.cucumber.stepdefs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.cucumber.lib.BaseClass;
import com.cucumber.lib.GenericLibrary;
import com.cucumber.objectrepo.HomePage;
import com.cucumber.objectrepo.Login;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CoinMarketCapTest {

	protected WebDriver driver;
	protected By by;
	protected By byLoginButton;
	protected By byemail;
	protected By bypassword;
	protected By byLogin;
	protected By byNextButton;
	protected By byGotIT;
	protected Login loginPageObj;
	protected HomePage homePageObj;
	protected static ExtentReports extent;
	protected static ExtentSparkReporter spark;
	protected static ExtentTest test;
	protected File screenshot;
	protected Properties prop;
	protected Calendar obj;
	protected String date;
	
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
				System.getProperty("user.dir") + "/Reports/BDD_Coin_Market_Cap_Test_" + date + ".html");

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
	
	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {
		driver=BaseClass.getInstance();
		driver.get(prop.getProperty("COIN_MARKET_CAP_URL"));
		driver.manage().window().maximize();
		test = extent.createTest("Create Coin Market Cap Test API");
		loginPageObj=PageFactory.initElements(driver, Login.class);
		homePageObj=PageFactory.initElements(driver, HomePage.class);
	}

	@When("^user provided username and password and click on Login button$")
	public void user_provided_username_and_password_and_click_on_Login_button() throws Throwable {

		Thread.sleep(5000);
		
		homePageObj.getHomePageNextButton().click();
		homePageObj.getHomePageGotItButton().click();
		Thread.sleep(5000);
		loginPageObj.getLogIn().click();
		
		Thread.sleep(5000);

		loginPageObj.getEmail().sendKeys(prop.getProperty("LOGIN_USER_NAME"));
		loginPageObj.getEmail().sendKeys(prop.getProperty("LOGIN_PASSWORD"));
		loginPageObj.getLogInHome().click();

		Thread.sleep(20000);
		
	}

	@When("^user selected option \"([^\"]*)\" in select dropdown$")
	public void user_selected_option_in_select_dropdown(String option) throws Throwable {

		screenshot=GenericLibrary.takeScreenshot(driver,"homePageBeforeSearch");
		test.log(Status.INFO, "Home screen before search");
		test.log(Status.INFO, "details", MediaEntityBuilder
				.createScreenCaptureFromPath(screenshot.toString()).build());
		homePageObj.getHomePageNextButton().click();
		homePageObj.getHomePageGotItButton().click();
		Thread.sleep(5000);
		homePageObj.getDropDown().click();
		test.log(Status.INFO, "Drop down button is clicked to select the count 100/50/20 as option");
		screenshot=GenericLibrary.takeScreenshot(driver,"homePageAfterSearch");
		test.log(Status.INFO, "details", MediaEntityBuilder
				.createScreenCaptureFromPath(screenshot.toString()).build());
	    
		// option 100 is selected
	   
		if( homePageObj.getOption_100().getText().equals(option)) {
	    homePageObj.getOption_100().click();}
	    test.log(Status.INFO, homePageObj.getOption_100().getText()+" option is selected  ");
		screenshot=GenericLibrary.takeScreenshot(driver,"search after selection");
	    Thread.sleep(10000);
	    System.out.println("table size is: "+homePageObj.getSearchResultCount().size());
	}

	@Then("^user should see row count as \"([^\"]*)\"$")
	public void user_should_see_row_count_as(String optionCount) throws Throwable {
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,3000)");
		test.log(Status.INFO, "Scroll page to view the the count displayed in UI");
		screenshot=GenericLibrary.takeScreenshot(driver,"searchResultDisplayed");
		test.log(Status.INFO, "details", MediaEntityBuilder
				.createScreenCaptureFromPath(screenshot.toString()).build());
		System.out.println(homePageObj.getSearchResultCount().size());
		System.out.println(optionCount);
		Assert.assertEquals( homePageObj.getSearchResultCount().size(),Integer.parseInt(optionCount));
		driver.quit();
	}
	
	@After
	public void tearDown()
	{
		extent.flush();
	}
}
