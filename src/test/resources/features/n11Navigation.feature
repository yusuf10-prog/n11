# language: en
Feature: N11 Category Navigation

  Scenario: Navigate through main categories on N11
    Given user is on the N11 homepage
    When user clicks on "Moda" category
    Then verify user is on "Moda" category page
    When user clicks on "Elektronik" category
    Then verify user is on "Elektronik" category page
    When user clicks on "Ev & Yaşam" category
    Then verify user is on "Ev & Yaşam" category page
    When user clicks on "Anne & Bebek" category
    Then verify user is on "Anne & Bebek" category page
    When user clicks on "Kozmetik & Kişisel Bakım" category
    Then verify user is on "Kozmetik & Kişisel Bakım" category page
    When user clicks on "Mücevher & Saat" category
    Then verify user is on "Mücevher & Saat" category page
    When user clicks on "Spor & Outdoor" category
    Then verify user is on "Spor & Outdoor" category page
    When user clicks on "Kitap, Müzik, Film, Oyun" category
    Then verify user is on "Kitap, Müzik, Film, Oyun" category page
    When user clicks on "Otomotiv & Motosiklet" category
    Then verify user is on "Otomotiv & Motosiklet" category page
