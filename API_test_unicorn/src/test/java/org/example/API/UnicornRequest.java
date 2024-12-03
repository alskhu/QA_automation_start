package org.example.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.example.API.models.Unicorn;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequest {
    public static Unicorn createUnicorn(Unicorn unicorn) {
        String unicornJson = null;
        try {
            unicornJson = new ObjectMapper().writeValueAsString(unicorn);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return given()
                .body(unicornJson)
                .contentType(ContentType.JSON)
        .when()
                .post("/unicorn")
        .then()
                .assertThat()
                .statusCode(201)
                .body("$",hasKey("_id"))
                .extract().as(Unicorn.class, ObjectMapperType.GSON);
    }

    public static void deleteUnicorn(String id) {
        given()
                .delete("/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(200);
    }

    public static void editUnicorn(Unicorn body, String id) {
        given()
                .body(body)
                .contentType(ContentType.JSON)
        .when()
                .put("/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(200);
    }
}
