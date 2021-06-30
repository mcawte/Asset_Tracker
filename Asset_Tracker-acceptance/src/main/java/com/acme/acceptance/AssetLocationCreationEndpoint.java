package com.acme.acceptance;

import static io.restassured.RestAssured.given;

import com.acme.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @Given("Given I have some valid asset location JSON")
    public void iHaveSomeValidAssetLocationJson() {
        validJson = "{\"timestampUtc\": 10, \"lng\": 30, \"lat\": 40}";
        request = given()
            .baseUri(config.get("acceptance.assets-endpoint"));
        request.accept("application/json");
        request.body(validJson);
    }

    @When("When I post the JSON to the asset location creation endpoint")
    public void iPostTheJsonToTheAssetLocationCreationEndpoint() {
        response = request.post();
    }

    @Then("I should receive a {int} response")
    public void iShouldReceive200Response(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @And("And the returned JSON should include a generated asset location id")
    public void iShouldReceiveResponse() {
        response.then().assertThat()
        .body("id", MatchesPattern
        .matchesPattern("[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}"));
    }
}
