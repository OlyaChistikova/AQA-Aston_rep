package tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetRequestTest extends BaseTest {

    @Test
    public void testGetRequestPositive() {
        given()
                .baseUri(BASE_URL)
                .when().queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .get(GET)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("args.foo1", Matchers.equalTo("bar1"))
                .body("args.foo2", Matchers.equalTo("bar2"));
    }

    @Test
    public void testGetRequestWithOutParameters() {
        given()
                .baseUri(BASE_URL)
                .when()
                .get(GET)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("headers.host", Matchers.equalTo("postman-echo.com"));
    }
}
