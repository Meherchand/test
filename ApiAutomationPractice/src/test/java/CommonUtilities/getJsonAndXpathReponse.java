package CommonUtilities;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class getJsonAndXpathReponse {

	
	public static XmlPath getXpathResponse(Response r)
	{
		String output=r.body().asString();
		XmlPath x= new XmlPath(output);
		return x;
	}
	
	public static JsonPath getJsonResponse(Response r)
	{
		String output=r.body().asString();
		JsonPath js= new JsonPath(output);
		return js;
	}
}
