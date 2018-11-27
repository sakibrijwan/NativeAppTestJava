Feature: Adding two numbers using Calculator App
  Scenario Outline: Launch Calculator and Add two numbers
    Given Calculator is launched
    When I press one
    And I press plus sing
    And I press two
    And I press equal sign
    Then Result <three> will appear
    Then Clear the result

    Examples:
    |three|
    |     3|