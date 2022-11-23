package com.cucumber.lib;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.cucumber.objectrepo.HomePage;

public class BusinessLibrary {
	protected static com.cucumber.objectrepo.HomePage homePage_PageObj;
	protected static File screenshot;
	public static void closeSignUPPopup(WebDriver driver,ExtentTest test) throws Exception
	{
		homePage_PageObj = PageFactory.initElements(driver, HomePage.class);
		
		if ((homePage_PageObj.getMayBeLaterButton().size() > 0)
				&& (homePage_PageObj.getMayBeLaterButton().get(0).isDisplayed())
				&& (homePage_PageObj.getMayBeLaterButton().get(0).isEnabled())) {
			screenshot = GenericLibrary.takeScreenshot(driver, "signupPopup");
			test.log(Status.INFO, "sign up popup Display");
			test.log(Status.INFO, "details",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot.toString()).build());
			System.out.println("Get May Be later button text is: "+homePage_PageObj.getMayBeLaterButton().get(0).getText());
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", homePage_PageObj.getMayBeLaterButton().get(0));
		}
	}
}
