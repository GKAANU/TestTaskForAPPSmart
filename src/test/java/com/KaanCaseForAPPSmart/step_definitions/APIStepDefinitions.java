package com.KaanCaseForAPPSmart.step_definitions;

import com.KaanCaseForAPPSmart.API.ApiExecutor;
import com.KaanCaseForAPPSmart.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class APIStepDefinitions {

    Response response;
    String apiURI;
    JsonPath jsonPath;
    String actualCategory;
    String actualName;
    String actualTag;
    static String expectedCategory;
    static String expectedName;
    static String expectedTag;
    static Long addedId;


    @Given("User on pet swagger api for {string}")
    public void user_on_pet_swagger_api_for(String requestType) {
        apiURI=ConfigurationReader.get("api_url");
    }

    @When("User created {string} animal named {string},tagged {string}")
    public void user_created_animal_named_tagged(String category, String name, String tag) {
        expectedCategory = category;
        expectedName = name;
        expectedTag = tag;

        response = given().accept(ContentType.JSON)
                .when().contentType(ContentType.JSON)
                .body(ApiExecutor.initializePet(category,name,tag))
                .post(apiURI+"/pet");

        jsonPath = response.jsonPath();
        addedId = jsonPath.getLong("id");
    }

    @Then("HTTP status code should be {int}")
    public void http_status_code_should_be(int expectedHTTPCode) {
        Assert.assertEquals(expectedHTTPCode,response.statusCode());
    }

    @Then("category,name and tag should be same what user created")
    public void category_name_and_tag_should_be_same_what_user_created() {
        actualCategory = jsonPath.getString("category.name");
        actualName = jsonPath.getString("name");
        actualTag = jsonPath.getString("tags.name[0]");

        Assert.assertEquals(expectedCategory,actualCategory);
        Assert.assertEquals(expectedName,actualName);
        Assert.assertEquals(expectedTag,actualTag);
    }

    @When("User gets last added pet")
    public void user_gets_last_added_pet() {
        response = given().accept(ContentType.JSON)
                .pathParam("id", addedId)
                .get(apiURI+"/pet/{id}");

        jsonPath = response.jsonPath();
        actualCategory = jsonPath.getString("category.name");
        actualName = jsonPath.getString("name");
        actualTag = jsonPath.getString("tags.name[0]");
    }

    @Then("category,name and tag should match with what user added")
    public void category_name_and_tag_should_match_with_what_user_added() {
        Assert.assertEquals(expectedCategory,actualCategory);
        Assert.assertEquals(expectedName,actualName);
        Assert.assertEquals(expectedTag,actualTag);
    }

    @When("User updates last added pet {string},{string},{string}")
    public void user_updates_last_added_pet(String category, String name, String tag) {
        expectedCategory = category;
        expectedName = name;
        expectedTag = tag;

        response = given().accept(ContentType.JSON)
                .body(ApiExecutor.initializePet(category,name,tag))
                .when().contentType(ContentType.JSON)
                .put(apiURI+"/pet");

        jsonPath = response.jsonPath();
        actualCategory = jsonPath.getString("category.name");
        actualName = jsonPath.getString("name");
        actualTag = jsonPath.getString("tags.name[0]");
    }

    @Then("category,name and tag should be same what user updated")
    public void category_name_and_tag_should_be_same_what_user_updated() {
        Assert.assertEquals(expectedCategory,actualCategory);
        Assert.assertEquals(expectedName,actualName);
        Assert.assertEquals(expectedTag,actualTag);
    }

    @When("User delete last added pet")
    public void user_delete_last_added_pet() {
        response = given().accept(ContentType.JSON)
                .pathParam("id",addedId)
                .delete(apiURI+"/pet/{id}");
    }

    @When("User try to get last deleted pet")
    public void user_try_to_get_last_deleted_pet() {
        response = given().accept(ContentType.JSON)
                .pathParam("id",addedId)
                .get(apiURI+"pet/{id}");
    }

}
