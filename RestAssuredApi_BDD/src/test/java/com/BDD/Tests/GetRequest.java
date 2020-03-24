package com.BDD.Tests;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequest {

	@Test
	public void getWeatherDetails()
	{
		given()
		
		.when()
				.get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
				
		.then()
				.assertThat().statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.assertThat().body("City",equalTo("Hyderabad"))
			
				.header("Content-Type", "application/json");
		
	}
}
