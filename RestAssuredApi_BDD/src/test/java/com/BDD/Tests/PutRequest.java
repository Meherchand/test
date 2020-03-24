package com.BDD.Tests;

import java.util.HashMap;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.BDD.utils.RestUtils;

import io.restassured.RestAssured;

public class PutRequest {

	HashMap map=new HashMap();
	public int emp_id=11501;
	
	@BeforeClass
	public void dataprepare()
	{

		map.put("name",RestUtils.empName());
		map.put("salary",RestUtils.empSal());
		map.put("age",RestUtils.empAge());
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+emp_id;
	}
	@Test
	public void updateWithPut()
	{
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all();
			
	}
}
