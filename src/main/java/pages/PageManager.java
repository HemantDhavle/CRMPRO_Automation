package pages;

import org.openqa.selenium.WebDriver;

public class PageManager {

	public LoginPage login;
	public EventPage event;
	public CompanyPage company;
	public WebDriver driver;
	public PageManager(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public LoginPage getLoginPage()
	{
		login = new LoginPage(driver);
		return login;
	}
	
	public EventPage getEventPage()
	{
		event = new EventPage(driver);
		return event;
	}

	public CompanyPage getCompanyPage()
	{
		company = new CompanyPage(driver);
		return company;
	}

}
