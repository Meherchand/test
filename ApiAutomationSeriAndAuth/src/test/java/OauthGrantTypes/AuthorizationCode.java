package OauthGrantTypes;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthorizationCode {
	
	String accesstoken="";
	String code="";
	

	
	
	
	@Test(priority=1,enabled=false)
	public void GetCode() throws InterruptedException
	{
	
		String s="https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2FugF5k3tep4cBGWmMwjp7nXLWcs5eXKIv5ItCOI6RHCrnoG1joAEp03CrS_PP1d2bPFDQgtLZjB9Lg8Cz4pmXeh8&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&session_state=9ff85552b06c1e431e379aa6fbec5068e998065e..7693&prompt=consent#";
		String partial=s.split("&code")[1];
		 code=partial.split("&scope")[0];
		System.out.print(code);
		
	
	}
	
	@Test(priority=3)
	public void GetCourseList()
	{
		
		given()
		.queryParam("access_token",accesstoken)
		.when()
		.get("https://rahulshettyacademy.com/getCourse.php")
		.then()
		.log().body();
		
		
		
	}
	@Test(priority=2)
	public void GetAccessToken()
	{
		String res=
		given().urlEncodingEnabled(false)
		
		.queryParam("code","4%2FugHaT7wPH9CldCaH9ekEmRVevzV-Gs2Y8fFR_2HuhIw9fQHrqUNnAuHqIQl4wOa9S3de4WAjbXNWDwBsD2cHB1E")
		.queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParam("grant_type","authorization_code")
		
		.when().log().all()
			.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
			JsonPath js= new JsonPath(res);
			
			 accesstoken=js.getString("access-token");
			 System.out.print(code);
			System.out.print(accesstoken);
		
	}
	

}
