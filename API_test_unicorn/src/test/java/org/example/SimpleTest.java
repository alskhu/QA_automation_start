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
        RestAssured.baseURI = "https://crudcrud.com/api/06b7a6e0cc3d45c2ba446d581dd188d9";
    }

    @Test
    public void UserShouldBeCreateUnicorn() {

        Unicorn unicorn = new Unicorn("unicorn1", "brown");
        UnicornRequest.createUnicorn(unicorn);
    }

    @Test
    public void UserShouldBeAbleDeleteExistingUnicorn() {
        Unicorn unicorn = new Unicorn("unicorn2", "grey");
        Unicorn createdUnicorn = UnicornRequest.createUnicorn(unicorn);

        UnicornRequest.deleteUnicorn( createdUnicorn.getId());

        when()
                .get("/unicorn/" + createdUnicorn.getId())
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void UserShouldBeAbleEditExistingUnicorn() {
        Unicorn unicorn = new Unicorn("unicorn3", "green");
        Unicorn createdunicorn = UnicornRequest.createUnicorn(unicorn);
        Unicorn unicornUpdated = new Unicorn("unicorn3", "blue");
        UnicornRequest.editUnicorn(unicornUpdated, createdunicorn.getId());

        when()
                .get("/unicorn/" + createdunicorn.getId())
        .then()
                .assertThat()
                .statusCode(200)
                .body("color", equalTo(unicornUpdated.getColor()));

    }

}
