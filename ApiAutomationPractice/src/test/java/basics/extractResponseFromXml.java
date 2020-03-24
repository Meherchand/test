package basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonUtilities.getJsonAndXpathReponse;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class extractResponseFromXml {
	
	Properties prop= new Properties();
	@BeforeTest
	
	public void setUp() throws IOException
	{
		FileInputStream ip = new FileInputStream("C:\\Users\\mnakka\\eclipse-workspace\\ApiAutomationPractice\\src\\test\\java\\config\\repository.properties");
		prop.load(ip);
	}
	
	
	@Test
	public void getValuesfromXMl()
	{
		
		RestAssured.baseURI=prop.getProperty("url");
		Response res=
		given()
		.when()
			.get("/sqlrest/CUSTOMER/15")
		.then()
			.extract().response();
			
			XmlPath x= getJsonAndXpathReponse.getXpathResponse(res);
			System.out.println(x.get("CUSTOMER.FIRSTNAME"));
			
		
	}

}
