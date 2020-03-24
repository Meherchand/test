package basics;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class postRequest {
	
	@Test
	public void sendBodywithoutMap()
	{
		RestAssured.baseURI="http://216.10.245.166/";
		
		given()
			.param("key","qaclick123")
			/*java.lang.IllegalStateException: You can either send form parameters OR body content in POST, not both!, So here query parameter should be added */
			
			.body("{"+
					  "\"location\": {"+
					    "\"lat\": -33.8669710,"+
					    "\"lng\": 151.1958750"+
					  "},"+
					  "\"accuracy\": 50,"+
					  "\"name\": \"Google Shoes!\","+
					  "\"phone_number\": \"(02) 9374 4000\","+
					  "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","+
					  "\"types\": [\"shoe_store\"],"+
					  "\"website\": \"http://www.google.com.au/\","+
					  "\"language\": \"en-AU\""+
					"}")
			.when()
				.post("maps/api/place/add/")
			.then()
				//.assertThat().body("language", equalTo("French-IN"));
				.log().body();
				
						
		
	}

}
