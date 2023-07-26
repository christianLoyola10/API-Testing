package com.apiautomationchallenge.cucumber.serenity;

import com.apiautomationchallenge.model.PhotoClass;
import com.apiautomationchallenge.utils.ReusableSpecifications;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PhotoSerenitySteps {
	
	String endpoint = "/photos";

    // Method to update an existing photo
    @Step("Updating comment with its id: {0} albumId: {1}, title {2}, url: {3}, thumbnailUrl: {4}")
    public ValidatableResponse updatePhoto(Integer photoId, Integer albumId, String title, String url, String thumbnailUrl) {
        
    	// Create Photo object
        PhotoClass photo = new PhotoClass();
        photo.setAlbumId(albumId);
        photo.setTitle(title);
        photo.setUrl(thumbnailUrl);
        photo.setThumbnailUrl(thumbnailUrl);

      

        return SerenityRest.rest()
                .given()
                .spec(ReusableSpecifications.getGenericRequestSpec())
                .when()
                .body(photo)
                .put(endpoint + "/" + photoId)
                .then();
    }

}