package keywords;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.Select;



/**
 * @author Admin
 *
 */
/**
 * @author Admin
 *
 */
public class keyword {

	public static void openBrowser(String browserName) {

		switch (browserName) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver","D:\\eclipse programs\\TripFramework1\\Drivers\\chromedriver.exe");
			constants.driver = new ChromeDriver();
			constants.driver.manage().window().maximize();
			break;

		case "Firefox":
			System.setProperty("webdriver.chrome.driver","D:\\eclipse programs\\TripFramework1\\Drivers\\geckodriver.exe");
			constants.driver = new FirefoxDriver();
			constants.driver.manage().window().maximize();
			break;
		/*case "htmlUnit":
			System.setProperty("webdriver.chrome.driver",
					"D:\\All Driver.exe files\\chromedriver_win32\\chromedriver.exe");
			constants.driver = new HtmlUnitDriver();
			break;*/
		default:
			System.out.println("invalid browser name" + browserName);
		}

	}

	public static void openUrl(String url) {
		constants.driver.get(url);
	}

	public static WebElement getWebElement(String locator, String value) {
		WebElement element = null;
		switch (locator) {
		case "XPATH":
			element = constants.driver.findElement(By.xpath(value));

			break;

		case "CSS":
			element = constants.driver.findElement(By.cssSelector(value));

			break;

		case "ID":
			element = constants.driver.findElement(By.id(value));

			break;

		case "CLASS-NAME":
			element = constants.driver.findElement(By.className(value));

			break;
		case "LINKTEXT":
			element = constants.driver.findElement(By.linkText(value));

			break;

		default:
			System.err.println("Invalid locator " + locator + " .Expeted as CSS , ID ,LINKTEXT,CLASS-NAME,XPATH");
			break;
		}
		return element;
	}

	public static void enterText(String locator, String value, String textToenter) {
		getWebElement(locator, value).sendKeys(textToenter);

	}

	public static void clickToElememnt(String locator, String value) {

		getWebElement(locator, value).click();
	}

	public static void selectDropDown(String locator, String value, String selectText) {
		WebElement element = getWebElement(locator, value);
		Select s = new Select(element);
		s.selectByVisibleText(selectText);

	}

	public static void enterFname(String locator, String value, String fname) {
		getWebElement(locator, value).sendKeys(fname);
	}
	
	public static boolean isAlertPresent()
	{
		try {
			constants.driver.switchTo().alert().accept();;
			return true;
			
			
		} catch (Exception e) {
			
			return false;
		}
	
	}
	
	public static void applyWait() {
		constants.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

	}
	
	public static void applyThread() throws InterruptedException {
		Thread.sleep(3000);

	}
	public static void windowHandle()
	{
		String parentwindow=constants.driver.getWindowHandle();
		Set<String> allkeys=constants.driver.getWindowHandles();
		for (String child : allkeys) {
			while(!parentwindow.equals(child))
			{
				constants.driver.switchTo().window(child);
			}
		}
		
	}
	public static void closeBrowser()
	{
		constants.driver.quit();
	}
}
