package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class keyword {
	

	public static void openBrowser(String browserName ) {
		
	 	
		
		switch(browserName)
		{
		case "Chrome":
				System.setProperty("webdriver.chrome.driver", "D:\\All Driver.exe files\\chromedriver_win32\\chromedriver.exe");
			  constants.driver=new ChromeDriver();
			  break;
	
		case "Firefox":
			  WebDriverManager.firefoxdriver().setup();
			  constants.driver=new FirefoxDriver();
			  break;	
		case "htmlUnit":
			System.setProperty("webdriver.chrome.driver", "D:\\All Driver.exe files\\chromedriver_win32\\chromedriver.exe");
		 constants.driver=new HtmlUnitDriver();
			  break;
		default :
			System.out.println("invalid browser name" +browserName);
		}

	}
	
	public static void openUrl(String url)
	{
		constants.driver.get(url);
	}
	
	
	public static WebElement getWebElement(String locator,String value)
	{
		WebElement element = null;
		switch (locator) {
		case "XPATH":
		 element=constants.driver.findElement(By.xpath(value));
			
			break;
		
		case "CSS":
			element=constants.driver.findElement(By.cssSelector(value));
			
			break;

		case "ID":
			element=constants.driver.findElement(By.id(value));
			
			break;

		case "CLASS-NAME":
			element=constants.driver.findElement(By.className(value));
			
			break;
		case "LINKTEXT":
			element=constants.driver.findElement(By.linkText(value));
			
			break;

		default:
			System.err.println("Invalid locator "+locator +" .Expeted as CSS , ID ,LINKTEXT,CLASS-NAME,XPATH");
			break;
		}
	 return element;
	}
	
	public static void enterText(String locator,String value,String textToenter) {
		getWebElement(locator, value).sendKeys(textToenter);
		
	}
	
	public static void clickToElememnt(String locator,String value) {
		
			getWebElement(locator, value).click();
	}
	
	public static void selectDropDown(String locator,String value,String selectText)
	{
		WebElement element=getWebElement(locator,value);
		Select s=new Select(element);
	
		s.selectByVisibleText(selectText);
				
	}
	public static void enterFname(String locator,String value,String fname)
	{
		getWebElement(locator, value).sendKeys(fname);
	}

}