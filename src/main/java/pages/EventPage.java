package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.BaseTest;
import utility.GenericMethods;

public class EventPage {
	public WebDriver driver;
	public PageManager page;
	public GenericMethods genM;
	public BaseTest base;
	By calenderMenu = By.xpath("//a[text()='Calendar']");
	By newESubMenu = By.xpath("//a[text()='New Event']");
	By title =  By.id("title");
	By from = By.id("btnClear");
	By fromCal = By.id("f_trigger_c_start");
	String fromDaySelectionPart1 = "(//div[@class='calendar'])[29]//td[@class='day'][text()='";
	String fromDaySelectionPart2 = "']";
	By To = By.id("btnClear");
	By clear = By.id("btnClear");
	By toCal = By.id("f_trigger_c_end");
	String toDaySelectionPart1 = "(//div[@class='calendar'])[28]//td[@class='day'][text()='";
	String toDaySelectionPart2 = "']";
	
	By category = By.name("category");
	By add = By.xpath("//input[@value='==ADD==>']");
	String confPart1="//input[@name='confirmed' and @value='";
	String confPart2="Y']";
	String reminderMinPart1 = "//select[@name='reminder_minutes']/option[@value='";
	String reminderMinPart2 = "']";
	By note = By.name("reminder_note");
	By contactLookUp = By.xpath("//input[@name='contact_lookup']/following-sibling::input");
	By contactSearchBox = By.id("search");
	By contactSearchBtn = By.xpath("//input[@value='Search']");
	By tableItem =  By.xpath("(//input[@value='Set to None']/../..)/following-sibling::tr//td/a");
	String namePart1 = "(//input[@value='Set to None']/../..)/following-sibling::tr//td/a[contains(text(),'";
	String namePart2 = "')]";
	
	public EventPage(WebDriver driver) 
	{
		this.driver=driver;
		page = new PageManager(driver);
		genM = new GenericMethods(driver);
		base = new BaseTest();
	}
	
	public void doLogin(String username, String password) throws IOException, InterruptedException
	{
		page.getLoginPage().openCRMAPP();
		page.getLoginPage().login(username, password);
	}
	
	public void openEventPage() throws InterruptedException
	{
		page.getLoginPage().validateSuccessLogin();
		genM.mouseHover(calenderMenu);
		Thread.sleep(2000);

		genM.doClick(newESubMenu);
		Thread.sleep(2000);
		
	}
	
	public void fillEventDetails(String title, String toDay,  String formDay, String cat, String name) throws InterruptedException
	{
		genM.enterText(this.title, title);
		genM.doClick(from);
		Thread.sleep(2000);
		genM.doClick(fromCal);
		Thread.sleep(2000);
		genM.doClick(By.xpath(fromDaySelectionPart1+formDay+fromDaySelectionPart2));
		genM.doClick(To);
		Thread.sleep(2000);
		genM.doClick(toCal);
		genM.doClick(By.xpath(toDaySelectionPart1+toDay+toDaySelectionPart2));
		genM.SelectByValue(category, cat);
		genM.doClick(contactLookUp);
		genM.moveToChildWindow();
		genM.enterText(contactSearchBox, name);
		int total = genM.getElements(tableItem).size();
		for(int i = 1;i<=total;i++)
		{
			String tax = genM.grabText(By.xpath("(//input[@value='Set to None']/../..)/following-sibling::tr//td/a"));
			System.out.println(tax);
		}
		

	}

}
