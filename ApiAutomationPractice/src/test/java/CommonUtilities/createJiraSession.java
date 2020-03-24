package CommonUtilities;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class createJiraSession {

	static Properties prop= new Properties();
	

	public static String getJiraSession() throws IOException
	{
		FileInputStream ip = new FileInputStream("C:\\Users\\mnakka\\eclipse-workspace\\ApiAutomationPractice\\src\\test\\java\\config\\repository.properties");
		prop.load(ip);
		RestAssured.baseURI=prop.getProperty("jirahost");
		Response res=
		given()
			.header("Content-Type", "application/json")
			.body("{ \"username\":\"Meherchand\", \"password\":\"summeR3173!\"}")
		.when()
			.post("/rest/auth/1/session")
		.then()
				.extract().response();
				JsonPath js= getJsonAndXpathReponse.getJsonResponse(res);
			    String a="JSESSIONID=";
				String sessionid=js.get("session.value");
				//sessionid=a+sessionid;
			
				return sessionid;

			
				
	}
}
