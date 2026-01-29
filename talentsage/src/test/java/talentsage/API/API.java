package talentsage.API;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class API {

    @BeforeClass
    public void setup() {
        // Base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void validateCreatePostApi() {

        // ✅ 1. Arrange - Request Body using text block
        String requestBody = """
                {
                  "title": "Automation Testing",
                  "body": "Learning API testing with RestAssured",
                  "userId": 101
                }
                """;

        // ✅ 2. Act - Send POST request
        Response response =
                given()
                        .contentType("application/json")
                        .body(requestBody)
                .when()
                        .post("/posts");

        // ✅ Debug - Print response
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.asString());

        // ✅ 3. Assert - HTTP Status
        Assert.assertEquals(response.getStatusCode(), 201, "Expected status code 201");

        // ✅ 4. Assert - JSON Schema
        response.then().body(matchesJsonSchemaInClasspath("schemas/post-schema.json"));

        // ✅ 5. Assert - Required Fields
        int id = response.jsonPath().getInt("id");
        String title = response.jsonPath().getString("title");
        String body = response.jsonPath().getString("body");
        int userId = response.jsonPath().getInt("userId");

        Assert.assertTrue(id > 0, "ID should be greater than 0");
        Assert.assertEquals(title, "Automation Testing");
        Assert.assertEquals(body, "Learning API testing with RestAssured");
        Assert.assertEquals(userId, 101);
    }
}
