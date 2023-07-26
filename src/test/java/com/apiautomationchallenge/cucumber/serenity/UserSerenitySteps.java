package com.apiautomationchallenge.cucumber.serenity;

import com.apiautomationchallenge.model.AddressClass;
import com.apiautomationchallenge.model.CompanyClass;
import com.apiautomationchallenge.model.GeoClass;
import com.apiautomationchallenge.model.UserClass;
import com.apiautomationchallenge.utils.ReusableSpecifications;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UserSerenitySteps {
	
	String endpoint = "/users";

    // Method to find a user by ID
    @Step("Getting user with ID: {0}")
    public ValidatableResponse findUserById(String userId) {
        return SerenityRest.rest()
                .given()
                .spec(ReusableSpecifications.getGenericRequestSpec())
                .when()
                .get(endpoint + "/" + userId)
                .then();
    }

    // Method to create a new user
    @Step("Creating user with name: {0}, username {1}, email: {2}, street: {3}, suit: {4}, city: {5}, zipCode: {6}, lat: {7}, lng: {8}, phone: {9}, website: {10}, companyName: {11}, catch_pharase: {12}, bs: {13}")
    public ValidatableResponse createUser(String name, String username, String email, String street, String suit, String city, String zipCode, String lat, String lng, String phone, String website, String companyName, String catchPharase, String bs) {
        // Create Company object
        CompanyClass company = new CompanyClass();
        company.setName(companyName);
        company.setCatchPhrase(catchPharase);
        company.setBs(bs);

        // Create Geo object
        GeoClass geo = new GeoClass();
        geo.setLat(lat);
        geo.setLng(lng);

        // Create Address object
        AddressClass address = new AddressClass();
        address.setStreet(street);
        address.setSuite(suit);
        address.setCity(city);
        address.setZipcode(zipCode);
        address.setPhone(phone);
        address.setWebsite(website);
        address.setGeo(geo);
        address.setCompany(company);

        // Create User object
        UserClass user = new UserClass();
        user.setName(name);
        user.setEmail(email);
        user.setAddress(address);

        return SerenityRest.rest()
                .given()
                .spec(ReusableSpecifications.getGenericRequestSpec())
                .when()
                .body(user)
                .post(endpoint)
                .then();
    }

    // Method to update an existing user
    @Step("Updating user with id: {0} name: {1}, username {2}, email: {3}, street: {4}, suit: {5}, city: {6}, zipCode: {7}, lat: {8}, lng: {9}, phone: {10}, website: {11}, companyName: {12}, catch_pharase: {13}, bs: {14}")
    public ValidatableResponse updateUser(Integer userId, String name, String username, String email, String street, String suit, String city, String zipCode, String lat, String lng, String phone, String website, String companyName, String catchPharase, String bs) {
        // Create Company object
        CompanyClass company = new CompanyClass();
        company.setName(companyName);
        company.setCatchPhrase(catchPharase);
        company.setBs(bs);

        // Create Geo object
        GeoClass geo = new GeoClass();
        geo.setLat(lat);
        geo.setLng(lng);

        // Create Address object
        AddressClass address = new AddressClass();
        address.setStreet(street);
        address.setSuite(suit);
        address.setCity(city);
        address.setZipcode(zipCode);
        address.setPhone(phone);
        address.setWebsite(website);
        address.setGeo(geo);
        address.setCompany(company);

        // Create User object
        UserClass user = new UserClass();
        user.setName(name);
        user.setEmail(email);
        user.setAddress(address);

        return SerenityRest.rest()
                .given()
                .spec(ReusableSpecifications.getGenericRequestSpec())
                .when()
                .body(user)
                .put(endpoint + "/" + userId)
                .then();
    }

    // Method to update the phone number of an existing user
    @Step("Update userId {0} with the phoneNumber {1}")
    public ValidatableResponse updatePhoneUser(Integer userId, String phone) {
        AddressClass address = new AddressClass();
        address.setPhone(phone);

        return SerenityRest.rest()
                .given()
                .spec(ReusableSpecifications.getGenericRequestSpec())
                .when()
                .body(address)
                .patch(endpoint + "/" + userId)
                .then();
    }

    // Method to delete an existing user
    @Step("Delete user with userId: {0}")
    public ValidatableResponse deleteUser(Integer userId) {
        return SerenityRest.rest()
                .given()
                .spec(ReusableSpecifications.getGenericRequestSpec())
                .when()
                .delete(endpoint + "/" + userId)
                .then();
    }

}