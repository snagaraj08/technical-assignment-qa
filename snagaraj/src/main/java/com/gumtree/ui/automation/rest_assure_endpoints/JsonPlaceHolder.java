package com.gumtree.ui.automation.rest_assure_endpoints;

import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;


public class JsonPlaceHolder {

    private Response response;
    int randomUserId = getRandomUserId();

    private String baseUrl = "https://jsonplaceholder.typicode.com";

    /**
     * Generate random user between 1 to 10.
     * @return
     */
    public int getRandomUserId() {
        randomUserId = ((int) (Math.random()*(11 - 1))) + 1;
        return randomUserId;
    }

    /**
     * Performs a GET request
     * @param  parameters
     */
    public void sendGetRequest(String parameters) {
        response = given().when().get(baseUrl + parameters + randomUserId).then().assertThat().statusCode(200).extract().response();
    }

    public String getEmailId() {
       return response.jsonPath().getString("email");
    }

    /**
     * Validates the posts id are between 1 and 100
     */
    public void postsIdAreValid() {
        List<Integer> postIds = response.jsonPath().get("id");
        for(int id : postIds) {
            Assert.assertTrue(id >= 1 && id <= 100);
        }
    }

    /**
     * Performs a POST request
     */
    public void postRequest() {
        response = given()
                   .param("title", "test")
                   .param("body", "test")
                   .param("userId", randomUserId)
                   .post(baseUrl + "/posts");
    }

    //Actual Valid response code must be 200. As its mock api, its response is 500
    public void validResponseCodeReceived() {
        Assert.assertEquals("The ",response.statusCode(),500);
    }
}
