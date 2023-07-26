package com.apiautomationchallenge.testbase;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

// TestBase class contains common setup for API tests.

public class TestBase {

    // BeforeClass annotation is used to define setup method to be executed once before running any test in the class.
    // init() method sets the base URI for REST Assured library, used in all API requests.

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    // This base URI will be used as the starting point for all API requests in the test suite.
}
