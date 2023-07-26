package com.apiautomationchallenge.cucumber.steps;

import static org.hamcrest.Matchers.equalTo;

import com.apiautomationchallenge.cucumber.serenity.UserSerenitySteps;
import com.apiautomationchallenge.utils.TestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class UserSteps {

    ValidatableResponse response;
    String emailid;
    Integer userId;
    String phoneNumber;
    String userName;

    @Steps
    UserSerenitySteps steps;

    // Step to find an existing user with the provided ID
    @When("^I try to find an existing user with the ID \"(.*)\"$")
    public void getUser(String userId) {
        response = steps.findUserById(userId).log().all();
    }

    // Step to verify that the response status code is 200
    @Then("^I must receive status code 200$")
    public void verifyResponseCode() {
        TestUtils.verifyResponseStatusCode(response, 200);
    }

    // Step to create a new user with the provided details
    @When("^I create a new user with by providing the following name (.*),username (.*)email (.*),street (.*),suit (.*),city (.*),zipCode (.*),lat (.*),lng (.*),phone (.*),website (.*),companyName (.*),catch_pharase (.*),bs (.*)$")
    public void createUser(String name, String username, String email, String street, String suit, String city, String zipCode, String lat, String lng, String phone, String website, String companyName, String catchPharase, String bs) {

        emailid = TestUtils.getRandomValue() + email;
        response = steps.createUser(name, username, emailid, street, suit, city, zipCode, lat, lng, phone, website, companyName, catchPharase, bs);
        TestUtils.verifyResponseStatusCode(response, 201);
    }

    // Step to verify that the user was created successfully using the provided email ID
    @Then("^I verify using email id that the student is created$")
    public void verifyAddedUserByEmail() {
        response.assertThat().body("email", equalTo(emailid));
    }

    // Step to fully update a user's enrollment with the provided values
    @When("^I fully update his enrollment with following values id (\\d+) name (.*),username (.*)email (.*),street (.*),suit (.*),city (.*),zipCode (.*),lat (.*),lng (.*),phone (.*),website (.*),companyName (.*),catch_pharase (.*),bs (.*)$")
    public void updateUser(Integer id, String name, String username, String email, String street, String suit, String city, String zipCode, String lat, String lng, String phone, String website, String companyName, String catchPharase, String bs) {
        userName = name;
        emailid = email;
        userId = id;
        response = steps.updateUser(userId, name, username, email, street, suit, city, zipCode, lat, lng, phone, website, companyName, catchPharase, bs);
    }

    // Step to check the confirmation about the successful enrollment update
    @Then("I must receive a positive confirmation about the enrollment successful update")
    public void checkEnrrolmentUpdate () {
        TestUtils.verifyResponseStatusCode(response, 200);
        response.assertThat()
            .body("id", equalTo(userId))
            .body("email", equalTo(emailid))
            .body("name", equalTo(userName)).log().all();
    }

    // Step to have an existing user ID with a wrong phone number
    @Given("^I have an userId \"(.*)\" with a wrong phone number$")
    public void getName (Integer id) {
        userId = id;
    }

    // Step to update a user's phone number with the correct number
    @When("^I update his phone number with the correct number which is \"(.*)\"$")
    public void updatePhoneNumber (String phone){
        phoneNumber =  phone + TestUtils.getRandomValue();
        response = steps.updatePhoneUser(userId, phoneNumber).assertThat().log().all();
    }

    // Step to check the positive confirmation about the phone number update
    @Then("^I must receive a positive confirmation about the change I have done$")
    public void checkPhoneUpdate () {
        TestUtils.verifyResponseStatusCode(response, 200);
        response.assertThat()
            .body("id", equalTo(userId))
            .body("phone", equalTo(phoneNumber))
            .log().all();
        System.out.println("stop");
    }

    // Step to have an existing user ID
    @Given ("^I have an userId \"(.*)\"$")
    public void getUserId (Integer id) {
        userId = id;
    }

    // Step to delete the user with the provided user ID
    @When ("^I delete this user$")
    public void deleteUser() {
        response = steps.deleteUser(userId);
    }

    // Step to check the positive confirmation about the user deletion
    @Then ("^I must receive a positive confirmation about the deletion I have done$")
    public void checkRemovedUser() {
        TestUtils.verifyResponseStatusCode(response, 200);
    }
}