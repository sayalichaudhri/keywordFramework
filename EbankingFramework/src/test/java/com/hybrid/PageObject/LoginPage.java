package com.hybrid.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class LoginPage {

	@FindBy(xpath = "//input[@name='uid' or type='text']")
	@CacheLookup
	private WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	private WebElement password;

	@FindBy(xpath = "//input[@name='btnLogin']")
	@CacheLookup
	private WebElement loginbutton;
	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	private WebElement logoutbutton;


	public void enterToUsername(String uname) {
		username.sendKeys(uname);

	}

	public void enterToPassword(String pass) {
		password.sendKeys(pass);

	}

	public void clicktoElement() {
		loginbutton.click();

	}
	
	public void clicktoLogout() {
		logoutbutton.click();

	}
}
