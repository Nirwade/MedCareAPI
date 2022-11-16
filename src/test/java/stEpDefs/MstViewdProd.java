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

public class MstViewdProd {
	
	Response response;
	RequestSpecification request;;
	String URI = "http://localhost:8009/medicare/json/data/mv/products";

	
	@Given("The base URI will be {string}")
	public void the_base_URI_will_be(String URI) { 
				
		RestAssured.given()
		.baseUri(URI);
	}

	@When("perfroming the Get operation")
	public Response perfroming_the_Get_operation() {
		
		request = RestAssured.given().baseUri(URI);
		response = request.get();
		String responsebody = response.getBody().asString();
		System.out.println("The response body is " + responsebody);
				return response;
		
	}

	@Then("The Responsecode is shown to be")
	public void the_Responsecode_is_shown_to_be() {
		
	String sessioid =response.getSessionId() ;
	System.out.println("the session id is " +sessioid);
	
	int Statuscode = response.getStatusCode();
	System.out.println("The status code is " +Statuscode );
	Assert.assertEquals(200, Statuscode);

	JsonPath jp1 = response.jsonPath();
	List <String> IDLis = jp1.get("id");
	System.out.println("The id list are " +IDLis);
	
		
	}


}


	

	
	