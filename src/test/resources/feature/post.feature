Feature: Testing different requests on the post application

Scenario Outline:  Create a new post and verify the response status code and response body
 When I create a new post by providing the following UserId <userId> Title <title> Body <body>
 Then I verify using the post Id that the user is created
 
 Examples: 
|  userId | title | body |
| 1 | "First Post" | "This is the body of the first post." |
| 5 | "Second Post" | "This is the body of the second post." |
| 9 | "Third Post" | "This is the body of the third post." |
