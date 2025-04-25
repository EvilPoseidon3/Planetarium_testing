package cucumber.functions.steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import static cucumber.functions.steps.RunnerTest.*;

public class US3Steps {


    @Given("a successful login")
    public void a_successful_login() {

        loginpage.enterUsername("Batman");
        loginpage.enterPassword("Iamthenight1939");
        loginpage.inputSubmit();

    }

    @When("the user enters {string} into the planetarium")
    public void the_user_enters_into_the_planetarium(String string) {

          homepage.selectPlanetOrMoon(string);
          if (string.equals("planet")) {
                String planetName = "357-Earth";
              homepage.planetNameInput(planetName);
              homepage.setWorkingName(planetName);
              homepage.clickSubmitButton();
//              homepage.waitPageLoad();

          } else if (string.equals("moon")) {
              String moonName = "357-Moon" ;
              homepage.setMoonInput(moonName);
              homepage.planetIdInput("1");
              homepage.setWorkingName(moonName);
              homepage.clickSubmitButton();
//              homepage.waitPageLoad();
//              try {
//                  Thread.sleep(50000); // pauses for 5 seconds
//              } catch (InterruptedException e) {
//                  e.printStackTrace();
//              }
          }
    }

    @Then("the users input is present for viewing and editing")
    public void the_users_input_is_present_for_viewing_and_editing() {
       homepage.waitPageLoad();
        PageFactory.initElements(driver,this);

        boolean nameIsPresent = homepage.getCelestialBodyInformation(homepage.getWorkingName());

        Assert.assertTrue("names match", nameIsPresent);
    }




}
