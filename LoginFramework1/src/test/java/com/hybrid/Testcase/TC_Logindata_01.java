package com.hybrid.Testcase;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybrid.PageObject.LoginPage;

import keywords.constants;
import keywords.keyword;

public class TC_Logindata_01 extends Base {

	private String uname;

	@Test
	public void TestEmailorPass() throws InterruptedException {

		LoginPage page = PageFactory.initElements(constants.driver, LoginPage.class);
		
		page.enterToUsername(uname);
		constants.logger.info("Enter username");
		
		
		page.enterToPassword(pass);
		constants.logger.info("Enter password");
		
		keyword.applyThread();
		page.clicktoElement();
		
		keyword.applyThread();
		
		
		if (constants.driver.getTitle().equals("Guru99 Bank Manager HomePage")) 
		{
			Assert.assertTrue(true);
			constants.logger.info("Test case is pass ");
		} else 
		{
			Assert.assertTrue(false);
			constants.logger.info("Test case is fail");
		}
	}

}
