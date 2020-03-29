package keywords;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class keyword {

	public static void openBrowser(String browserName) {

		switch (browserName) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver",
					"D:\\eclipse programs\\GroomautoFramework\\Drivers\\chromedriver.exe");
			constants.driver = new ChromeDriver();
			constants.driver.manage().window().maximize();
			break;

		case "Firefox":
			System.setProperty("webdriver.chrome.driver",
					"D:\\eclipse programs\\GroomautoFramework\\Drivers\\geckodriver.exe");
			constants.driver = new FirefoxDriver();
			constants.driver.manage().window().maximize();
			break;
		/*
		 * case "htmlUnit": System.setProperty("webdriver.chrome.driver",
		 * "D:\\All Driver.exe files\\chromedriver_win32\\chromedriver.exe");
		 * constants.driver = new HtmlUnitDriver(); break;
		 */
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

	public static void clickOnElememnt(String locator, String value) {

		getWebElement(locator, value).click();
	}

	public static void selectDropDown(String locator, String value, String selectText) {
		WebElement element = getWebElement(locator, value);
		constants.select = new Select(element);
		constants.select.selectByVisibleText(selectText);

	}
	
	public static void handleAlertWithAccept() {
		constants.driver.switchTo().alert().accept();

	}
	
	public static void handleAlertWithDismiss() {
		constants.driver.switchTo().alert().dismiss();

	}
	
	public static String getAlertText() {
		String text=constants.driver.switchTo().alert().getText();
		System.out.println("Alert text is"+text);
		return text;
	}

	public static void getScreenShot() {
		
		try {
			constants.robo = new Robot();
		} catch (AWTException e1) {
			
		}
	    Rectangle rect=new Rectangle();
	    rect.setFrame(0, 0, 700, 500);
	    BufferedImage img=constants.robo.createScreenCapture(rect);
	    try {
			ImageIO.write(img, "png", new File("NewImage.png"));
		
	    } catch (IOException e) {
			System.out.println("Could not save image");
		}
	  }
	public static void getFullPageScreenShot() {
		AShot ashot=new AShot();
	    Screenshot sc=ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(constants.driver);
	    try {
			ImageIO.write(sc.getImage(),"jpg", new File("UsingScreenshot.jpg"));
		} catch (IOException e) {
			System.out.println("Could not save image");
		}

	}
	public static boolean isAlertPresent() {
		try {
			constants.driver.switchTo().alert().accept();
			
			return true;

		} catch (Exception e) {

			return false;
		}

	}

	public static void applyImplicitWait() {
		constants.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

	}

	public static void applyExplicitWait(WebElement element) {

		constants.wait.withTimeout(1000, TimeUnit.SECONDS);
		constants.wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
		constants.wait.pollingEvery(200, TimeUnit.SECONDS);
		constants.wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void applySleep() throws InterruptedException {
		Thread.sleep(3000);
	}
	

	public static void switchToWindow() {
		String parentwindow = constants.driver.getWindowHandle();
		Set<String> allkeys = constants.driver.getWindowHandles();
		for (String child : allkeys) {
			while (!parentwindow.equals(child)) {
				constants.driver.switchTo().window(child);
			}
		}

	}
	

	public static String getTitle(String title) {
		constants.driver.getTitle();
		return title;
	}

	public static void navigateBack() {
		constants.driver.navigate().back();
	}

	public static void navigateForword() {
		constants.driver.navigate().forward();
	}

	public static void refreshPage() {
		constants.driver.navigate().refresh();
	}

	public static void navigateToUrl(String url) {

		constants.driver.navigate().to(url);
	}

	public static void windowMaximize() {
		constants.driver.manage().window().maximize();

	}

	public static void mouesHover(WebElement element) {
		constants.action = new Actions(constants.driver);
		constants.action.moveToElement(element).perform();
	}
	
	public static void doubleClick() {
		constants.action = new Actions(constants.driver);
		constants.action.doubleClick().perform();

	}
	
	public static void rightClick() {
		constants.action = new Actions(constants.driver);
		constants.action.contextClick().perform();

	}
	
	public static void scrollByDown() {
		JavascriptExecutor js = (JavascriptExecutor) constants.driver;
		js.executeScript("window.scrollBy(0,2000)");
	}
	
	public static void handlePopUp() {
		
		constants.options = new ChromeOptions();
		constants.options.addArguments("--disable-notifications");
	}
	
	public static void uploadFile() {
		

	}
	

	public static void closeBrowser() {
		constants.driver.quit();
	}
}
