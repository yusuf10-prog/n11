Feature: N11 Login Functionality

  Scenario: Login with fake credentials
    Given I am on the N11 homepage
    When I click on the sign in button
    And I enter fake email and password
    And I click the login button
    Then I should see the error message
