package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.BaseTest;
import utility.GenericMethods;

public class LoginPage {
	
	WebDriver driver;
	public GenericMethods genM;
	public BaseTest base;
	
	By usernameTxt = By.xpath("//input[@name='username']");
	By passwordTxt = By.xpath("//input[@name='password']");
	By loginBtn = By.xpath("//input[@type='submit' and @value='Login']");
	By homeMenu = By.xpath("/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[2]/a");
	By logoutLink = By.xpath("//a[contains(text(),'Logout')]");
	By logo = By.xpath("//td[text()='CRMPRO']");
	By menuBar = By.xpath("//div[@id='navmenu']");
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		genM = new GenericMethods(driver);
		base = new BaseTest();
	}
	
	public void openCRMAPP() throws IOException
	{
		genM.loadURL(base.getProperty().getProperty("url"));
	}
	
	public void login(String username, String password)
	{
		genM.enterText(usernameTxt, username);
		genM.enterText(passwordTxt, password);
		genM.doClick(loginBtn);
	}
	public void validateSuccessLogin() throws InterruptedException
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
		WebElement menu = genM.searchElement(menuBar);
		String tex = menu.findElement(logo).getText();
		System.out.println(tex);
		menu.findElement(logo).click();
	}
	
	public boolean validateLogout()
	{
		return genM.isDisplayed(logoutLink);
	}
}
