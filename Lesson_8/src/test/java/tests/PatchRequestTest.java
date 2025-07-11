package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PatchRequestTest extends BaseTest{
    @Test
    public void testPatchRequestStatus() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("This is expected to be sent back as part of response body.") // Замените на данные, которые вы хотите отправить
                .when()
                .patch(BASE_URL + PATCH);

        // Проверка статуса ответа
        assertEquals(response.getStatusCode(), 200, "Expected status code is 200");
    }

    @Test
    public void testPatchRequestBodyJson() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch(BASE_URL + PATCH);

        // Проверка наличия "data" в теле ответа
        String responseDataBody = response.jsonPath().getString("data");
        assertEquals(responseDataBody, "This is expected to be sent back as part of response body.", "Response body does not contain the expected text.");
    }
}
