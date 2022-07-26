package examples;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class APITest {
    @Test
    public void checkMillenniumFalcon() {

        given()
                .get("https://swapi.dev/api/starships/10")
                .then()
                .statusCode(200)
                .body("name", equalTo("Millennium Falcon"),
                        "cost_in_credits", equalTo("100000"),
                        "length", equalTo("34.37"),
                        "pilots", hasSize(4));


    }
}
