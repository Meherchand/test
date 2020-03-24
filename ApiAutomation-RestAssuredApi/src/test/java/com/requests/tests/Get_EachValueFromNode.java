package com.requests.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_EachValueFromNode {
	
	@Test
	public void getValueFromNode()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification req=RestAssured.given();
		Response resp=req.request(Method.GET,"/Delhi");
		
		JsonPath path=resp.jsonPath();
		System.out.println(path.get("City"));
		
				
		
	}

}
