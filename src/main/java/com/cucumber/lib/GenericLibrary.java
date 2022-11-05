package com.cucumber.lib;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GenericLibrary {
	

	public static void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public static   File takeScreenshot(WebDriver driver,String fileName) throws Exception {
		String today_date=new Date().toString().replaceAll(" ", "_").replaceAll(":", "_");
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 	File dst= new File(System.getProperty("user.dir")+"/screenshots/"+fileName+today_date+".jpg");
	 	FileUtils.copyFile(src,dst);
	 	return dst;
	}
	
	public static  void waitUntilPageIsLoaded(WebDriver driver,int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public static  void waitUntilElementIsDisplayed(WebDriver driver,By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	
	public static boolean  waitForElementToBeDisplayedUsingFluentWait(WebDriver driver,WebElement wb)
	{
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		WebElement wb1=wait.until(new Function<WebDriver,WebElement>() {
		
			public WebElement apply(WebDriver driver)
			{

				return wb;
			}
		});
		return wb1.isDisplayed();
	}
	
	
	public static void clickByUsingActionsClass(WebDriver driver,WebElement wb) {
		 Actions act = new Actions(driver);
		 act.moveToElement(wb).click().build().perform();
	}
	
}
