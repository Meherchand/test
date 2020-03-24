package basics;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import CommonUtilities.getJsonAndXpathReponse;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class printingNodeValuesInJsonArray {
	
	
	@Test
	public void  printArray()
	{
		RestAssured.baseURI="https://maps.googleapis.com";
		Response res=
		given()
			.queryParam("location","-33.8670522,151.1957362")
			.queryParam("radius","500")
			.param("key","AIzaSyBAb8Rv1w2aQbEg2kSFbCPYFL-MWS1bGwc")
			.log().all()
			
		.when()
			.get("/maps/api/place/nearbysearch/json")
		
		.then()
		.extract().response();
		JsonPath js=getJsonAndXpathReponse.getJsonResponse(res);
		int resultsize=js.get("results.size()");
		System.out.print(resultsize);
		for(int i=0;i<resultsize;i++)
		{
			System.out.println(js.get("results["+i+"].name"));
		}
	}

}
