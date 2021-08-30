Feature: Add to Cart

  Scenario: Add an Item to Cart
    Given Pedro navigate to the Adidas home page
    When He navigate to Man Tenis submenu
    When He looks for Tenis Duramo SL
    When He selects the size and add to the cart
    Then The item should be added to the cart