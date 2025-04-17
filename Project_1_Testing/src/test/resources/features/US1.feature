Feature: Be able to register with the planetarium app



  Background:
    Given the user is on the login page
    When the user clicks the register link

    Scenario Outline: Successful registration
      When the user provides a valid "<username>" and "<password>"
      Then an alert should appear saying "Account created successfully"
      Then the user should be directed to the login page

    Examples:
      |username|password|
      |        |        |


    Scenario Outline: Unsuccessful registration
      When the user provides an invalid "<username>" and_or "<password>"
      Then the user should be shown an alert "<result>"
      And the user should remain on the registration page

    Examples:
      |username|password|result|
      |        |        |      |