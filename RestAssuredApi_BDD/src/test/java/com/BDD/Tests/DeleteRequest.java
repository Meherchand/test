package com.BDD.Tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteRequest {

	
	@Test
	public void deletedata()
	{
		Response response=
		given()
			.baseUri("http://dummy.restapiexample.com/api/v1")
			.basePath("/delete/11501")
		.when()
			.delete()
		.then()
			.log().all()
			.extract().response();
			String responsebody=response.body().asString();
			Assert.assertEquals(responsebody.contains("successfully! deleted Records"), true);
		
	}
}
