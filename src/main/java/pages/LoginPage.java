package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BaseTest;
import utility.GenericMethods;

public class LoginPage {
	
	WebDriver driver;
	public GenericMethods genM;
	public BaseTest base;
	
	By usernameTxt = By.xpath("//input[@name='username']");
	By passwordTxt = By.xpath("//input[@name='password']");
	By loginBtn = By.xpath("//input[@type='submit' and @value='Login']");
	By homeMenu = By.xpath("//a[text()='Calendar']");
	By logoutLink = By.xpath("//a[contains(text(),'Logout')]");
	By logo = By.xpath("//td[text()='CRMPRO']");
	By menuBar = By.xpath("//div[@id='navmenu']");
	By mainFrame = By.xpath("//frame[@name='mainpanel']");
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		genM = new GenericMethods(driver);
		base = new BaseTest();
	}
	
	public void openCRMAPP() throws IOException, InterruptedException
	{
		genM.loadURL(base.getProperty().getProperty("url"));
		Thread.sleep(2000);
	}
	
	public void login(String username, String password)
	{
		genM.enterText(usernameTxt, username);
		genM.enterText(passwordTxt, password);
		genM.doClick(loginBtn);
	}
	public void validateSuccessLogin() throws InterruptedException
	{
		Thread.sleep(1000);
		System.out.println("Title of the page is "+driver.getTitle());
		genM.handleFrame("mainpanel");
		genM.isDisplayed(homeMenu);
		System.out.println(genM.isDisplayed(homeMenu));
		genM.doClick(homeMenu);

		String text = genM.grabText(logo);
		System.out.println("LOGO text is "+text);
		Thread.sleep(2000);

	}
	
	
	
	public boolean validateLogout()
	{
		return genM.isDisplayed(logoutLink);
	}
	}
