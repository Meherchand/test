package com.BDD.Tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class variousLogs {


	//@Test(priority=1)
	void testLogging1()
	{
		given()
			.when()
				.get("https://reqres.in/api/users?page=2")
		.then()
			//.log().body()
			//.log().headers()
			//.log().cookies()
			.log().all();
	}
	
	@Test(priority=2)
	void testLogging2()
	{
		given()
			.when()
				.get("https://reqres.in/api/users/23")
		.then()
			//.log().ifError()
			//.log().ifStatusCodeIsEqualTo(401)
			.log().ifValidationFails()
			.statusCode(200);
	
}
}
