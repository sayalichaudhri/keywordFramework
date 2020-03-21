package TestCase;




import org.testng.annotations.Test;


import FileUtility.PropertiesFile;
import keywords.constants;
import keywords.keyword;

public class Regression {

	@Test
	public void tc_01()
	{
		keyword.openBrowser("Chrome");
		keyword.openUrl("https://www.facebook.com");
		
		constants.driver.manage().window().maximize();
		keyword.enterText(PropertiesFile.getLocator("email")[0],PropertiesFile.getLocator("email")[1], "sayalic3011@gmail.com");
		keyword.enterText(PropertiesFile.getLocator("pass")[0],PropertiesFile.getLocator("pass")[1], "gaurav1995@gmail.com");
		//keyword.clickToElememnt("XPATH", "//input[@value='Log In']");
	}
	@Test
	public void tc_02() {
		
		keyword.selectDropDown(PropertiesFile.getLocator("day")[0], PropertiesFile.getLocator("day")[1],"30");
		keyword.selectDropDown(PropertiesFile.getLocator("month")[0], PropertiesFile.getLocator("month")[1],"Nov");
		keyword.selectDropDown(PropertiesFile.getLocator("year")[0], PropertiesFile.getLocator("year")[1],"1994");
		keyword.enterText(PropertiesFile.getLocator("Firstname")[0], PropertiesFile.getLocator("Firstname")[1], "sayali");
		constants.driver.quit();
	}
	
	
	

}
