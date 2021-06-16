package resteasyjackson;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public class JacksonResourceTest {
    
    @Test
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void testJacksonResource() {

        given().when().get("/resteasy-jackson/quarks").then()
        .statusCode(200);
    }
}
