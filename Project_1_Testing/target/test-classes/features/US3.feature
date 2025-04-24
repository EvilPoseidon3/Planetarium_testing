Feature: the user should be able to track their celestial bodies

  Background:
    Given a successful login

  Rule: User planet shows up
  Scenario: Happy Path
    When the user enters "moon" into the planetarium
    Then the users input is present for viewing and editing


    Rule: User moon shows up
  Scenario: Happy Path
    When the user enters "planet" into the planetarium
    Then the users input is present for viewing and editing




    Scenario: Sad Path
      Then the users input is not present for viewing and editing
      And the user does not have access to all their findings
