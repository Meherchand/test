package com.requests.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Request_BasicAuth {
	
	@Test
	public void basicAuthorization()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		PreemptiveBasicAuthScheme basicAuth= new PreemptiveBasicAuthScheme();
		basicAuth.setUserName("ToolsQA");
		basicAuth.setPassword("TestPassword");
		RestAssured.authentication= basicAuth;
		RequestSpecification req=RestAssured.given();
		Response resp=req.request(Method.GET,"/");
		System.out.print(resp);
		int code=resp.getStatusCode();
		System.out.print(code);
		Assert.assertEquals(200, code);
		
		
	}

}
