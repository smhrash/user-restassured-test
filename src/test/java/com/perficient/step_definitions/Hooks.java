package com.perficient.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before("@update-user")
    public void createUserBeforeUpdate() {
        StepDefinition sd = new StepDefinition();
        sd.iHaveRequestBody(" ");
        sd.iPerformWithRequest("CREATE_USER","POST");
        sd.iSeeTheAccountStatus("CREATED");
    }

    @Before("@delete-user")
    public void createUserBeforeDelete() {
        StepDefinition sd = new StepDefinition();
        sd.iHaveRequestBody(" ");
        sd.iPerformWithRequest("CREATE_USER","POST");
        sd.iSeeTheAccountStatus("CREATED");
    }

    @Before("@get-user")
    public void createUserBeforeRetrieve() {
        StepDefinition sd = new StepDefinition();
        sd.iHaveRequestBody(" ");
        sd.iPerformWithRequest("CREATE_USER","POST");
        sd.iSeeTheAccountStatus("CREATED");
    }

    @Before("@get-users")
    public void createUserBeforeRetrieveAll() {
        StepDefinition sd = new StepDefinition();
        sd.iHaveRequestBody(" ");
        sd.iPerformWithRequest("CREATE_USER","POST");
        sd.iSeeTheAccountStatus("CREATED");
    }

    @After("@create-user")
    public void tearDownAfterCreate() {
        StepDefinition sd = new StepDefinition();
        sd.iHaveRequestBody("NO");
        sd.iPerformWithRequest("DELETE_USER", "DELETE");
    }

    @After("@update-user")
    public void tearDownAfterUpdate() {
        StepDefinition sd = new StepDefinition();
        sd.iHaveRequestBody("NO");
        sd.iPerformWithRequest("DELETE_USER", "DELETE");
    }

    @After("@get-user")
    public void tearDownAfterRetrieve() {
        StepDefinition sd = new StepDefinition();
        sd.iHaveRequestBody("NO");
        sd.iPerformWithRequest("DELETE_USER", "DELETE");
    }

    @After("@get-users")
    public void tearDownAfterRetrieveAll() {
        StepDefinition sd = new StepDefinition();
        sd.iHaveRequestBody("NO");
        sd.iPerformWithRequest("DELETE_USER", "DELETE");
    }
}
