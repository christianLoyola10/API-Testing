package com.apiautomationchallenge.cucumber.steps;

import static org.hamcrest.Matchers.equalTo;

import com.apiautomationchallenge.cucumber.serenity.PhotoSerenitySteps;
import com.apiautomationchallenge.utils.TestUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class PhotoSteps {

    ValidatableResponse response;
    Integer photoId;
    String photoTitle;

    @Steps
    PhotoSerenitySteps steps;
    
    // Step to fully update a photo with the provided values
    @When("^I fully update a photo enrollment with following values PhotoId (\\d+) AlbumId (\\d+),Title (.*)url (.*),ThumbnailUrl (.*)$")
    public void updatePhoto(Integer id, Integer albumId, String title, String url, String thumbnailUrl) {
    	photoId = id;
    	photoTitle = title;
        response = steps.updatePhoto(id, albumId, title, url, thumbnailUrl);
    }

    // Step to check the confirmation about the successful enrollment update
    @Then("I must receive a positive confirmation about the photo enrollment successful updated")
    public void checkEnrrolmentPhotoUpdate () {
        TestUtils.verifyResponseStatusCode(response, 200);
        response.assertThat()
            .body("id", equalTo(photoId))
            .body("title", equalTo(photoTitle)).log().all();
    }

   
}