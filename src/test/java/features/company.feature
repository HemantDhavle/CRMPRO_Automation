Feature: Validate company feature

Scenario: Add company
Given User is already logged into the application
When user enters all the company information
|IBM|
|IT|
|12M|
|1200|
|Hot|
|Client|
|High|
|Event|
|IBM123|
|12312313123|
|9594595229|
|9594595229|
|www.ibm.com|
|test@ibm.com|
|BEE|
|Amazon|
|IBM-Indore|
|431-EK, Scheme No 54|
|Indore|
|MP|
|452010|
|India|
|IBMTAG|
|Test Description|
And Save the details
Then company should be registered successfully