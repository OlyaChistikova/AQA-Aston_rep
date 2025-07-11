package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class DeleteRequestTest extends BaseTest {

    @Test(description = "Позитивная проверка на возвращаемый body ответа")
    public void testDeleteRequestPositive() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete(BASE_URL + DELETE)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        ;


        String responseDataBody = response.jsonPath().getString("data");
        assertEquals(responseDataBody, "This is expected to be sent back as part of response body.", "Response body does not contain the expected text.");
    }

    @Test(description = "Негативная проверка на body и параметр foo2")
    public void testDeleteRequestNegative() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .queryParam("foo2", "bar2")
                .delete(BASE_URL + DELETE)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        ;

        String responseDataBody = response.jsonPath().getString("data");
        String responseArgsParam = response.jsonPath().getString("args.foo2");
        assertNotEquals(responseDataBody, "This is not expected part of response body.", "Response body contains the expected text.");
        assertEquals(responseArgsParam, "bar2", "Response body does not contain the expected text.");

    }


    @Test(description = "Негативная проверка без параметров в body")
    public void testDeleteRequestWithOutParameters() {
        given()
                .baseUri(BASE_URL)
                .when()
                .get(DELETE)
                .then()
                .log().all()
                .assertThat()
                .statusCode(404);
    }
}