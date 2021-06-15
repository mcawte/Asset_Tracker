package org.acme.rest.json;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AssetResourceTest {
    
    @Test
    public void testAssetEndpoint() {
        given()
          .when().get("/assets")
          .then()
             .statusCode(200)
             .body("size()",is(2))
             .body("[0].timestamp_utc",is(1492301050))
             .body("[1].timestamp_utc",is(1046753105));
    }
}
