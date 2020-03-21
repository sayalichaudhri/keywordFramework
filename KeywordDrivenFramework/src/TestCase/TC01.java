package TestCase;

import org.testng.annotations.Test;

import FileUtility.PropertiesFile;
import keywords.constants;
import keywords.keyword;

public class TC01 {
	@Test
	public void tc_01()
	{
		keyword.openBrowser("Chrome");
		keyword.openUrl("https://www.facebook.com");
		
		constants.driver.manage().window().maximize();
		keyword.enterText("CSS",PropertiesFile.getProperty("email"), "sayalic3011@gmail.com");
		keyword.enterText("CSS",PropertiesFile.getProperty("pass"), "gaurav199");
	
	}

}
