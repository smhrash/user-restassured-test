@create-user
Feature: As a user I am going to create my account.

  Scenario: As a user I should be able to create my account.
    Given I have " " request body
    When I perform "CREATE_USER" with "POST" request
    Then I see the account has been "CREATED"