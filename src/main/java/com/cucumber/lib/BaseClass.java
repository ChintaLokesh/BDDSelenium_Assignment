package com.cucumber.lib;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	private static   WebDriver driver;
	
	private BaseClass(){
		
		
	}
	
	public static WebDriver getInstance() throws MalformedURLException
	{
		System.out.println("browser name is: "+System.getProperty("browserName"));
		if(System.getProperty("browserName") == null)
		{
			
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();

			// code to run the scripts using docker containers
			
//			ChromeOptions options = new ChromeOptions();
//			driver= new RemoteWebDriver(new URL("http://192.168.1.7:4444/wd/hub"),options);
		}
		else if(System.getProperty("browserName").equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		else if(System.getProperty("browserName").equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-debugging-port=9222");
			options.setHeadless(true);
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver(options);

		} 
		return driver;
	}
}
