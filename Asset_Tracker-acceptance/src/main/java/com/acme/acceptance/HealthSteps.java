package com.acme.acceptance;

import static io.restassured.RestAssured.given;

import com.acme.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HealthSteps {
    private Config config;
    private RequestSpecification request;
    private Response response;

    public HealthSteps(Config config) {
        this.config = config;
    }

    @Given("I have a health endpoint")
    public void iHaveAHealthEndpoint() {
        request = given()
            .baseUri(config.get("acceptance.health-endpoint"));
    }

    @When("I request its health")
    public void iRequestItsHealth() {
        response = request.get();
    }

    @Then("I should receive a {int} response")
    public void iShouldReceiveResponse(Integer statusCode) {
        response.then().statusCode(statusCode);
    }
}
