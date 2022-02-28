package com.acme.acceptance;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

import com.acme.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.text.MatchesPattern;

public class AssetLocationCreationEndpoint {
    private Config config;
    private String validJson;
    private RequestSpecification request;
    private Response response;

    public AssetLocationCreationEndpoint(Config config) {
        this.config = config;
    }

    @Given("I have some valid asset location JSON")
    public void iHaveSomeValidAssetLocationJson() {
        validJson = "{\"timestampUtc\": 10, \"lng\": 30, \"lat\": 40}";
        request = given()
            .baseUri(config.get("acceptance.assets-endpoint"))
            .contentType(ContentType.JSON)
        .body(validJson);
    }

    // @Given("I have some valid asset location JSON")
    // public void i_have_some_valid_asset_location_json() {
    //     // Write code here that turns the phrase above into concrete actions
    //     validJson = "{\"timestampUtc\": 10, \"lng\": 30, \"lat\": 40}";
    //     request = given()
    //         .baseUri(config.get("acceptance.assets-endpoint"));
    //     request.accept("application/json");
    //     request.body(validJson);
    //     //throw new io.cucumber.java.PendingException();
    // }

    @When("I post the JSON to the asset location creation endpoint")
    public void i_post_the_json_to_the_asset_location_creation_endpoint() {
        response = request.post();
    }

    @Then("I should receive a {int} status code response")
    public void iShouldReceiveStatusCodeResponse(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @And("the returned JSON should include a generated asset location id")
    public void the_returned_json_should_include_a_generated_asset_location_id() {
        String id = response.jsonPath().getString("id");
        System.out.println("The id is: " + id);
        assertThat(id, MatchesPattern
        .matchesPattern("[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}"));


        
    }
}
