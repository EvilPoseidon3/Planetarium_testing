Feature: user can delete celestial bodies from planetarium

  Background:
    Given the user is logged in


    Scenario: Happy path
      When the user types in a valid celestial body
      And clicks on the delete button
      Then the corresponding celestial body should be removed
      And the table should update

    Scenario: Sad Path
      When the user types in an invalid celestial body
      And clicks on the delete button
      Then an alert message saying "Invalid planet_moon" should be shown
      And the user should stay on homepage




