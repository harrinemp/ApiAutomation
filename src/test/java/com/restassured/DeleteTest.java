package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteTest {
    @Test
    public void Delete_test() {
        RestAssured.baseURI = "https://reqres.in/";

        Response postResponse = given()
                .header("content-type","application/json")
                .delete("/api/users/2");

        System.out.println(postResponse.statusCode());
        //System.out.println(postResponse.getBody().asString());

        Assert.assertEquals(postResponse.getStatusCode(),204,"Expected 204 but found"+postResponse.getStatusCode());


    }

}
