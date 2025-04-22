Feature: Be able to register with the planetarium app



  Background:
    Given the user is on the login page
    When the user clicks the register link

    Scenario Outline: Successful registration
      When the user provides a valid "<username>" and "<password>"
      Then an alert should appear saying "<alert>"
      Then the user should be directed to the login page

    Examples:
      |username|password|alert|
      |JaneDoe|A1b2C3D4E5F6G7H8I9J0K1L2M3N4O5|Account created successfully|
      |John-Doe_1|A1b2C3|Account created successfully|
      |JohnDoe|Abc-123|Account created successfully|
      |JohnDoe|Abc_123|Account created successfully|
      |johndoe|Abc123|Account created successfully|
      |John_Doe123|Abc123|Account created successfully|


    Scenario Outline: Unsuccessful registration
      When the user provides an invalid "<username>" and_or "<password>"
      Then the user should be shown an alert "<result>"
      And the user should remain on the registration page

    Examples:
      |username|password|result|
      |123john|Abc123|Invalid username|
      |John|Abc123|Invalid username|
      |Johndoe_is_the_best_person_in_the_galaxy|Abc123|Invalid username|
      |JohnDoe|abc123|Invalid password|
      |JohnDoe|ABC123|Invalid password|
      |JohnDoe|Abcdef|Invalid password|
      |JohnDoe|A!b@123|Invalid password|
      |JohnDoe|A1b|Invalid password|
      |JaneDoe|A1b2C3D4E5F6G7H8I9J0K1L2M3N4O5P|Invalid password|
      |_JohnDoe|Abc123|Invalid username|
      |-JaneDoe|Abc123|Invalid username|
      |JohnDoe|1Abcde|Invalid password|
      |JohnDoe|_Abcde1|Invalid password|
      |JohnDoe|-Abcde1|Invalid password|
      |JaneDoe|Abc123|Invalid username|