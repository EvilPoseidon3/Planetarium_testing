Feature: user should be able to add celestial bodies to planetarium

  Background:
    Given the user has logged in successfully
    When the user clicks on the moon_planet creation tab

    Scenario: Happy Path
      When the user enters in valid planet_moon data
      Then the table should refresh with the new data added
      And the user should be taken back to the home page

    Scenario: Sad Path
      When the user enters in invalid planet_moon data
      Then then there should be a browser alert "alert"
      And the user should be redirected to the homepage