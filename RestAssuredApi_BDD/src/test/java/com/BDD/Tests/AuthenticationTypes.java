package com.BDD.Tests;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AuthenticationTypes {
	
	@Test
	public void basicAuth()
	{
		given()
			.auth().basic("ToolsQA", "TestPassword")
			//.auth().basic(userName, password)
			//.auth().preemptive()
		.when()
			.get("http://restapi.demoqa.com/authentication/CheckForAuthentication/")
		.then()
		.statusCode(200)
		.assertThat().body("FaultId",equalTo("OPERATION_SUCCESS"))
		.assertThat().body("Fault",equalTo("Operation completed successfully"))
		.log().all();
		
	}
	@Test
	public void bearerToken()
	{
	}

}
