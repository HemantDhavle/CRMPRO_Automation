package stepDefinations;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.CONSTANTS;
import utility.TestContextSetUp;

public class LoginStepDefination {

public TestContextSetUp testContextSetUp;
	public LoginStepDefination(TestContextSetUp testContextSetUp) 
	{
		this.testContextSetUp = testContextSetUp;
	}
	
	@Given("user is already on landing page'")
	public void user_is_already_on_landing_page() throws IOException, InterruptedException 
	{
		testContextSetUp.pm.getLoginPage().openCRMAPP();
	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() throws InterruptedException 
	{
	   testContextSetUp.pm.getLoginPage().login(CONSTANTS.username, CONSTANTS.password);
	   Thread.sleep(3000);
	}

	@Then("user should be able to login successfully")
	public void user_should_be_able_to_login_successfully() throws InterruptedException 
	{
		testContextSetUp.pm.getLoginPage().validateSuccessLogin();
	}

	@Then("logout option should be display")
	public void logout_option_should_be_display() 
	{
		boolean  loginLink = testContextSetUp.pm.getLoginPage().validateLogout();
		Assert.assertTrue(loginLink, "Logout link visible on UI");

	}


}
