package utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	public void clearTextBox(By by)
	{
		driver.findElement(by).clear();
	}
	public String grabText(By by)
	{
		return searchElement(by).getText();
	}
	
	public void handleFrame(String name)
	{
		 driver.switchTo().frame(name);
		 
	}
	public void mouseHover(By by)
	{
		Actions act = new Actions(driver);
		act.moveToElement(searchElement(by)).perform();
	}
	public void SelectByValue(By by, String value)
	{
		Select sel = new Select(searchElement(by));
		sel.selectByValue(value);
		
	}
	
	public Iterator<String> handleWindow()
	{
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		return it;
	}
	
	public void moveToParentWindow()
	{
		String parent = handleWindow().next();
		driver.switchTo().window(parent);
	}
	
	public void moveToChildWindow()
	{
		String child = handleWindow().next();
		driver.switchTo().window(child);
	}
	public List<WebElement> getElements(By by)
	{
		List<WebElement> list = driver.findElements(by);
		return list;
	}
	
	public WebElement getElement(By by)
	{
		WebElement list = driver.findElement(by);
		return list;
	}
	public void doClick(String text1, String text2, String text3)
	{
		driver.findElement(By.xpath(text1+text2+text3));
	}
}

