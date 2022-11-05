package com.cucumber.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	private static   WebDriver driver;
	
	private BaseClass(){
		
		
	}
	
	public static WebDriver getInstance()
	{
		if(System.getProperty("browserName") == null)
		{
			
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		else if(System.getProperty("browserName")=="edge")
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		else if(System.getProperty("browserName")=="chrome")
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver(options);
		} 
		return driver;
	}
}
