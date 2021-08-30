  Feature: Search by keyword

  Scenario: Search for an item
    Given Pedro is on the Adidas home page
    When He searches for Tenis Duramo SL
    Then He should see items related to "Tenis Duramo sl"