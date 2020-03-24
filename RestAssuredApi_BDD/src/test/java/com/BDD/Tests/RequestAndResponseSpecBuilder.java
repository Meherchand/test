package com.BDD.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RequestAndResponseSpecBuilder {
	
	RequestSpecification reqspec;
	ResponseSpecification respspec;

	@BeforeClass
	public void requestAndResonseSpecifics()
	{
			RequestSpecBuilder reqbuilder= new RequestSpecBuilder();
			reqbuilder.addParam("myparam", "paramValue1");
			reqbuilder.addHeader("myheader", "headerValue1");
			reqbuilder.setBaseUri("https://jsonplaceholder.typicode.com");
			reqbuilder.setContentType("ContentType.JSON");
			reqspec=reqbuilder.build();
			
			ResponseSpecBuilder respbuilder = new ResponseSpecBuilder();
			respbuilder.expectStatusCode(200);
			respbuilder.expectStatusLine("HTTP/1.1 200 OK");
			respbuilder.expectHeader("Content-Encoding","gzip");
			respspec=respbuilder.build();
			
			
	}
	@Test
	public void test1()
	{
		given()
				.spec(reqspec)
		.when()
			.get("/users/1/albums")
		.then()
			.spec(respspec)
			.log().all();
	}
	@Test
	public void test2()
	{
		given()
			.spec(reqspec)
		.when()
			.get("/users/1/todos")
		.then()
				.spec(respspec);
				
	}
}
