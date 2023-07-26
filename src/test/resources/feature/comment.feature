Feature: Testing different requests on the Comment application

Scenario: Get an existing comment and verify the response status code and response body
When I try to find an existing comment from the userId "8"
Then I must receive status code "200"

