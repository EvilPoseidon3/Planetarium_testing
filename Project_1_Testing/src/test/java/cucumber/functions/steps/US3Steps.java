package cucumber.functions.steps;
import io.cucumber.java.en.*;
import org.junit.Assert;

import static cucumber.functions.steps.RunnerTest.*;

public class US3Steps {


    @Given("a successful login")
    public void a_successful_login() {
        loginpage.enterUsername("Batman");
        loginpage.enterPassword("Iamthenight1939");
        loginpage.inputSubmit();
        String actualTitle = homepage.getTitle();
        Assert.assertEquals("Home", actualTitle);
    }

    @When("the user enters {string} into the planetarium")
    public void the_user_enters_into_the_planetarium(String string) {
       if(string.equals("planet")){
           homepage.selectPlanetOrMoon(string);
           homepage.planetNameInput("357-Earth");
           homepage.clickSubmitButton();

       }else if(string.equals("moon") ) {
           homepage.selectPlanetOrMoon(string);
           homepage.moonInput("357-Moon");
           homepage.planetIdInput("1");
           homepage.clickSubmitButton();
       }
    }

    @Then("the users input is present for viewing and editing")
    public void the_users_input_is_present_for_viewing_and_editing() {
        Assert.assertTrue(homepage.getCelestialBodyInformation(homepage.getWorkingName()));
    }


    @Then("the users input is not present for viewing and editing")
    public void the_users_input_is_not_present_for_viewing_and_editing() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user does not have access to all their findings")
    public void the_user_does_not_have_access_to_all_their_findings() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
