package com.cucumber.objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

	@FindBy(xpath="//div[div[@class='dgbbt4-6 hoQPNb']//button[text()=('Log In')]]//input[@type='email']")
	private WebElement email;
	
	@FindBy(xpath="//div[div[@class='dgbbt4-6 hoQPNb']//button[text()=('Log In')]]//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//div[@class='dgbbt4-6 hoQPNb']//button[text()=('Log In')]")
	private WebElement logInHome;
	
	@FindBy(xpath="//button[text()='Log In']")
	private WebElement logIn;

	public WebElement getEmail() {
		return email;
	}

	public void setEmail(WebElement email) {
		this.email = email;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getLogInHome() {
		return logInHome;
	}

	public void setLogInHome(WebElement logInHome) {
		this.logInHome = logInHome;
	}

	public WebElement getLogIn() {
		return logIn;
	}

	public void setLogIn(WebElement logIn) {
		this.logIn = logIn;
	}
	
	

}
