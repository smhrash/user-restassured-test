@get-user
Feature: As a user I am going to retrieve my account.

  Scenario: As a user I should be able to retrieve my account.
    Given I have "NO" request body
    When I perform "GET_USER" with "GET" request
    Then I see the account has been "RETRIEVED"