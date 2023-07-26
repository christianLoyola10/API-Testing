Feature: Testing different requests on the User application

Scenario: Get an existing user and verify the response status code and response body
When I try to find an existing user with the ID "5"
Then I must receive status code 200


Scenario Outline:  Create a new user and verify the response status code and response body
 When I create a new user with by providing the following name <name>,username <username>email <email>,street <street>,suit <suit>,city <city>,zipCode <zipcode>,lat <lat>,lng <lng>,phone <phone>,website <website>,companyName <compay_name>,catch_pharase <catchPharase>,bs <bs>
 Then I verify using email id that the student is created
 
 Examples: 
|  name | username | email | street | suit | city | zipcode | lat | lng | phone | website | company_name | catch_phrase | bs |
| "John Doe" | "jdoe" | "jdoe@example.com" | "123 Main St" | "Suite 202" | "New York" | "10001" | "40.7128"| "-74.0060" | "(555) 555-1234" | "example.com" | "Example Co." | "Your success is our success." | "Quality products and services." |
| "Jane Smith" | "jsmith" | "jsmith@example.com" | "456 Park Ave" | "Suite 101" | "Los Angeles" | "90001" | "34.0522"| "-118.2437"| "(555) 555-5678" | "sample.com" | "Sample Inc." | "Innovative solutions for you." | "Cutting-edge technologies." |
| "Robert Johnson"| "rjohnson" | "rjohnson@example.com" | "789 Central St" | "Suite 303" | "Chicago" | "60601" | "41.8781"| "-87.6298" | "(555) 555-9876" | "test.com" | "Test Corp." | "We value our customers." | "Efficient and reliable services."|


Scenario Outline:  Update an entire user resource, verify the response status code and response body
When I fully update his enrollment with following values id <id> name <name>,username <username>email <email>,street <street>,suit <suit>,city <city>,zipCode <zipcode>,lat <lat>,lng <lng>,phone <phone>,website <website>,companyName <compay_name>,catch_pharase <catchPharase>,bs <bs>
Then I must receive a positive confirmation about the enrollment successful update

 Examples: 
| id |  name | username | email | street | suit | city | zipcode | lat | lng | phone | website | company_name | catch_phrase | bs |
| 2 | "Updated Name" | "jdoe_updated" | "updated@example.com" | "456 Main St" | "Apt 101" | "New York" | "10002" | "40.7123" | "-74.0056" | "(555) 555-5678" | "updated.com" | "Updated Co." | "Our success is your success." | "Innovative products and solutions." |


Scenario:  Update a phone number from an user, verify the response status code and response body
Given I have an userId "8" with a wrong phone number
When I update his phone number with the correct number which is "(145)124-"
Then I must receive a positive confirmation about the change I have done


Scenario:  delete an existing user and verify the response status code.
Given I have an userId "8"
When I delete this user
Then I must receive a positive confirmation about the deletion I have done
