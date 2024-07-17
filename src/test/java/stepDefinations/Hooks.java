package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utility.TestContextSetUp;

public class Hooks {
	public WebDriver driver;
	TestContextSetUp testContextSetUp;

	public Hooks(TestContextSetUp testContextSetUp) 
	{
		this.testContextSetUp = testContextSetUp;
	}
	
	@After
	public void tearDown() throws IOException
	{
		testContextSetUp.base.getDriver().quit();
	}
	
	@AfterStep
	public void screenshot(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			TakesScreenshot ts =(TakesScreenshot)testContextSetUp.base.getDriver();
			File file = ts.getScreenshotAs(OutputType.FILE);
			byte[] arry = FileUtils.readFileToByteArray(file);
			scenario.attach(arry, "image/png", "image");
		}
	}

}
