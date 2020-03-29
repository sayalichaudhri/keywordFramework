package com.hybrid.Testcase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hybrid.PageObject.LoginPage;
import com.hybrid.Utilities.DataDrivenTesting;
import com.hybrid.Utilities.LoginTestDataDriven;
import com.hybrid.Utilities.ReportListeners;

import keywords.constants;
import keywords.keyword;

@Listeners(ReportListeners.class)
public class TC_DataDrivenTest_02 extends Base {
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataDrivenTesting.class)
	public void verifyLogin(String uname, String pass) throws IOException, InterruptedException {

		LoginPage page = PageFactory.initElements(constants.driver, LoginPage.class);
		keyword.applyImplicitWait();
		
		page.enterToUsername(uname);
		constants.logger.info("your usernanme is enter:-"+uname);
		page.enterToPassword(pass);
		constants.logger.info("your pass is enter:-"+pass);
		
		page.clicktoElement();
		keyword.applySleep();
		if (keyword.isAlertPresent() == true) {
			constants.driver.navigate().back();
			Assert.assertTrue(false);
			constants.logger.warn("login failed");
		}

		else {
			Assert.assertTrue(true);
			constants.logger.info("login successfull");
			page.clicktoLogout();
			keyword.applySleep();
			constants.driver.switchTo().alert().accept();
			constants.driver.navigate().back();
		}
	}

}
