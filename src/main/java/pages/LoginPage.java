package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
//		String tex = genM.grabText(homeMenu);
//		System.out.println(tex);'
		genM.doClick(homeMenu);

	}
	
	public boolean validateLogout()
	{
		return genM.isDisplayed(logoutLink);
	}
}
