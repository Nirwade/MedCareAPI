package stEpDefs;

import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MstPurchsdProd {
	
	RequestSpecification request;
	Response response;
	String URI = "http://localhost:8009/medicare/json/data/mp/products";
	
	@Given("The base URI added as {string}")
	public void the_base_URI_added_as(String URI) { 
	   
		RestAssured.baseURI = URI;
	     RestAssured.given();
              
	}

	@When("I Perfrom The Get Operation")
	public Response i_Perfrom_The_Get_Operation() {
		
	request = RestAssured.given().baseUri(URI);
	response = request.get();
		
	String Responsebody = response.getBody().asString();
	System.out.println("The response body is " + Responsebody);
	Assert.assertTrue(Responsebody.contains("name"));
	return response;
	  
	}

	@Then("The Responsecode Should be")
	public void the_Responsecode_Should_be() {
		
		int Statuscode = response.getStatusCode();
		System.out.println("The status code is " +Statuscode );
		Assert.assertEquals(200, Statuscode);

		JsonPath jp2 = response.jsonPath();
		List <String> IDLis = jp2.get("id");
		System.out.println("The id list are" +IDLis);
		
		JsonPath jp3 = response.jsonPath();
		List <String> nameLis = jp3.get("name");
		System.out.println("The name list are" +nameLis);
	   
	}




}
