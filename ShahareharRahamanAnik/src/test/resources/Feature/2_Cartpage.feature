Feature: Cart Page Navigations
  Scenario Outline:
    Given User in the All Product Page
    When Go to the Cart page
    And Verify the FirstProduct '<Firstname>' and '<Firstprice>'
    And Verify the SecondProduct '<Secondname>' and '<Secondtprice>'
    Then The  Navigation is done
    Examples:
    |Firstname|Firstprice|Secondname|Secondtprice|
    |Sauce Labs Backpack|$29.99|Sauce Labs Bike Light|$9.99|