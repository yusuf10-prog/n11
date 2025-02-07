Feature: N11 Website Navigation

  Scenario: Navigate through N11 website menu items
    Given I am on the N11 homepage
    When I accept cookies if present
    Then I click on all menu items
    And I scroll to the bottom of the page
