@update-user
Feature: As a user I am going to update my account.

  Scenario: As a user I should be able to update my account.
    Given I have "UPDATED" request body
    When I perform "UPDATE_USER" with "PUT" request
    Then I see the account has been "UPDATED"