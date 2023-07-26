package com.apiautomationchallenge.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

// This class provides reusable specifications for API requests and responses.

public class ReusableSpecifications {
	
	// Declare static variables for Request and Response specifications.
	public static RequestSpecBuilder rspec;
	public static RequestSpecification requestSpecification;
	public static ResponseSpecBuilder respec;
	public static ResponseSpecification responseSpecification;
	
	// Returns a generic RequestSpecification with JSON content type.
	public static RequestSpecification getGenericRequestSpec() {
		rspec = new RequestSpecBuilder();
		rspec.setContentType(ContentType.JSON);
		requestSpecification = rspec.build();
		return requestSpecification;
	}
	
	// Returns a generic ResponseSpecification with expected header values.
	public static ResponseSpecification getGenericResponseSpec() {
		respec = new ResponseSpecBuilder();
		respec.expectHeader("Content-Type", "application/json; charset=utf-8");
		responseSpecification = respec.build();
		return responseSpecification;
	}
}
