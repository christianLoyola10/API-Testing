package com.apiautomationchallenge.cucumber.serenity;

import com.apiautomationchallenge.utils.ReusableSpecifications;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CommentSerenitySteps {
	
	String endpoint = "/comments";

    // Method to find a comment by user ID
    @Step("Getting a comment by user ID: {0}")
    public ValidatableResponse findCommentByUserId(Integer userId) {
        return SerenityRest.rest()
                .given()
                .spec(ReusableSpecifications.getGenericRequestSpec())
                .when()
                .get(endpoint + "/" + userId)
                .then();
    }

}