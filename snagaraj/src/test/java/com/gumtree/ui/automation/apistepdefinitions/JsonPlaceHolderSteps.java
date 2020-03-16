package com.gumtree.ui.automation.apistepdefinitions;

import com.gumtree.ui.automation.rest_assure_endpoints.JsonPlaceHolder;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class JsonPlaceHolderSteps {

    JsonPlaceHolder jsonPlaceHolder = new JsonPlaceHolder();

    @Given("^I have a random user$")
    public void i_have_a_random_user()  {
        jsonPlaceHolder.getRandomUserId();
    }

    @Given("^I perform a GET request \"([^\"]*)\" for endpoint$")
    public void i_perform_a_GET_request_for_endpoint(String arg1) {
        jsonPlaceHolder.sendGetRequest(arg1);
    }

    @Then("^I display the emailId$")
    public void i_display_the_emailId() {
        System.out.println("Email:" + jsonPlaceHolder.getEmailId());
    }

    @Given("^I perform a GET request \"([^\"]*)\" to list all posts$")
    public void i_perform_a_GET_request_to_list_all_posts(String arg1) {
        jsonPlaceHolder.sendGetRequest(arg1);
    }

    @Then("^validate the post Ids$")
    public void validate_the_post_Ids()  {
        jsonPlaceHolder.postsIdAreValid();
    }

    @Given("^I perform a POST request with title and body$")
    public void i_perform_a_POST_request_with_title_and_body()  {
        jsonPlaceHolder.postRequest();
    }

    @Then("^I verify the responseCode$")
    public void i_verify_the_responseCode(){
        jsonPlaceHolder.validResponseCodeReceived();
    }
}
