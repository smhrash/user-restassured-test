@get-users
Feature: As a user I am going to retrieve all accounts.

  Scenario: As a user I should be able to retrieve all accounts.
    Given I have "NO" request body
    When I perform "GET_USERS" with "GET_ALL" request
    Then I see the account has been "RETRIEVED"