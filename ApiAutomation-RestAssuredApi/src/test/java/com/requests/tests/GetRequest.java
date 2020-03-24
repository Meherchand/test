package com.requests.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	
	@Test
	public void getCityWeather()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httprequest=RestAssured.given();
		Response response=httprequest.request(Method.GET,"/Hy");
		//String responsepayload=response.getBody().toString();
		String responsepayload=response.getBody().asString();
		int statuscode=response.getStatusCode();
		String statusline=response.getStatusLine();
		System.out.println(responsepayload);
		System.out.println(statuscode);
		System.out.println(statusline);
		
		
	}

}
