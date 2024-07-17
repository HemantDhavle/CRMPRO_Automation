package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {

	public WebDriver driver;
	public GenericMethods(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public By getBy(String locatorType, String locatorValue)
	{
		By locator = null;
		
		switch (locatorType) {
		case "id":
			locator = By.id(locatorValue);
		break;
		case "name":
			locator = By.name(locatorValue);
		break;
		case "classname":
			locator = By.className(locatorValue);
		break;
		case "xpath":
			locator = By.xpath(locatorValue);
		break;
		case "linktext":
			locator = By.linkText(locatorValue);
		break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
		break;
		case "cssselector":
			locator = By.cssSelector(locatorValue);
		break;
		default:
			System.out.println("Please pass the correct locator");
			break;
		}
		return locator;
		
	}
	public WebElement searchElement(By by)
	{
		return driver.findElement(by);
	}
	
	public void loadURL(String url)
	{
		driver.get(url);
	}
	
	public void enterText(By by,String text)
	{
		searchElement(by).sendKeys(text);
	}
	
	public void doClick(By by)
	{
		searchElement(by).click();
	}
	
	public boolean isDisplayed(By by)
	{
		return searchElement(by).isDisplayed();
	}
	
	public WebDriverWait wait(int duration)
	{
		WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(duration));
		return wait;
	}
	
	public void waitTillElementVisible(By by)
	{
		wait(CONSTANTS.waitTime).until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public String grabText(By by)
	{
		return searchElement(by).getText();
	}
}
