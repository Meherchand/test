package com.requests.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class JsonResponseValidation {
	
	@Test
	public void validateJsonResponse()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification req=RestAssured.given();
		Response resp=req.request(Method.GET,"/Hyderabad");
		String responsebody=resp.getBody().asString();
		System.out.println(responsebody);
		Assert.assertEquals("Hyderabad", responsebody.contains("pak"),true);
		
	
		
	}

}
