Feature: user should be able to add celestial bodies to planetarium

  Background:
    Given the user has logged in successfully

    Scenario Outline: Happy Path Planet
      When the user clicks on the planet creation tab
      When the user enters in planet "<planet>"
#      When the user enters a picture "<filetype>"
      When the user clicks submit
      Then the table should refresh
      Then no "<alert>" should show up
      And the new data should be associated with the "<userID>"
      And the user should be on the home page

      Examples:
      |planet|userID|filetype|alert|
      |Planet|1|JPEG|void|
      |PlanetZ|1|JPEG|void|
      |-PlanetY|1|JPEG|void|
      |_PlanetX|1|PNG|void|
      |Earth_|1|PNG|void|
      |Saturn9|1|PNG|void|
      |Neptune_2|1|void|void|
      |Mercury Prime|1|JPEG|void|
      |Mars|1|PNG|void|



  Scenario Outline: Happy Path Moon
      When the user clicks on the moon creation tab
      When the user enters in moon "<moon>"
      When the user enters in planetId "<userID>"
#      When the user enters a picture "<filetype>"
      When the user clicks submit
      Then the table should refresh
      And no "<alert>" should show up
      And the new data should be associated with the "<userID>"
      And the user should be on the home page

      Examples:
      |moon|userID|filetype|alert|
      |Moonshadow|1|JPEG|void|
      |-Moonlet|1|PNG|void|
      |_Moonie|1|PNG|void|
      |Moon-Alpha|1|PNG|void|
      |Callisto 3|1|JPEG|void|
      |Ganymede_7|1|void|void|
      |Europa|1|JPEG|void|
      |Io|1|PNG|void|

    Scenario Outline: Sad Path Planet
      When the user clicks on the planet creation tab
        When the user enters in planet "<planet>"
#        When the user enters a picture "<filetype>"
        When the user clicks submit
        Then there should be a browser alert "<alert>"
        And the user should be on the home page

      Examples:
        |planet| filetype|alert|
        |!Venus| PNG|Invalid planet name|
        |void| PNG|Invalid planet name|
        |ThisPlanetNameIsWayTooLongToBeValid| JPEG|Invalid planet name|
        |Jupiter-Dash| BMP|Invalid file type|
        |Mars| JPEG|Invalid planet name|
        |Saturn| TXT|Invalid file type|


  Scenario Outline: Sad Path Moon
    When the user clicks on the moon creation tab
      When the user enters in moon "<moon>"
      When the user enters in planetId "<planetID>"
#      When the user enters a picture "<filetype>"
      When the user clicks submit
      Then there should be a browser alert "<alert>"
      And the user should be on the home page

      Examples:
        |moon|planetID|filetype|alert|
        |@Moon|1|PNG|Invalid moon name|
        |void|1|JPEG|Invalid moon name|
        |ThisMoonNameIsWayTooLongToBeValid|1|PNG|Invalid moon name|
        |Io|2|void|Invalid moon name|
        |Luna_|1|BMP|Invalid image type|
