package com.BDD.Tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ReadResponseInVariousWays {
	
	
	/*@Test
	public void getResponseAsString()
	{
		String responseBody= get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad").asString();
		System.out.println(responseBody);
	}*/

	@Test(priority=2)
	public void testExtractDetailsUsingPath()
	{
		String href=
		given()
		
			.when()
				.get("http://jsonplaceholder.typicode.com/photos/1")
				.then()
					.contentType(ContentType.JSON)
					.body("albumId", is(1))
					.extract().path("url");
		
		System.out.println("Extracted URL value is:"+href);
	}
	
	@Test(priority=3)
	public void extractPathinOneLine()
	{
		String thumurl=get("http://jsonplaceholder.typicode.com/photos/1").path("thumbnailUrl");
		String thumurl2=get("http://jsonplaceholder.typicode.com/photos/1").thenReturn().jsonPath().getString("thumbnailUrl");
	}
	
	@Test(priority=4)
	public void extractResponseforLaterUse()
	{
		Response res=
				given()
				.when()
				.get("http://jsonplaceholder.typicode.com/photos/1")
				.then()
				.extract().response();
	String path=res.path("title");
	int statuscode=res.getStatusCode();
		
	}
}
