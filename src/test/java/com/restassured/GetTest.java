package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;




public class GetTest {

    @Test
    public void List_Users_Get_Api_Test(){

        Response response = given()
                .header("content-type","application/json")
                .get("https://reqres.in/api/users?page=2");
        System.out.println("******** List Users ********\n"+response.prettyPrint());

        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());

    }

    @Test(priority = 1)
    public void Single_User_Get_Api_Test(){

        RestAssured.baseURI="https://reqres.in/";
        Response response = given()
                .header("content-type","application/json")
                .get("/api/users/2");

        System.out.println("******** Single User ********\n"+response.prettyPrint());

        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());

    }

    @Test(priority = 2)
    public void Single_User_Not_Found_Get_Api_Test(){

        RestAssured.baseURI="https://reqres.in/";
        Response response = given()
                .header("content-type","application/json")
                .get("/api/users/23");

        System.out.println("******** Single User Not Found ********\n"+response.prettyPrint());

        Assert.assertEquals(response.statusCode(),404,"Expected response code is 404 but found "+response.statusCode());

    }

    @Test(priority = 3)
    public void List_Resources_Get_Api_Test(){

        RestAssured.baseURI="https://reqres.in/";
        Response response = given()
                .header("content-type","application/json")
                .get("/api/unknown");

        System.out.println("******** List <Resource> ********\n"+response.prettyPrint());

        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());

    }

    @Test(priority = 4)
    public void Single_Resources_Get_Api_Test(){

        RestAssured.baseURI="https://reqres.in/";
        Response response = given()
                .header("content-type","application/json")
                .get("/api/unknown/2");

        System.out.println("******** Single <Resource> ********\n"+response.prettyPrint());

        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());

    }

    @Test(priority = 5)
    public void Single_Resorce_Not_Found_Get_Api_Test(){

        RestAssured.baseURI="https://reqres.in/";
        Response response = given()
                .header("content-type","application/json")
                .get("/api/unknown/23");

        System.out.println("******** Single Resource Not Found ********\n"+response.prettyPrint());

        Assert.assertEquals(response.statusCode(),404,"Expected response code is 404 but found "+response.statusCode());

    }

    @Test(priority = 6)
    public void Get_Delayed_Response_Api_Test(){

        RestAssured.baseURI="https://reqres.in/";
        Response response = given()
                .header("content-type","application/json")
                .get("/api/users?delay=3");

        System.out.println("******** Delayed Response by 3 sec ********\n"+response.prettyPrint());

        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());

    }
}
