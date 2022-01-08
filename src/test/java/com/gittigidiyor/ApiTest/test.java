package com.gittigidiyor.ApiTest;

import com.gittigidiyor.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;
import io.restassured.response.Response;

public class test {

    String key = "f464fa50211054498b50446503612e46";
    String token = "78c931bc6c83a5a817296cd9318a20d11e76cc12e3a3b5a47032d45a2e3f5c1c";
    String boardName = "DenemeBoard";
    String boardId = "";
    String listId = "";
    String card1Id = "";
    String card2Id = "";

    @BeforeClass
    public void beforeClass() {

        baseURI = ConfigurationReader.get("TrelloUrl");

    }

    @Test
    public void createBoard() {

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .when()
                .queryParam("key", key)
                .queryParam("token", token)
                .queryParam("name", "TestiniumBoard")
                .and().post("/boards");
        System.out.println(response);
        boardId = response.body().jsonPath().getString("id");

        assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(), "application/json; charset=utf-8");

    }
    @Test(priority = 2)
    public  void  createCards() throws InterruptedException {

        Response response = given().log().all().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .queryParam("key",key)
                .queryParam("token",token)
                .queryParam("name","newList")
                .queryParam("idBoard",boardId)
                .when().post("/lists");
        response.prettyPrint();


        listId=response.body().jsonPath().getString("id");

        response = given().log().all().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .queryParam("key",key)
                .queryParam("token",token)
                .queryParam("idList",listId)
                .when().post("/cards/");
        response.prettyPrint();
        card1Id=response.path("id");
        assertEquals(response.statusCode(),200);



        response = given().log().all().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .queryParam("key",key)
                .queryParam("token",token)
                .queryParam("idList",listId)
                .when().post("/cards/");
        response.prettyPrint();
        card2Id=response.path("id");
        assertEquals(response.statusCode(),200);

    }
    @Test(priority = 3)
    public  void  updateCard(){

        Response response = given().log().all().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .queryParam("key",key)
                .queryParam("token",token)
                .queryParam("id",card1Id)
                .queryParam("name","UpdatedCardName")
                .and().pathParam("id",card2Id)
                .when().put("/cards/{id}");
        response.prettyPrint();

        assertEquals(response.statusCode(),200);

    }

    @Test(priority = 4)
    public  void  deleteCards(){

        Response response=   given()
                .queryParam("key",key)
                .queryParam("token",token)
                .queryParam("id",card1Id)
                .and().pathParam("id",card1Id)
                .when().delete("/cards/{id}");
        assertEquals(response.statusCode(),200);

        given()
                .queryParam("key",key)
                .queryParam("token",token)
                .queryParam("id",card2Id)
                .and().pathParam("id",card2Id)
                .when().delete("/cards/{id}");
        assertEquals(response.statusCode(),200);

    }
    @Test(priority = 5)
    public void deleteBoard(){

        Response response = given()
                .queryParam("key",key)
                .queryParam("token",token)
                .queryParam("id",boardId)
                .and().pathParam("id",boardId)
                .when().delete("/boards/{id}");
        assertEquals(response.statusCode(),200);

    }
}


