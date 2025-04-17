Feature: the user should be able to track their celestial bodies

  Background:
    Given a successful login
    When the user is on the homepage
    When the user enters data into the planetarium

  Scenario: Happy Path
    Then the users input is present for viewing and editing
    And the user has access to all their findings




    Scenario: Sad Path
      Then the users input is not present for viewing and editing
      And the user does not have access to all their findings
