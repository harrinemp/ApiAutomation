package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostTest {

    @Test
    public void Post_Create_test() {
        RestAssured.baseURI = "https://reqres.in/";

        JSONObject requestParams = new JSONObject();

        requestParams.put("name","morpheus");
        requestParams.put("job","leader");

        Response postResponse = given()
                .header("content-type","application/json")
                .body(requestParams.toString())
                .post("/api/users");

        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());

        Assert.assertEquals(postResponse.getStatusCode(),201,"Expected 201 but found"+postResponse.getStatusCode());

    }

    @Test
    public void Post_Register_Successful_test() {
        RestAssured.baseURI = "https://reqres.in/";

        String reqBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";

        Response postResponse = given()
                .header("content-type","application/json")
                .body(reqBody)
                .post("/api/register");

        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());

        Assert.assertEquals(postResponse.getStatusCode(),200,"Expected 200 but found"+postResponse.getStatusCode());

    }

    @Test
    public void Post_Register_Unsuccessful_test() {
        RestAssured.baseURI = "https://reqres.in/";

        String reqBody = "{\n" +
                "    \"email\": \"sydney@fife\"\n" +
                "}";

        Response postResponse = given()
                .header("content-type","application/json")
                .body(reqBody)
                .post("/api/register");

        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());

        Assert.assertEquals(postResponse.getStatusCode(),400,"Expected 400 but found"+postResponse.getStatusCode());

    }

    @Test
    public void Post_Login_Successful_test() {
        RestAssured.baseURI = "https://reqres.in/";

        String reqBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";

        Response postResponse = given()
                .header("content-type","application/json")
                .body(reqBody)
                .post("/api/login");

        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());

        Assert.assertEquals(postResponse.getStatusCode(),200,"Expected 200 but found"+postResponse.getStatusCode());

    }

    @Test
    public void Post_Login_Unsuccessful_test() {
        RestAssured.baseURI = "https://reqres.in/";

        String reqBody = "{\n" +
                "    \"email\": \"peter@klaven\"\n" +
                "}";

        Response postResponse = given()
                .header("content-type","application/json")
                .body(reqBody)
                .post("/api/login");

        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());

        Assert.assertEquals(postResponse.getStatusCode(),400,"Expected 400 but found"+postResponse.getStatusCode());

    }
}
