package com.apiautomationchallenge.utils;

import java.util.Random;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;

// This class provides utility methods for testing APIs.

public class TestUtils {

	// Generates a random integer as a String.
	public static String getRandomValue() {
		Random random = new Random();
		int randomInt = random.nextInt(100000);
		return Integer.toString(randomInt);
	}
	
	// Verifies the response status code against the expected value.
	public static void verifyResponseStatusCode(ValidatableResponse response, Integer statusCode) {
		response.assertThat().statusCode(statusCode).spec(ReusableSpecifications.getGenericResponseSpec());
	}
}