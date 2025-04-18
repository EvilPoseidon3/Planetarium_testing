Feature: user should be able to add celestial bodies to planetarium

  Background:
    Given the user has logged in successfully
    When the user clicks on the moon_planet creation tab

    Scenario Outline: Happy Path Planet
      When the user enters in valid "<planet>" name
      When the user enters a valid "<filetype>"
      When the user clicks on "text"
      Then the table should refresh with the new data added
      And the user should be on the home page

      Examples:

    Scenario Outline: Happy Path Moon
      When the user enters in valid "<moon>" name
      When the user enters in valid "<planetID>"
      When the user enter in a valid "<filetype>"
      When the user clicks on "text"
      Then the table should refresh with the new data added
      And no "<alert>" should pop up
      And the user should be on the home page


      Examples:
      |moon|planetID|filetype|alert|

    Scenario Outline: Sad Path Planet
        When the user enters in invalid "<planet>" name
        When the user enters a invalid "<filetype>"
        When the user clicks on "text"
        Then then there should be a browser alert "alert"
        And the user should be redirected to the homepage

      Examples:

    Scenario Outline: Sad Path Moon
      When the user enters in invalid "<moon>" name
      When the user enters in invalid "<planetID>"
      When the user enter in a invalid "<filetype>"
      When the user clicks on "text"
      Then then there should be a browser alert "<alert>"
      And the user should be redirected to the homepage

      Examples:
        |moon|planetID|filetype|alert|