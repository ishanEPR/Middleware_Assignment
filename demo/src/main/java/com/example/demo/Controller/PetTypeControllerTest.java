package com.example.demo.Controller;

import org.junit.jupiter.api.Test;

import javax.json.Json;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

class PetTypeControllerTest {

    @Test
    void getAll() {
        given().when().get("/data/pet-types/getDetails").then().statusCode(200);
    }



    @Test
    void create() {

        given().contentType(
                        MediaType.APPLICATION_JSON).body(
                        Json.createObjectBuilder().
                                add("categeryType","root black").
                                add("Petfamily","Dog").
                                build().
                                toString()
                ).
                when().
                post("data/pet-types").
                then().
                statusCode(201);
    }

    @Test
    void updateData() {
        given().contentType(
                        MediaType.APPLICATION_JSON).body(
                        Json.createObjectBuilder().
                                add("categeryType","root black").
                                add("Petfamily","Dogssss").
                                build().
                                toString()
                ).
                when().
                put("data/pet-types/3").
                then().
                statusCode(200);
    }

    @Test
    void deleteById() {
        given().when().delete("data/pet-types/3").then().statusCode(200);
    }
}