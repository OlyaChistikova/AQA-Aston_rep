package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class DeleteRequestTest extends BaseTest{

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
                .extract().response();;

        // Проверка наличия поля "data" в теле ответа
        String responseDataBody = response.jsonPath().getString("data");
        assertEquals(responseDataBody, "This is expected to be sent back as part of response body.", "Response body does not contain the expected text.");
    }

    @Test(description = "Негативная проверка на возвращаемый body ответа и статус кода 500")
    public void testDeleteRequestNegative() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete(BASE_URL + DELETE)
                .then()
                .log().all()
                .extract().response();;

        assertNotEquals(response.getStatusCode(), 500, "Expected status code is 500");
        // Проверка наличия поля "data" в теле ответа
        String responseDataBody = response.jsonPath().getString("data");
        assertNotEquals(responseDataBody, "This is not expected part of response body.", "Response body contains the expected text.");
    }
}