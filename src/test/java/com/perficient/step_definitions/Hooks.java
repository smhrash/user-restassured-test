package com.perficient.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    // Helper method to create a user
    private void createUser() {
        StepDefinition sd = new StepDefinition();
        sd.iHaveRequestBody(" ");
        sd.iPerformWithRequest("CREATE_USER", "POST");
        sd.iSeeTheAccountStatus("CREATED");
    }

    // Helper method to delete a user
    private void deleteUser() {
        StepDefinition sd = new StepDefinition();
        sd.iHaveRequestBody("NO");
        sd.iPerformWithRequest("DELETE_USER", "DELETE");
    }

    @Before("@update-user")
    public void createUserBeforeUpdate() {
        createUser();
    }

    @Before("@delete-user")
    public void createUserBeforeDelete() {
        createUser();
    }

    @Before("@get-user")
    public void createUserBeforeRetrieve() {
        createUser();
    }

    @Before("@get-users")
    public void createUserBeforeRetrieveAll() {
        createUser();
    }

    @After("@create-user")
    public void tearDownAfterCreate() {
        deleteUser();
    }

    @After("@update-user")
    public void tearDownAfterUpdate() {
        deleteUser();
    }

    @After("@get-user")
    public void tearDownAfterRetrieve() {
        deleteUser();
    }

    @After("@get-users")
    public void tearDownAfterRetrieveAll() {
        deleteUser();
    }
}
