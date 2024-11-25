package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.example.API.StudentsRequests;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasKey;

public class SimpleTest {
    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/5169422c8a41447baa320c8c89a7e9cf";

        // Принцип программирования DRY: DON'T REPEAT YOURSELF
    }
    @Test
    public void userShouldBeAbleCreateStudent() {
        //given - when - then BDD
        StudentsRequests.createStudent("{\n" +
                "  \"name\": \"Petr Petrov\",\n" +
                "  \"grade\": 2\n" +
                "}");
    }

    @Test
    public void UserShouldBeAbleDeleteExistingStudent() {
        // Шаг 1 - Создание студента
        String id = StudentsRequests.createStudent("{\n" +
                "  \"name\": \"Petr Petrov\",\n" +
                "  \"grade\": 2\n" +
                "}");

        // Шаг 2 - Удаление студента
        StudentsRequests.deleteStudent(id);

        // Шаг 3 - Проверить, что студент больше не существует
        when()
                .get("/student/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
