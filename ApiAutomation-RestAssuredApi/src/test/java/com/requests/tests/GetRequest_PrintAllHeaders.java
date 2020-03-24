package com.requests.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest_PrintAllHeaders {
	
	@Test
	public void getAllheaders()
	{
		RestAssured.baseURI="https://maps.googleapis.com";
		RequestSpecification req=RestAssured.given();
		Response resp=req.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		Headers allheaders=resp.getHeaders();
		for( Header headervalue:allheaders)
		{
			System.out.println(headervalue.getName()+"   "+headervalue.getValue());
		}
		
	}

}
