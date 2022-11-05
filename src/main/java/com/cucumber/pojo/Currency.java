package com.cucumber.pojo;

public class Currency {
	
	private int id;
	private String currencyName;
	
	public Currency(int id,String currencyName)
	{
		this.id=id;
		this.currencyName=currencyName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	
	

}
