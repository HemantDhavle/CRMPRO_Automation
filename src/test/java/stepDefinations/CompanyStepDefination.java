package stepDefinations;

import java.io.IOException;
import java.util.List;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.TestContextSetUp;

public class CompanyStepDefination {
	TestContextSetUp textContextSetUp;
	public CompanyStepDefination(TestContextSetUp textContextSetUp) 
	{
		this.textContextSetUp=textContextSetUp;
	}
	
	@When("user enters all the company information")
	public void user_enters_all_the_company_information(List<String> dataTable) throws InterruptedException, IOException 
	{
		textContextSetUp.pm.getCompanyPage().openCompanyRegistration();
	   String company_Name = dataTable.get(0);
	   String industry_Name = dataTable.get(1);
	   String annual_Revenue = dataTable.get(2);
	   String num_Employees = dataTable.get(3);
	   String status_dropDown= dataTable.get(4);
	   String cat_dropDown = dataTable.get(5);
	   String priority_dropDown = dataTable.get(6);
	   String source_dropDown = dataTable.get(7);
	   String identifier = dataTable.get(8);
	   String vNumber = dataTable.get(9);
	   String phone = dataTable.get(10);
	   String fax = dataTable.get(11);
	   String website = dataTable.get(12);
	   String email = dataTable.get(13);
	   String symbol = dataTable.get(14);
	   String comp_Search = dataTable.get(15);
	   System.out.println(comp_Search);
	   String add_Title = dataTable.get(16);
	   String default_add = dataTable.get(17);
	   String city = dataTable.get(18);
	   String postcode = dataTable.get(19);
	   String state = dataTable.get(20);
	   String country = dataTable.get(21);
	   String description = dataTable.get(22);
	  // String= dataTable.get(23);
	   
	   textContextSetUp.pm.getCompanyPage().doRegistration( company_Name,  industry_Name,  annual_Revenue,  num_Employees,
				 status_dropDown,  cat_dropDown,  priority_dropDown,  source_dropDown, 
				 identifier,  vNumber,  phone,  fax,  website,  email,  symbol, 
				 comp_Search,  add_Title,  default_add,  city,  postcode,  state,  country,  description);
	}

	@Then("company should be registered successfully")
	public void company_should_be_registered_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



}
