package io.github.edufolly;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

/**
 * @author Eduardo Folly
 */
@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/config")
                .then()
                .statusCode(200)
                .body("my-secret", is("change_me"));
    }

}