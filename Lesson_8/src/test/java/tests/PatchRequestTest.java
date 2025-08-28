package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class PatchRequestTest extends BaseTest {

    @Test
    public void testPatchRequestPositive() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch(BASE_URL + PATCH)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        String responseDataBody = response.jsonPath().getString("data");
        assertEquals(responseDataBody, "This is expected to be sent back as part of response body.", "Response body does not contain the expected text.");
    }

    @Test
    public void testPatchRequestPositiveParam() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .queryParam("foo2", "bar2")
                .patch(BASE_URL + PATCH)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();


        String responseDataBody = response.jsonPath().getString("data");
        String responseArgsParam = response.jsonPath().getString("args.foo2");
        assertEquals(responseDataBody, "This is expected to be sent back as part of response body.", "Response body does not contain the expected text.");
        assertEquals(responseArgsParam, "bar2", "Response body does not contain the expected text.");

    }

    @Test
    public void testPatchRequestWithOutParametersBody() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .patch(BASE_URL + PATCH)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        String responseDataBody = response.jsonPath().getString("data");
        assertFalse(responseDataBody.equals("This is expected to be sent back as part of response body."), "Response body does not contain the expected text.");
    }

    @Test
    public void testPatchRequestWithOutParameters() {
        given()
                .baseUri(BASE_URL)
                .when()
                .get(PATCH)
                .then()
                .log().all()
                .assertThat()
                .statusCode(404);
    }
}
