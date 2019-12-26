package restcalls;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestAssuredAPI {
	


	public static String baseURL;
	
	public static void baseURL(String baseURL){
		RestAssured.baseURI = baseURL;
		
	}
	
	
	public void GET(String urlPath){
		
		baseURL(urlPath);
		Response response =RestAssured
		.given()
		.accept(ContentType.JSON)
		.when()
		.get(urlPath)
		.then().extract().response();
		
		System.out.println("Status code:"+response.statusCode());
		System.out.println("Response of GET is:"+response.getBody().asString());
		
	}
	
	
	public static void GETSpecific(String urlPath){
		
		baseURL(urlPath);
		Response response =RestAssured
		.given()
		.accept(ContentType.JSON)
		.when()
		.get(urlPath)
		.then().extract().response();
		
		System.out.println("Status code:"+response.statusCode());
		System.out.println("Response of GET is:"+response.getBody().asString());
		
	}
	
	public static Response POST(String body, String urlPath){
		baseURL(urlPath);
		System.out.println("URL Path is: "+urlPath);
		Response response =RestAssured
				.given()
				.accept(ContentType.JSON) 
				.contentType(ContentType.JSON)
				.body(body)
				.when()
				.post(urlPath)
				.andReturn();
				
				System.out.println("Status code:"+response.statusCode());
				System.out.println("Shalu is present?:"+response.asString().contains("Shalu"));
				System.out.println("Response is:"+response.getBody().asString());
				
				return response;
				
	}
	
	public static void PUT(String body, String urlPath){
		baseURL(urlPath);
		
		System.out.println("URL Path is: "+urlPath);
		Response response =RestAssured
				.given()
				.accept(ContentType.JSON) 
				.contentType(ContentType.JSON)
				.body(body)
				.when()
				.put(urlPath)
				.andReturn();
				
				System.out.println("Status code:"+response.statusCode());
				System.out.println("Shalu is present?:"+response.asString().contains("Shalu"));
	
	}
	


}
