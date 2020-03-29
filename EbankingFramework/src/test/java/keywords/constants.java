package keywords;



import java.awt.Robot;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.apache.log4j.Logger;

public class constants {
	
	public static WebDriver driver; 
	public static FileInputStream fin;
	public static Properties prop;
	public static Actions action;
	public static Select select;
	public static FluentWait wait;
	public static Robot robo;
	public static ChromeOptions options;
	public static Logger logger;
}



