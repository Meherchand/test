package com.requests.tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postRequest {

	@Test
	public void registerCustomer()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RequestSpecification request=RestAssured.given();
		JSONObject reqpayload=new JSONObject(); 
		
		reqpayload.put("FirstName","xydddzabc1we989we23233");
		reqpayload.put("LastName","abcdd9898dxyz12wewe3222");
		reqpayload.put("UserName","xydddzabc989wew123221");
		reqpayload.put("Password","abddcx0909yz1sd23122");
		reqpayload.put("Email","xyz1dd23567wewabc2111@gmail.com");
		
		request.header("Content-Type","application/json");
		request.body(reqpayload.toJSONString());
		Response response=request.request(Method.POST,"/register");
		String responsepayload=response.body().asString();
		System.out.println(responsepayload);
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		String successcode=response.jsonPath().get("fault");
		System.out.println(successcode);
		
		
	}
	
}
