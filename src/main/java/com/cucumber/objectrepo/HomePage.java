package com.cucumber.objectrepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath= "//div[@class='sc-1hxnufv-4 dEpvVp hide_on_mobile_wrapper']//button[text()='Filters']")
	private WebElement filterButton;
	
	@FindBy(xpath="//button[text()='Add Filter']")
	private WebElement addFilterbutton;

	@FindBy(xpath="//button[text()='Next']")
	private WebElement homePageNextButton;
	
	@FindBy(xpath="//button[text()='Got it']")
	private WebElement homePageGotItButton;

	@FindBy(xpath="//button[text()='Maybe later']")
	private List<WebElement> MayBeLaterButton;
	
	@FindBy(xpath="//div[@class='sc-1prm8qw-0 dEHpSU table-control-page-sizer']//div")
	private WebElement dropDown;
	
	@FindBy(xpath="//*[@class='sc-1ebmiy2-0 juUwCn' and contains(text(),'100')]")
	private WebElement option_100;
	
	@FindBy(xpath="//*[@class='sc-1ebmiy2-0 juUwCn' and contains(text(),'50')]")
	private WebElement option_50;
	
	@FindBy(xpath="//*[@class='sc-1ebmiy2-0 juUwCn' and contains(text(),'20')]")
	private WebElement option_20;
	
	@FindBy(xpath="//table[@class='h7vnx2-2 cgeQEz cmc-table  ']//tbody//tr")
	private List<WebElement> searchResultCount;
	
	
	public List<WebElement> getSearchResultCount() {
		return searchResultCount;
	}

	public void setSearchResultCount(List<WebElement> searchResultCount) {
		this.searchResultCount = searchResultCount;
	}

	public WebElement getDropDown() {
		return dropDown;
	}

	public void setDropDown(WebElement dropDown) {
		this.dropDown = dropDown;
	}

	public WebElement getOption_100() {
		return option_100;
	}

	public void setOption_100(WebElement option_100) {
		this.option_100 = option_100;
	}

	public WebElement getOption_50() {
		return option_50;
	}

	public void setOption_50(WebElement option_50) {
		this.option_50 = option_50;
	}

	public WebElement getOption_20() {
		return option_20;
	}

	public void setOption_20(WebElement option_20) {
		this.option_20 = option_20;
	}

	public List<WebElement> getMayBeLaterButton() {
		return MayBeLaterButton;
	}

	public void setMayBeLaterButton(List<WebElement> mayBeLaterButton) {
		MayBeLaterButton = mayBeLaterButton;
	}

	public WebElement getHomePageNextButton() {
		return homePageNextButton;
	}

	public void setHomePageNextButton(WebElement homePageNextButton) {
		this.homePageNextButton = homePageNextButton;
	}

	public WebElement getHomePageGotItButton() {
		return homePageGotItButton;
	}

	public void setHomePageGotItButton(WebElement homePageGotItButton) {
		this.homePageGotItButton = homePageGotItButton;
	}

	public WebElement getFilterButton() {
		return filterButton;
	}

	public void setFilterButton(WebElement filterButton) {
		this.filterButton = filterButton;
	}

	public WebElement getAddFilterbutton() {
		return addFilterbutton;
	}

	public void setAddFilterbutton(WebElement addFilterbutton) {
		this.addFilterbutton = addFilterbutton;
	}
	
	
	
}
