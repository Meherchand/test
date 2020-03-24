package basics;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import CommonUtilities.createJiraSession;
import CommonUtilities.getJsonAndXpathReponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateAndCommentJiraIssue {
	
	public static String issueid;
	public static String commentid;
	
	@Test(priority=1)
	public void IssueCreation() throws IOException
	{
		RestAssured.baseURI="http://localhost:8081";
		Response res=
		given()
		.header("Cookie","JSESSIONID="+createJiraSession.getJiraSession())
		.header("Content-Type", "application/json")
		.body("{"+
			    "\"fields\": {"+
			       "\"project\":{"+
			          "\"key\": \"TES\""+
			       "},"+
			       "\"summary\": \"Issue created from RestAssured5\","+
			       "\"description\": \"RestAssured bug\","+
			       "\"issuetype\": {"+
			          "\"name\": \"Bug\""+
			       "}"+
			   "}}")
		
		.when()
			.post("/rest/api/2/issue")
		.then()
		.extract().response();
		
		JsonPath js= getJsonAndXpathReponse.getJsonResponse(res);
		issueid=js.get("id");
		System.out.print(issueid);
	}
	@Test(priority=2)
	public void createCommentOnaboveIssue() throws IOException
	{
		RestAssured.baseURI="http://localhost:8081";
		Response res=
		given()
			.header("Cookie","JSESSIONID="+createJiraSession.getJiraSession())
			.header("Content-Type", "application/json")
			.pathParam("Issueid", issueid)
			
			.body("{ \"body\": \"Inserting comment from the automation code\","+
				    "\"visibility\": {"+
				        "\"type\": \"role\","+
				        "\"value\": \"Administrators\" }"+
				"}")
		.when()
			.post("rest/api/2/issue/{Issueid}/comment")
		.then()
			.extract().response();
			JsonPath js=getJsonAndXpathReponse.getJsonResponse(res);
			commentid=js.get("id");
		
			
	}
	
	@Test(priority=3)
	public void updateComment() throws IOException
	{
		RestAssured.baseURI="http://localhost:8081";
		given()
			.header("Cookie","JSESSIONID="+createJiraSession.getJiraSession())
			.header("Content-Type", "application/json")
			.pathParam("Issueid", issueid)
			.pathParam("CommentId", commentid)
			
			.body("{ \"body\": \"updating comment from the automation code\","+
				    "\"visibility\": {"+
				        "\"type\": \"role\","+
				        "\"value\": \"Administrators\" }"+
				"}")
		.when()
			.put("rest/api/2/issue/{Issueid}/comment/{CommentId}")
		.then()
			.log().all();
	}
}
