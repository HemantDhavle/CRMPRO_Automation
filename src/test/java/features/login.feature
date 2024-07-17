Feature: Validate the login functionality

Scenario: Validate login with valid details
Given user is already on landing page'
When user enters valid username and password
Then user should be able to login successfully 
And logout option should be display