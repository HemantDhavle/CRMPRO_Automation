package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

public WebDriver driver;

public Properties getProperty() throws IOException
{
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
	Properties prop = new Properties();
	prop.load(fis);
	return prop;
}

public WebDriver getDriver() throws IOException
{
	String mavenBrowser = getProperty().getProperty("browser");
	String cmdBrowser = System.getProperty("browser");
	String browser = (mavenBrowser!=null)?mavenBrowser:cmdBrowser;
	
	if(driver==null)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--incognito");
			driver = new ChromeDriver(co);
			driver.manage().window().maximize();
		}
		
		else if (browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}
	return driver;
	
}
}
