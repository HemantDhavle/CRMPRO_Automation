package pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import utility.BaseTest;
import utility.CONSTANTS;
import utility.GenericMethods;

public class CompanyPage {

	public PageManager page;
	public GenericMethods genM;
	public BaseTest base;
	public WebDriver driver;
	public CompanyPage(WebDriver driver) 
	{
		this.driver=driver;
		page = new PageManager(driver);
		genM = new GenericMethods(driver);
		base = new BaseTest();
	}
	public By company_Menu = By.xpath("//a[text()='Companies']");
	public By new_company = By.xpath("//a[text()='New Company']");
	public By company_Name = By.name("company_name");
	public By industry_Name = By.name("industry");
	public By annual_Revenue = By.id("annual_revenue");
	public By num_Employees = By.id("num_of_employees");
	public By status_dropDown =  By.name("status");
	public By cat_dropDown  = By.name("category");
	public By priority_dropDown  = By.name("priority");
	public By source_dropDown = By.name("source");
	public By identifier = By.name("identifier");
	public By vNumber = By.id("vat_number");
	public By phone = By.id("phone");
	public By fax = By.id("fax");
	public By website = By.id("website");
	public By email = By.id("email");
	public By symbol = By.id("symbol");
	public By parentLookUp = By.xpath("(//input[@name='client_lookup'])//following-sibling::input");
	public By comp_Search_LU = By.id("search");
	public By comp_btn_LU = By.xpath("//input[@value='Search']");
	public String comp_result_part1 = "//a[text()='";
	public String comp_result_part2 = "']";
	public By add_Title = By.name("address_title");
	public By default_add = By.xpath("//textarea[@name='address']");
	public By city = By.name("city");
	public By state = By.name("state");
	public By postcode = By.name("postcode");
	public By country = By.name("country");
	public By description = By.xpath("//textarea[@id='service']");
	public By save = By.xpath("//input[@value='Save']");

	public void openCRM() throws IOException, InterruptedException
	{
		page.getLoginPage().openCRMAPP();
		page.getLoginPage().login(CONSTANTS.username, CONSTANTS.password);
	}
	
	public void openCompanyRegistration() throws IOException, InterruptedException
	{
		
		page.getLoginPage().validateSuccessLogin();
		genM.mouseHover(company_Menu);
		Thread.sleep(2000);

		genM.doClick(new_company);
		Thread.sleep(2000);
		
//		Thread.sleep(2000);
//		Actions act = new Actions(driver);
//		act.moveToElement(genM.getElement(company_Menu)).perform();
//		genM.doClick(new_company);
//		Thread.sleep(2000);
	}
	
	public void doRegistration(String company_Name, String industry_Name, String annual_Revenue, String num_Employees,
			String status_dropDown, String cat_dropDown, String priority_dropDown, String source_dropDown, 
			String identifier, String vNumber, String phone, String fax, String website, String email, String symbol, 
			String comp_Search, String add_Title, String default_add, String city, String postcode, String state, String country, String description) throws InterruptedException
	{
		genM.enterText(this.company_Name, company_Name);
		genM.enterText(this.industry_Name, description);
		genM.enterText(this.annual_Revenue, annual_Revenue);
		genM.enterText(this.num_Employees, num_Employees);
		genM.SelectByValue(this.status_dropDown, status_dropDown);
		genM.SelectByValue(this.cat_dropDown, cat_dropDown);
		genM.SelectByValue(this.priority_dropDown, priority_dropDown);
		genM.SelectByValue(this.source_dropDown, source_dropDown);
		genM.enterText(this.identifier, identifier);
		genM.enterText(this.vNumber, vNumber);
		genM.enterText(this.phone, phone);
		genM.enterText(this.fax, fax);
		genM.enterText(this.website, website);
		genM.enterText(this.email, email);
		genM.enterText(this.symbol, symbol);
		genM.doClick(parentLookUp);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		Thread.sleep(2000);
		genM.enterText(comp_Search_LU, comp_Search);
		genM.doClick(comp_btn_LU);
		Thread.sleep(2000);
		String comp = comp_result_part1+comp_Search+comp_result_part2;
		driver.findElement(By.xpath(comp)).click();
		//genM.doClick(comp_result_part1, comp_Search, comp_result_part2);
		Thread.sleep(3000);
		driver.switchTo().window(parent);
		
		//genM.enterText(this.add_Title, add_Title);
		genM.enterText(this.default_add, default_add);
		genM.enterText(this.city, city);
		genM.enterText(this.postcode, postcode);
		genM.enterText(this.state, state);
		genM.enterText(this.country, country);
		genM.enterText(this.description, description);
		genM.doClick(save);
		
	}
	

}
