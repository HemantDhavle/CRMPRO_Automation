package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pages.PageManager;

public class TestContextSetUp {
	public WebDriver driver;
	public PageManager pm;
	public BaseTest base;
	public TestContextSetUp() throws IOException 
	{
		base = new BaseTest();
		pm =  new PageManager(base.getDriver());
	}

}
