@functionalTest
Feature: Test Multiple feature
  Scenario Outline: It will confirm multiple feature run
    Given A feature "<name>"
    Then It will run

    Examples:
    |name|
    | Appium   |