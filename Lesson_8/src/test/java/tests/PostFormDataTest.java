package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class PostFormDataTest extends BaseTest {

    @Test
    public void testPostFormDataPositive() {
        Response response = given()
                .baseUri(BASE_URL)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post(POST)
                .then()
                .log().all()
                .extract().response();

        assertEquals(response.getStatusCode(), 200, "Response status is not OK");

        assertEquals(response.jsonPath().getString("form.foo1"), "bar1", "Response body does not contain the expected value for foo1.");
        assertEquals(response.jsonPath().getString("form.foo2"), "bar2", "Response body does not contain the expected value for foo2.");
    }

    @Test
    public void testPostFormDataNegative() {
        Response response = given()
                .baseUri(BASE_URL)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo3", "bar3")
                .when()
                .post(POST)
                .then()
                .log().all()
                .extract().response();

        assertEquals(response.getStatusCode(), 200, "Response status is not OK");

        assertNotEquals(response.jsonPath().getString("form.foo3"), "default", "Response body contains the expected value for foo1.");
    }

    @Test
    public void testPostFormDataWithOutParameters() {
        given()
                .baseUri(BASE_URL)
                .when()
                .get(POST)
                .then()
                .log().all()
                .assertThat()
                .statusCode(404);
    }

}
