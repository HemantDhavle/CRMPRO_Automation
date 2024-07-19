package stepDefinations;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.CONSTANTS;
import utility.TestContextSetUp;

public class EventStepDefination {

	public TestContextSetUp testContextSetUp;
	public EventStepDefination(TestContextSetUp testContextSetUp) 
	{
		this.testContextSetUp = testContextSetUp;
	}
	
	@Given("User is already logged into the application")
	public void user_is_already_logged_into_the_application() throws IOException, InterruptedException {
	    
		testContextSetUp.pm.getEventPage().doLogin(CONSTANTS.username, CONSTANTS.password);
	}

	@When("user enters all the event information")
	public void user_enters_all_the_event_information() throws InterruptedException {
	    testContextSetUp.pm.getEventPage().openEventPage();
	}

	@When("Save the details")
	public void save_the_details() throws InterruptedException {
	  testContextSetUp.pm.getEventPage().fillEventDetails("Event2024", "20", "26", "Important","Ayush Khanna");
	}

	@Then("event should be registered successfully")
	public void event_should_be_registered_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
