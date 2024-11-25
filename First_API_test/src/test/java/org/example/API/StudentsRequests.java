package org.example.API;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class StudentsRequests {
    public static String createStudent(String body) {
        return given()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("/student")
                .then()
                .assertThat()
                .statusCode(201)
                .body("$", hasKey("_id"))
                .extract().path("_id");
    }

    public static void deleteStudent(String id) {
        given()
                .delete("/student/" + id)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
