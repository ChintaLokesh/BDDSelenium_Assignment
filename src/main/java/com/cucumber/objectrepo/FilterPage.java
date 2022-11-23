package com.cucumber.objectrepo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterPage {

	@FindBy(xpath="//button[text()='Market Cap']")
	private WebElement marketCapButton;
	
	@FindBy(xpath="//div[@class='cmc-filter-presets']//button")
	private List<WebElement> filterOptions;
	
	@FindBy(xpath="//button[text()='Price']")
	private WebElement priceButton;
	
	@FindBy(xpath="//button[text()='Show results']")
	private WebElement showFilterOption;
	
	@FindBy(xpath="//table[contains(@class,'cmc-table')]//tbody//tr")
	private List<WebElement> resultList;
	
	@FindBy(xpath="//button[text()='Apply Filter']")
	private WebElement applyFilter;
	
	public WebElement getApplyFilter() {
		return applyFilter;
	}


	public void setApplyFilter(WebElement applyFilter) {
		this.applyFilter = applyFilter;
	}


	public WebElement getMarketCapButton() {
		return marketCapButton;
	}


	public void setMarketCapButton(WebElement marketCapButton) {
		this.marketCapButton = marketCapButton;
	}


	public List<WebElement> getFilterOptions() {
		return filterOptions;
	}


	public void setFilterOptions(List<WebElement> filterOptions) {
		this.filterOptions = filterOptions;
	}


	public WebElement getPriceButton() {
		return priceButton;
	}


	public void setPriceButton(WebElement priceButton) {
		this.priceButton = priceButton;
	}


	public WebElement getShowFilterOption() {
		return showFilterOption;
	}


	public void setShowFilterOption(WebElement showFilterOption) {
		this.showFilterOption = showFilterOption;
	}


	public List<WebElement> getResultList() {
		return resultList;
	}


	public void setResultList(List<WebElement> resultList) {
		this.resultList = resultList;
	}


	public List<WebElement> getPriceResultList() {
		return priceResultList;
	}


	public void setPriceResultList(List<WebElement> priceResultList) {
		this.priceResultList = priceResultList;
	}


	public List<WebElement> getMarketCapResultList() {
		return marketCapResultList;
	}


	public void setMarketCapResultList(List<WebElement> marketCapResultList) {
		this.marketCapResultList = marketCapResultList;
	}


	@FindBy(xpath="//table[contains(@class,'cmc-table')]//tbody//tr//td[4]//span")
	private List<WebElement> priceResultList;
	
	
	@FindBy(xpath="//table[contains(@class,'cmc-table')]//tbody//td[8]//span[2]")
	private List<WebElement> marketCapResultList;
	
}
