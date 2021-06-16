package resteasyjackson;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@QuarkusTest // Fails without this annotation?
public class JacksonResourceTest {
    
    @Test
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void testJacksonResource() {

        given()
        .when().get("/resteasy-jackson/quarks").then()
        .statusCode(200);

        String topQuark = given()
        .header("Content-Type", "application/json").contentType(ContentType.JSON)
        .when().body("{\"name\" : \"Top\" , \"description\" : \"The top quark is the most massive of all the quarks\"}")
        .when().post("/resteasy-jackson/quarks").then()
        .statusCode(200)
        .extract().response().body().asString();

        Assertions.assertTrue(topQuark instanceof String, "The top quark is the most massive of all the quarks");

        given()
        .header("Content-Type", "application/json").contentType(ContentType.JSON)
        .when().body("{\"name\" : \"Charm\" }")
        .when().delete("/resteasy-jackson/quarks").then()
        .statusCode(200);

    }
}
