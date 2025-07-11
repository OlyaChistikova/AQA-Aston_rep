package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PutRequestTest extends BaseTest {

    @Test
    public void testPutRequestPositive() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put(BASE_URL + PUT)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        ;

        String responseDataBody = response.jsonPath().getString("data");
        assertEquals(responseDataBody, "This is expected to be sent back as part of response body.", "Response body does not contain the expected text.");
    }

    @Test
    public void testPutRequestWithOutParamsBody() {
        Response response = given()
                .when()
                .put(BASE_URL + PUT)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        ;

        String responseDataBody = response.jsonPath().getString("content-length");
        assertEquals(responseDataBody, null, "Response body does not contain the expected text.");
    }

    @Test
    public void testPutRequestWithOutParameters() {
        given()
                .baseUri(BASE_URL)
                .when()
                .get(PUT)
                .then()
                .log().all()
                .assertThat()
                .statusCode(404);
    }
}
