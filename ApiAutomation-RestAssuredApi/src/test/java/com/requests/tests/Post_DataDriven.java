package com.requests.tests;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_DataDriven {
	
	@Test(dataProvider="dataSupplier")
	public void dataDrivenTest(String ename,String eage,String esal)
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification req= RestAssured.given();
		
		JSONObject json=new JSONObject();
		
		json.put("name",ename);
		json.put("salary",eage);
		json.put("age",esal);
		
		req.header("Content-Type","application/json");
		req.body(json.toJSONString());
		Response resp=req.request(Method.POST,"/create");
		String respayload=resp.body().asString();
		System.out.println(respayload);
	}
	
	@DataProvider
	public String[][] dataSupplier()
	{
		String empdata[][]={ {"abc18787233434","303898943434000","434xcxc3430"}, {"xyz12sdx34343","40334dsx3000","303sdx434"}, {"pqrsds13434323","80343sd4000","53sd430"}};
		return empdata;
	}

}
