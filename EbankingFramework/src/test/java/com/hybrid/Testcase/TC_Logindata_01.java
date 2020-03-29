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
		constants.logger.info("Entered username:="+uname);
		
		
		page.enterToPassword(pass);
		constants.logger.info("Entered password:="+pass);
		
		keyword.applySleep();
		page.clicktoElement();
		
		keyword.applySleep();
		
		
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
