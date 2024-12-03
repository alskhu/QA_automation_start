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
        Unicorn unicorn = Unicorn.builder().name("unicorn1").color("brown").build();
        UnicornRequest.createUnicorn(unicorn);
    }

    @Test
    public void UserShouldBeAbleDeleteExistingUnicorn() {
        Unicorn unicorn = Unicorn.builder().name("unicorn2").color("grey").build();
        String id = UnicornRequest.createUnicorn(unicorn);

        UnicornRequest.deleteUnicorn( id);

        when()
                .get("/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void UserShouldBeAbleEditExistingUnicorn() {
        Unicorn unicorn = Unicorn.builder().name("unicorn3").color("green").build();
        String id = UnicornRequest.createUnicorn(unicorn);
        Unicorn unicornUpdated = Unicorn.builder().name("unicorn3").color("blue").build();
        UnicornRequest.editUnicorn(unicornUpdated, id);

        when()
                .get("/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(200)
                .body("color", equalTo(unicornUpdated.getColor()));

    }

}
