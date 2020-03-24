package com.BDD.Tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class validateSingleandMultipleContents {

	
	@Test
	public void testSingleContent()
	{
		given()
			.when()
			.get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
			.then()
				.body("City",equalTo("Hyderabad"));
				
	}
	
	
	@Test
	public void testMutipleContent()
	{
		given()
			.param("Myname", "Myvalue")
			.headers("test", "test")
			.when()
				.get("http://dummy.restapiexample.com/api/v1/employees")
				.then()
					.body("employee_salary",hasItems("123","1124"));
	}
}
