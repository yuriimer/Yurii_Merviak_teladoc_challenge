Feature: As an Engr. Candidate
  I need to automate http://www.way2automation.com/angularjs-protractor/webtables/
  So I can show my awesome automation skills

  Background: The user navigates to the URl - http://www.way2automation.com/angularjs-protractor/webtables/

  @Test
  Scenario: Add a user and validate the user has been added to the table
    Given the user clicks Add User button
    And fill out all information
    When the user clicks Save button
    Then the user has been added to the table

    @Test
    Scenario: Delete user User Name: novak and validate user has been delete
      Given the user clicks Delete User button
      When user confirms delete
      Then user has been removed
