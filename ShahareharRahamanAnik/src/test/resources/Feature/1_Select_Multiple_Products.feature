Feature:  Multiple product selection
  Scenario Outline:
    Given user hit on the Swag lab url
    When Input '<username>' and '<password>'
    And Select Multiple Product
    Examples:
    |username|password|
    |standard_user|secret_sauce|
