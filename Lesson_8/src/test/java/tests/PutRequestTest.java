package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PutRequestTest extends BaseTest{
    @Test
    public void testPutRequestStatus() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("This is expected to be sent back as part of response body.") // Замените на данные, которые вы хотите отправить
                .when()
                .put(BASE_URL + PUT);

        // Проверка статуса ответа
        assertEquals(response.getStatusCode(), 200, "Expected status code is 200");
    }

    @Test
    public void testPutRequestBodyJson() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("This is expected to be sent back as part of response body.") // Замените на данные, которые вы хотите отправить
                .when()
                .put(BASE_URL + PUT);

        // Проверка наличия "data" в теле ответа
        String responseDataBody = response.jsonPath().getString("data");
        assertEquals(responseDataBody, "This is expected to be sent back as part of response body.", "Response body does not contain the expected text.");
    }
}
