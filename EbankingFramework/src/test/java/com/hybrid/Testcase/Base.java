package com.hybrid.Testcase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.hybrid.Utilities.Readconfig;

import keywords.constants;
import keywords.keyword;

public class Base extends keyword {

	static Readconfig readconfig = new Readconfig();
	public static String username1 = readconfig.getUsername();
	public static String pass = readconfig.getPassword();
	
	@BeforeMethod
	public void launchBrowser() {

		constants.logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j2.properties");

		keyword.openBrowser("Chrome");
		keyword.openUrl("http://demo.guru99.com/V4");
		constants.driver.manage().window().maximize();

	}

	@AfterMethod
	public void quitBrowser() {
		keyword.closeBrowser();
	}

}
