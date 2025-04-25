Feature: user can delete celestial bodies from planetarium

  Background:
    Given the user is logged in


    Scenario: Happy path planet
      When the user clicks on the planet creation tab
      When the user types in a valid planet body
      And clicks on the delete button
      Then the corresponding planet and moon should be removed

        Scenario: Happy path moon
          When the user clicks on the moon creation tab
          When the user types in a valid moon body
          And clicks on the delete button
          Then the corresponding moon should be removed

    Scenario: Sad Path Planet
      When the user clicks on the planet creation tab
      When the user types in an invalid "planet" body
      And clicks on the delete button
      Then an alert message saying "Invalid planet name" should be shown
      And the user should stay on homepage

  Scenario: Sad Path Planet
    When the user clicks on the moon creation tab
    When the user types in an invalid "moon" body
    And clicks on the delete button
    Then an alert message saying "Invalid moon name" should be shown
    And the user should stay on homepage




