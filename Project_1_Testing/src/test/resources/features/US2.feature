Feature: a user should securely log into the planetarium

  Background:
    Given the user is on the login page


  Scenario Outline: Successful login
    When the user enters in the correct "<username>" and "<password>"
    Then the user is redirected to the planetarium homepage
    And the user should be greeted with a message "message"


    Examples:
    |username|password|
    |        |        |


  Scenario Outline: Unsuccessful login
    When the user enters in the incorrect "<username>" and_or "<password>"
    Then an alert message should be shown "Invalid Credentials"
    And the user should remain on the login page

    Examples:
    |username|password|
    |        |        |