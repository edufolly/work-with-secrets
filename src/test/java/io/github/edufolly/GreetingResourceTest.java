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
    public void testConfigEndpoint() {
        given()
                .when().get("/config")
                .then()
                .statusCode(200)
                .body("my-secret", is("change_me"),
                      "MY_UPPERCASE_SECRET", is("FOLDER VALUE"));
    }

    @Test
    public void testInjectedEndpoint() {
        given()
                .when().get("/injected")
                .then()
                .statusCode(200)
                .body("my-injected", is("change_me"));
    }

    @Test
    public void testUppercaseEndpoint() {
        given()
                .when().get("/uppercase")
                .then()
                .statusCode(200)
                .body("my-uppercase-secret", is("FOLDER VALUE"));
    }

}