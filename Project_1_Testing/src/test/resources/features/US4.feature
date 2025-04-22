Feature: user should be able to add celestial bodies to planetarium

  Background:
    Given the user has logged in successfully
    When the user clicks on the moon_planet creation tab

    Scenario Outline: Happy Path Planet
      When the user enters in valid "<planet>" name
      When the user enters a valid "<filetype>"
      When the user clicks on "text"
      Then the table should refresh with the new data added
      Then no "<alert>" should show up
      And the new data should be associated with the "<userID>"
      And the user should be on the home page

      Examples:
      |planet|userID|filetype|alert|
      |PlanetZ|JohnDoe|JPEG|void|
      |-PlanetY|JohnDoe|JPEG|void|
      |_PlanetX|JohnDoe|PNG|void|
      |Earth_|John_Doe123|PNG|void|
      |Saturn9|JaneDoe|PNG|void|
      |Neptune_2|John_Doe123|void|void|
      |Mercury Prime|John_Doe123|JPEG|void|
      |Mars|John_Doe123|PNG|void|



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
      |Moonshadow|Saturn|JPEG|void|
      |-Moonlet|Saturn|PNG|void|
      |_Moonie|Saturn|PNG|void|
      |Moon-Alpha|Earth_|PNG|void|
      |Callisto 3|Jupiter-Dash|JPEG|void|
      |Ganymede_7|Jupiter-Dash|void|void|
      |Europa|Jupiter-Dash|JPEG|void|
      |﻿Io|Jupiter-Dash|PNG|void|

    Scenario Outline: Sad Path Planet
        When the user enters in invalid "<planet>" name
        When the user enters a invalid "<filetype>"
        When the user clicks on "text"
        And Invalid "<userID>" may show up
        Then then there should be a browser alert "<alert>"
        And the user should be redirected to the homepage

      Examples:
        |planet|userID|filetype|alert|
        |!Venus|John_Doe123|PNG|Invalid planet name|
        |void|John_Doe123|PNG|Invalid planet name|
        |ThisPlanetNameIsWayTooLongToBeValid|John_Doe123|JPEG|Invalid planet name|
        |Jupiter-Dash|John_Doe123|BMP|Invalid file type|
        |Mars|JaneDoe|JPEG|Invalid planet name|
        |Earth|NULL|PNG|Invalid Owner|
        |Neptune|123|PNG|Invalid Owner|
        |Saturn|JohnDoe|TXT|Invalid file type|


  Scenario Outline: Sad Path Moon
      When the user enters in invalid "<moon>" name
      When the user enters in invalid "<planetID>"
      When the user enter in a invalid "<filetype>"
      When the user clicks on "text"
      Then then there should be a browser alert "<alert>"
      And the user should be redirected to the homepage

      Examples:
        |moon|planetID|filetype|alert|
        |@Moon|Saturn9|PNG|Invalid moon name|
        |void|Saturn9|JPEG|Invalid moon name|
        |ThisMoonNameIsWayTooLongToBeValid|Mars|PNG|Invalid moon name|
        |Io|Mars|void|Invalid moon name|
        |Luna_|Earth_|BMP|Invalid image type|
        |Phobos|NULL|PNG|Invalid planet ID|
        |Deimos|FakePlanet123|JPEG|Invalid planet ID|
        |Ganymede|Saturn|TXT|Invalid image type|