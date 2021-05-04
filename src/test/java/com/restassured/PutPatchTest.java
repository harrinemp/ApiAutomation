package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutPatchTest {
    @Test
    public void Put_test() {
        RestAssured.baseURI = "https://reqres.in/";

        String reqBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";

        Response postResponse = given()
                .header("content-type","application/json")
                .body(reqBody)
                .put("/api/users/2");

        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());

        Assert.assertEquals(postResponse.getStatusCode(),200,"Expected 200 but found"+postResponse.getStatusCode());

        Assert.assertEquals("morpheus", postResponse.jsonPath().getString("name"));
        Assert.assertEquals("zion resident", postResponse.jsonPath().getString("job"));
    }

    @Test
    public void Patch_test() {
        RestAssured.baseURI = "https://reqres.in/";

        String reqBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";

        Response postResponse = given()
                .header("content-type","application/json")
                .body(reqBody)
                .patch("/api/users/2");

        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());

        Assert.assertEquals(postResponse.getStatusCode(),200,"Expected 200 but found"+postResponse.getStatusCode());

        Assert.assertEquals("morpheus", postResponse.jsonPath().getString("name"));
        Assert.assertEquals("zion resident", postResponse.jsonPath().getString("job"));
    }
}
