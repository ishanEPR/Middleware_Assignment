package com.example.demo.Controller;

import org.junit.jupiter.api.Test;

import javax.json.Json;
import javax.ws.rs.core.MediaType;
import java.awt.*;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

class PetControllerTest {

    @Test
    void getAll() {
        given().when().get("/data/pet/getDetails").then().statusCode(200);


    }

    @Test
    void create() {

        given().contentType(
                        MediaType.APPLICATION_JSON).body(
                        Json.createObjectBuilder().
                                add("petName","Brown").
                                add("petAge",2).
                                add("petType","Dog").
                                add("petColor","balce").
                                build().
                                toString()
                ).
                when().
                post("data/pet").
                then().
                statusCode(201);


      //  given().contentType(MediaType.APPLICATION_JSON).body("").when().post("").then().statusCode(200);
    }

    @Test
    void updateData() {
        given().contentType(
                        MediaType.APPLICATION_JSON).body(
                        Json.createObjectBuilder().
                                add("petName","Brown").
                                add("petAge",5).
                                add("petType","Dog").
                                add("petColor","blank").
                                build().
                                toString()
                ).
                when().
                put("data/pet/4").
                then().
                statusCode(200);


    }

    @Test
    void deleteById() {
        given().when().delete("data/pet/4").then().statusCode(200);

    }
}