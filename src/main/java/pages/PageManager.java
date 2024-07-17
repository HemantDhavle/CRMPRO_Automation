package pages;

import org.openqa.selenium.WebDriver;

public class PageManager {

	public LoginPage login;
	WebDriver driver;
	public PageManager(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public LoginPage getLoginPage()
	{
		login = new LoginPage(driver);
		return login;
	}

}
