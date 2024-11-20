package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasKey;

public class SimpleTest {
    @Test
    public void userShouldBeAbleCreateStudent() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        //given - when - then BDD
        given()
                    .body("{\n" +
                        "  \"name\": \"Petr Petrov\",\n" +
                        "  \"grade\": 2\n" +
                        "}")
                    .contentType(ContentType.JSON)
                .when()
                    .post("https://crudcrud.com/api/5169422c8a41447baa320c8c89a7e9cf/student")
                .then()
                    .assertThat()
                        .statusCode(201)
                        .body("$", hasKey("_id"));

    }

    @Test
    public void UserShouldBeAbleDeleteExistingStudent() {
        // Шаг 1 - Создание студента
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        //given - when - then BDD
        String id = given()
                    .body("{\n" +
                        "  \"name\": \"Petr Petrov\",\n" +
                        "  \"grade\": 2\n" +
                        "}")
                    .contentType(ContentType.JSON)
                .when()
                    .post("https://crudcrud.com/api/5169422c8a41447baa320c8c89a7e9cf/student")
                .then()
                    .assertThat()
                        .statusCode(201)
                        .body("$", hasKey("_id"))
                .extract()
                        .path("_id");

        // Шаг 2 - Удаление студента
        given()
                .delete("https://crudcrud.com/api/5169422c8a41447baa320c8c89a7e9cf/student/" + id)
        .then()
                .assertThat()
                .statusCode(200);

        // Шаг 3 - Проверить, что студент больше не существует
        when()
                .get("https://crudcrud.com/api/5169422c8a41447baa320c8c89a7e9cf/student/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
