package com.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(

		features={"src/test/resources/Features/RetrieveId.feature",
				"src/test/resources/Features/CurrencyDetails.feature",
				"src/test/resources/Features/FrontEnd.feature",
				"src/test/resources/Features/FilterSearchResults.feature"},
		plugin = {"pretty"},
		glue= {"com.cucumber.stepdefs"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
