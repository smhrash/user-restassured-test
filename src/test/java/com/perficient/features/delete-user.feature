@delete-user
Feature: As a user I am going to delete my account.

  Scenario: As a user I should be able to delete my account.
    Given I have "NO" request body
    When I perform "DELETE_USER" with "DELETE" request
    Then I see the account has been "DELETED"