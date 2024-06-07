Feature: Checkout
  Scenario Outline:
    Given User click on the checkout
    And user input '<firstname>' and '<lastName>' and '<ZipCode>'
    And Continue to overview
    And Check the '<TotalPrices>' with SoftAccertion
    Examples:
    |firstname|lastName|ZipCode|TotalPrices|
    |Anik     |Rahman  |1206   |Total: $43.18 |
