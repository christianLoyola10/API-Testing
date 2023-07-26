package com.apiautomationchallenge.cucumber.serenity;



import com.apiautomationchallenge.model.PostClass;
import com.apiautomationchallenge.utils.ReusableSpecifications;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PostSerenitySteps {
	
    String endpoint = "/posts";

    // Method to create a new post
    @Step("Creating post with userID: {0}, title {1}, body: {2}")
    public ValidatableResponse createPost(Integer postUserId, String title, String body) {
        // Create Post object
        PostClass post = new PostClass();
        post.setUserId(postUserId);
        post.setTitle(title);
        post.setBody(body);

        return SerenityRest.rest()
                .given()
                .spec(ReusableSpecifications.getGenericRequestSpec())
                .when()
                .body(post)
                .post(endpoint)
                .then();
    }
}