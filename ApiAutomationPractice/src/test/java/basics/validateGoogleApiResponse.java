package basics;

import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class validateGoogleApiResponse {
	
	
	
	@Test
	public void validateResponse()
	{
		RestAssured.baseURI="https://maps.googleapis.com";
		given()
			.queryParam("location","-33.8670522,151.1957362")
			.queryParam("radius","500")
			.param("key","AIzaSyBAb8Rv1w2aQbEg2kSFbCPYFL-MWS1bGwc")
			
		.when()
			.get("/maps/api/place/nearbysearch/json")
		
		.then()
			//.log().body()
		/*Using arrayconcept*/
			.assertThat().body("results[0].name",equalTo("Sydney"))
			.and()
			.contentType(ContentType.JSON)
			.and()
			//.body("results[0].place_id", equalTo("ChIJkeO_AzquEmsRUpGQn1ZK7Tg"))
			.and()
			.header("Server", "scaffolding on HTTPServer2");
	}

}
