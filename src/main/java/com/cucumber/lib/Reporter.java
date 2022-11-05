package com.cucumber.lib;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Reporter {

	protected static ExtentReports extent;
	protected static ExtentSparkReporter spark;
	protected static ExtentTest test;
	protected Properties prop;
	protected Calendar obj;
	protected String date;
	
//	@Before
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
	
//	@After
	public void tearDown()
	{
		extent.flush();
		
	}
	
}
