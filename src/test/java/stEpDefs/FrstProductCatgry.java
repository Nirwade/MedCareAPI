package stEpDefs;


import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FrstProductCatgry {
	
	RequestSpecification request;
	Response response;
	String URI = "http://localhost:8009/medicare/json/data/category/1/products";   

	
	@Given("The base URI is shown as {string}")
	public void the_base_URI_is_shown_as(String URI) { 
	     RestAssured.given()
	     .baseUri(URI);
		
	}

	@When("I perfromed the Get Operation")
	public Response i_perfromed_the_Get_Operation() {
		
		request = RestAssured.given().baseUri(URI);
        response = request.get();
		
		String Responsebody = response.getBody().asString();
		System.out.println("The response body is " + Responsebody);
		Assert.assertTrue(Responsebody.contains("name"));
		return response;
	   
	}

	@Then("The ResponseCode will be shown as")
	public void The_ResponseCode_will_be_shown_as() {
		
		
		
		String Responsebody = response.getBody().asString();
		System.out.println("The responsebody is " +Responsebody);
		int status = response.getStatusCode();
		org.junit.Assert.assertEquals(200, status);
		System.out.println("status code is successful -->  " + status );
		
			   	
		
	}

}
