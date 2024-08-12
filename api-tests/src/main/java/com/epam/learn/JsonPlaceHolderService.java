package com.epam.learn;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class JsonPlaceHolderService {
    public static final String POSTS = "posts";
    public static final String COMMENTS = "comments";
    public static final String ALBUMS = "albums";
    public static final String PHOTOS = "photos";
    public static final String TODOS = "todos";
    public static final String USERS = "users";

    public static RequestSpecification defaultReqSpec = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").setContentType(ContentType.JSON).build();
    public static ResponseSpecification defaultResSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();

    public static ValidatableResponse getAll(String resourcePath) {
        return given()
                .spec(defaultReqSpec)
                .when()
                .get(resourcePath)
                .then()
                .assertThat()
                .statusCode(200)
                .spec(defaultResSpec);
    }

    public static ValidatableResponse createResource(String resourcePath, Object body) {
        return given()
                .spec(defaultReqSpec)
                .body(body)
                .log().all()
                .when()
                .post(resourcePath)
                .then()
                .log().all()
                .statusCode(201)
                .assertThat();
    }

    public static ValidatableResponse getResourceById(String resourcePath, int id) {
        return given()
                .spec(defaultReqSpec)
                .pathParam("id", id)
                .log().all()
                .when()
                .get(resourcePath + "/{id}")
                .then()
                .log().all()
                .statusCode(200)
                .assertThat();
    }

    public static ValidatableResponse updateResource(String resourcePath, int id, Object body) {
        return given()
                .spec(defaultReqSpec)
                .pathParam("id", id)
                .body(body)
                .log().all()
                .when()
                .put(resourcePath + "/{id}")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }

    public static ValidatableResponse deleteResource(String resourcePath, int id) {
        return given()
                .spec(defaultReqSpec)
                .pathParam("id", id)
                .log().all()
                .when()
                .delete(resourcePath + "/{id}")
                .then()
                .log().all()
                .statusCode(200)
                .assertThat();
    }
}
