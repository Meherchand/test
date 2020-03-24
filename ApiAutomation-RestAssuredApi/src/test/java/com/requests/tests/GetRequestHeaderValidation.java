package com.requests.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestHeaderValidation {

	
	@Test
	public void validateHeaders()
	{
		RestAssured.baseURI="https://maps.googleapis.com";
		RequestSpecification req=RestAssured.given();
		
		Response resp=req.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		String responsebody=resp.getBody().asString();
		//System.out.print(responsebody);
		
		int statuscode=resp.getStatusCode();
		System.out.println(statuscode);
		String header=resp.header("Content-Type");
		System.out.println(header);
		String contentEncoding=resp.header("Content-Encoding");
		System.out.println(contentEncoding);
		
		
	
		
	}
}
