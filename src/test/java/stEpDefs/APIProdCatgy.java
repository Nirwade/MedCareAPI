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

public class APIProdCatgy {
	
         Response response;
         RequestSpecification request;
	
@Given("The base url {string}")
public void the_base_url(String URL) {
	
     URL = "http://localhost:8009/medicare/json/data/category/1/products";
}

@When("I hit the endpoint {string}")
public Response i_hit_the_endpoint(String URL) {
	
	request = RestAssured.given().baseUri(URL);
	response=request.get();
	return response;
}

@Then("I get {int} products")
public void i_get_products(int statuscode) {
	
String Responsebody = response.body().asString();
System.out.println("Response body is " + Responsebody);

  statuscode = response.getStatusCode();
  System.out.println("The status code is " + statuscode);
  Assert.assertEquals(200, statuscode);
}

@Then("validate the count")
public void validate_the_count() {
	
	JsonPath jp =response.jsonPath();
	List<String> listnames =jp.get("name");
	System.out.println("The list of names are" + listnames);
	}


@Then("I validate the {string} {string} {int} following")
public void i_validate_the_following(String name, String brand, int id) {
   
     JsonPath jp1 = response.jsonPath();
     List< String> actual  = jp1.get("name");
     String frstname = actual.get(0);
     String sendname = actual.get(1);
     System.out.println("------ frstname is " + frstname);
     System.out.println("------ secndname is " + sendname);

      JsonPath jp2 = response.jsonPath();
      List<String> actual1  = jp2.get("brand");
      String brandname1  = actual1.get(0);
      String brandname2  = actual1.get(1);

      Assert.assertEquals(brand, brandname1);
      Assert.assertEquals(brand, brandname2);
      
      JsonPath jp3 = response.jsonPath();
      List <Integer> ids  = jp3.get("id");
                          
    System.out.println("the list of id's are " +ids);
          
      }

}



