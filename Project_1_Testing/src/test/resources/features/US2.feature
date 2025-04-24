Feature: a user should securely log into the planetarium

  Background:
    Given the user is on the login page


  Scenario Outline: Successful login
    When the user enters in the correct "<username>" and "<password>"
    Then the user is redirected to the planetarium homepage


    Examples:
    |username|password|
    |Batman|Iamthenight1939|


  Scenario Outline: Unsuccessful login
    When the user enters in the incorrect "<username>" and_or "<password>"
    Then an alert message should be shown "Invalid credentials"
    And the user should remain on the login page

    Examples:
    |username|password|
    |BatmanWrong|Iamthenight1939Wrong|
    |Batman|passwordWrong|
    |BatmanWrong|Iamthenight1939|