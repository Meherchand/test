package basics;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonUtilities.Reqpayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class extractResponseAndDataDriven {
	
	public static Properties prop=new Properties();
	
	@BeforeTest
	public void setUp() throws IOException
	{
		
		FileInputStream ip = new FileInputStream("C:\\Users\\mnakka\\eclipse-workspace\\ApiAutomationPractice\\src\\test\\java\\config\\repository.properties");
		prop.load(ip);
	}
	@Test
	public static void extractResponseThroughJsonPath()
	{
		RestAssured.baseURI=prop.getProperty("host");
	Response res=
			
		given()
		.queryParam("key", "qaclick123")
		.body(Reqpayload.getpayload())
	
		
	.when()
		.post("maps/api/place/add/json")
		
						
	
			.then()
				.extract().response();
				String output=res.asString();
				System.out.println(output);
				JsonPath js= new JsonPath(output);
				String language=js.get("status");
				System.out.println(language);
			//System.out.print( output);
			
				
	}

}
