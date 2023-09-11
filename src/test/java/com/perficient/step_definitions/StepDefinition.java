package com.perficient.step_definitions;

import com.perficient.AbstractServiceTest;
import com.perficient.constants.PathParameter;
import com.perficient.utils.PojoConvertor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class StepDefinition extends AbstractServiceTest {
    PojoConvertor pc = new PojoConvertor();
    Response response;
    protected static int userId;

    @Given("I have {string} request body")
    public void iHaveRequestBody(String type) {
        if (type.equals(" ")) {
            requestSpecification = given().spec(requestSpec()).body(pc.createUser());
        } else if (type.equals("UPDATED")) {
            requestSpecification = given().spec(requestSpec()).body(pc.updateUser(userId));
        } else {
            requestSpecification = given().spec(requestSpec());

        }

    }

    @When("I perform {string} with {string} request")
    public void iPerformWithRequest(String param, String method) {
        PathParameter pm = PathParameter.valueOf(param);
        responseSpecification = new ResponseSpecBuilder().build();
        if (method.equals("POST")) {
            response = requestSpecification.when().post(pm.param());
        } else if (method.equals("PUT")) {
            response = requestSpecification.when().put(pm.param());
        } else if (method.equals("GET")) {
            response = requestSpecification.when().get(pm.param() + userId);
        } else if (method.equals("GET_ALL")) {
            response = requestSpecification.when().get(pm.param());
        } else {
            response = requestSpecification.when().delete(pm.param() + userId);
        }
    }

    @Then("I see the account has been {string}")
    public void iSeeTheAccountStatus(String status) {
        if (status.equals("CREATED")) {
            userId = Integer.parseInt(getJsonPath(response, "userId"));
            assertEquals(201, response.getStatusCode());
        } else if (status.equals("UPDATED")) {
            assertEquals(202, response.getStatusCode());
        } else if (status.equals("DELETED")) {
            assertEquals(200, response.getStatusCode());
        } else if (status.equals("RETRIEVED")) {
            assertEquals(200, response.getStatusCode());
    }

    }
}
