package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.http.HttpStatus;
import org.example.API.UnicornRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasKey;

public class SimpleTest {
    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/e6771bfc496c4db3b6bf9b116e7a8689";
    }

    @Test
    public void UserShouldBeCreateUnicorn() {
        UnicornRequest.createUnicorn("{\n" +
                "  \"name\": \"unicorn1\",\n" +
                "  \"color\": \"red\"\n" +
                "}");
    }

    @Test
    public void UserShouldBeAbleDeleteExistingUnicorn() {
        String id = UnicornRequest.createUnicorn("{\n" +
                "  \"name\": \"unicorn2\",\n" +
                "  \"color\": \"yellow\"\n" +
                "}");

        UnicornRequest.deleteUnicorn(id);

        when()
                .get("/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void UserShouldBeAbleEditExistingUnicorn() {
        String id = UnicornRequest.createUnicorn("{\n" +
                "  \"name\": \"unicorn3\",\n" +
                "  \"color\": \"green\"\n" +
                "}");
        String expectedColor = "blue";
        UnicornRequest.editUnicorn("{\n" +
                "  \"name\": \"unicorn3\",\n" +
                "  \"color\": \"" + expectedColor + "\" \n" +
                "}", id);

        when()
                .get("/unicorn/" + id)
                .then()
                .assertThat()
                .extract()
                .path("color")
                .equals(expectedColor);

    }

}
