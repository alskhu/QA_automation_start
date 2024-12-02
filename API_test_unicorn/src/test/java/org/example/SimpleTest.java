package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.http.HttpStatus;
import org.example.API.UnicornRequest;
import org.example.API.models.Unicorn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class SimpleTest {
    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/e6771bfc496c4db3b6bf9b116e7a8689";
    }

    @Test
    public void UserShouldBeCreateUnicorn() {

        Unicorn unicorn = new Unicorn("unicorn1", "brown");
        UnicornRequest.createUnicorn(unicorn.toJson());
    }

    @Test
    public void UserShouldBeAbleDeleteExistingUnicorn() {
        Unicorn unicorn = new Unicorn("unicorn2", "grey");
        String id = UnicornRequest.createUnicorn(unicorn.toJson());

        UnicornRequest.deleteUnicorn(id);

        when()
                .get("/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void UserShouldBeAbleEditExistingUnicorn() {
        Unicorn unicorn = new Unicorn("unicorn3", "green");
        String id = UnicornRequest.createUnicorn(unicorn.toJson());
        Unicorn unicornUpdated = new Unicorn("unicorn3", "blue");
        UnicornRequest.editUnicorn(unicornUpdated.toJson(),id);

        when()
                .get("/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(200)
                .body("color", equalTo(unicornUpdated.getColor()));

    }

}
