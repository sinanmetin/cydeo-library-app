@wip
Feature: Library app login feature with all credentials
  User Story:
  As a user, I should be able to login with correct
  credentials to different accounts

  Background: Assuming user is on the login page
    Given user is on the login page

  @student @allCredentials
  Scenario: Login as student with all credentials
    When login with all valid credentials
    Then verify excel table


