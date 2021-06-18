package org.acme.rest.json;

// import io.quarkus.test.junit.QuarkusTest;
// import io.restassured.http.ContentType;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.Assertions;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.CoreMatchers.is;

//@QuarkusTest
public class AssetModelTest {

    // @Test
    // public void testAssetEndpoint() {
    //     //Test get
    //     given().when().get("/assets").then()
    //     .statusCode(200)
    //     .body("size()", is(2))
    //     .body("[0].timestamp_utc", is(1492301050))
    //     .body("[0].lng", is(151.2099F))
    //     .body("[1].timestamp_utc", is(1046753105));

        
    //     //Test post
    //     String generatedUUID = given()
    //     .header("Content-Type", "application/json").contentType(ContentType.JSON)
    //     .when().body("{\"timestamp_utc\":1592301050, \"lng\":61.0, \"lat\":13.0}")
    //     .when().post("/assets").then()
    //     .statusCode(200)
    //     .extract().response().body().asString();
    //     Assertions.assertTrue(generatedUUID instanceof String, "deleteUUID is not a string");

    //     System.out.println("Generated UUID = " + generatedUUID);

    //     // Test getById
    //     given().when()
    //     .get("/assets/{id}", generatedUUID.replaceAll("^\"|\"$", "")) // This is gross.
    //     .then()
    //     .statusCode(200)
    //     .body("timestamp_utc", is(1592301050))
    //     .body("lng", is(61.0F))
    //     .body("lat", is(13.0F));

    //     //Test delete
    //     given()
    //     .header("Content-Type", "application/json")
    //     .when().delete("/assets/" + generatedUUID.replaceAll("^\"|\"$", "")).then()
    //     .statusCode(200);

        

        
    // }

}
