Feature: Validate event feature

Scenario: Calendar Event
Given User is already logged into the application
When user enters all the event information
And Save the details
Then event should be registered successfully