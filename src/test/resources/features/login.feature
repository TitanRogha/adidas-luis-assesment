Feature: Login into the application

  Scenario: Successful login
    Given Pedro is on the Adidas login page
    When He sends their valid credentials
    Then he should have access to manage his account