package com.BDD.Tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;

public class headersAndParameters {
	
	/*@Test(priority=1)
	public void headerVerify()
	{
		given()
			.param("type","supermarket")
			.param("key","AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s")
		.when()
			.get("https://maps.googleapis.com/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500")
		.then()
			.header("Content-Type","application/xml; charset=UTF-8")
			.and()
			.header("Server", "scaffolding on HTTPServer2");
	}*/
	@Test(priority=2)
	public void verifyHeaderWithResponseObject()
	{
		Response res=
		given()
		.queryParam("type","supermarket")
		
		.queryParam("location", "-33.8670522,151.1957362&radius=1500")
		.param("key","AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s")
		.when()
		.get("https://maps.googleapis.com/maps/api/place/nearbysearch/xml");
		
	
		
		String ContentType=res.getHeader("Content-Type");
		System.out.println(ContentType);
		io.restassured.http.Headers	headerRef=	res.getHeaders();
		
		for(Header h:headerRef)
		{
			System.out.println(h.getName()+"   "+ h.getValue());
		}
	}
}
