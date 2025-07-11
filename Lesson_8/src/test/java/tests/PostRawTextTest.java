package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class PostRawTextTest extends BaseTest {


    @Test
    public void testPostRawTextPositive() throws IOException {
        String jsonBody = new String(Files.readAllBytes(Paths.get("src/test/resources/requestBody.json")));
        Response response = given()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .post(BASE_URL + POST)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        String str = response.jsonPath().getString("json.test");
        assertEquals(str, "value", "Response body does not contain the expected text.");
    }

    @Test
    public void testPostRawTextNegative() throws IOException {
        String jsonBody = new String(Files.readAllBytes(Paths.get("src/test/resources/requestBody.json")));
        Response response = given()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .post(BASE_URL + POST)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        ;

        String str = response.jsonPath().getString("json.test");
        assertNotEquals(str, "default", "Response body does not contain the expected text.");
    }
}
