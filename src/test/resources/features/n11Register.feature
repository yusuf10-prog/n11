Feature: N11 Registration Functionality
  As a user
  I want to register on N11 website
  So that I can have a personal account

  Scenario: Register with valid credentials
    Given I am on the N11 homepage
    When I click on the sign up button
    And I enter valid registration details
    And I click the register button
    Then I should see a registration confirmation

  Scenario: Register with invalid credentials
    Given I am on the N11 homepage
    When I click on the sign up button
    And I enter valid registration details
    And I click the register button
    Then I should see a registration error message
