package com.apiautomationchallenge.cucumber.steps;

import com.apiautomationchallenge.cucumber.serenity.CommentSerenitySteps;
import com.apiautomationchallenge.utils.TestUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class CommentSteps {

    ValidatableResponse response;

    @Steps
    CommentSerenitySteps steps;

    // Step to find an existing comment with the provided user ID
    @When("^I try to find an existing comment from the userId \"(.*)\"$")
    public void getPostByUserId(Integer userId) {
        response = steps.findCommentByUserId(userId).log().all();
    }

    // Step to verify that the response status code is 200
    @Then("^I must receive status code \"(.*)\"$")
    public void verifyResponseCode(Integer statusCode) {
        TestUtils.verifyResponseStatusCode(response, statusCode);
    }

}