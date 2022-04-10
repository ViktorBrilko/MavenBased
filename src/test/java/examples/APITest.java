package examples;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class APITest {

    @Test
    public void checkMillenniumFalcon() {
        Response response = given().get("https://swapi.dev/api/starships/10");
        ArrayList<String> a = response.path("pilots");

        when().get("https://swapi.dev/api/starships/10")
                .then()
                .statusCode(200)
                .assertThat()
                .body("name", equalTo("Millennium Falcon"),
                        "cost_in_credits", equalTo("100000"),
                        "length", equalTo("34.37"));

        Assertions.assertEquals(a.size(), 4);

    }
}
