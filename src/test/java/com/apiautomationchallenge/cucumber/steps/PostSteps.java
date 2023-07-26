package com.apiautomationchallenge.cucumber.steps;

import static org.hamcrest.Matchers.equalTo;

import com.apiautomationchallenge.cucumber.serenity.PostSerenitySteps;
import com.apiautomationchallenge.utils.TestUtils;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class PostSteps {

    ValidatableResponse response;
    Integer postUserId;

    @Steps
    PostSerenitySteps steps;

    // Step to create a new post with the provided details
    @When("^I create a new post by providing the following UserId (.*) Title (.*) Body (.*)$")
    public void createPost(Integer userId, String title, String body) {

    	postUserId = userId;
        response = steps.createPost(postUserId, title, body);
        TestUtils.verifyResponseStatusCode(response, 201);
    }
    
    @Then("^I verify using the post Id that the user is created$")
    public void verifyAddedPosByUserId() {
        response.assertThat().body("userId", equalTo(postUserId));
    }
}