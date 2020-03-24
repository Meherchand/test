package com.BDD.Tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;


import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.response.Response;


public class allAboutCookies {

	@Test(priority=1)
	public void cookievalidation()
	{
		given()
		.when()
			.get("http://jsonplaceholder.typicode.com/photos")
		.then()
			.cookie("__cfduid","dc7938d467c6f02e2e07116a000ffc2d31559896449");
	}
	@Test(priority=2)
	public void testGetCookies()
	{
		Response res=get("http://jsonplaceholder.typicode.com/photos");
		String cookievalue=	res.getCookie("__cfduid");
		System.out.println(cookievalue);
		
		Map<String,String>cookieMap=res.getCookies();
		
		for( Map.Entry cookieValues:cookieMap.entrySet())
		{
			System.out.print(cookieValues.getKey()+"           "+cookieValues.getValue());
		}
	}
	
	@Test(priority=3)
	public void detailedInfoOfCookie()
	{
		Response res=get("http://jsonplaceholder.typicode.com/photos");
		Cookie cookieInfo=res.getDetailedCookie("__cfduid");
		System.out.println(cookieInfo.getExpiryDate());
	
		
		System.out.println(cookieInfo.getValue());
	}
	
	
}
