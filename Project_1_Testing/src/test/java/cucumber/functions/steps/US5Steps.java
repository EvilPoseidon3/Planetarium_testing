package cucumber.functions.steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import static cucumber.functions.steps.RunnerTest.*;


public class US5Steps {
    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        loginpage.goToLoginPage();
        loginpage.enterUsername("Batman");
        loginpage.enterPassword("Iamthenight1939");
        loginpage.inputSubmit();
    }

    @When("clicks on the delete button")
    public void clicks_on_the_delete_button() {
        homepage.setListcount();
      homepage.clickDelete();
    }


    @When("the user types in an invalid {string} body")
    public void the_user_types_in_an_invalid_body(String string) {
        homepage.celestialBodyDeleteInput("FlatEarth");
    }

    @Then("an alert message saying {string} should be shown")
    public void an_alert_message_saying_should_be_shown(String string) {
        Alert alert = null;
        homepage.waitForAlert();
        alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.dismiss();
        Assert.assertEquals(string,alertText);
    }
    @Then("the user should stay on homepage")
    public void the_user_should_stay_on_homepage() {
      String url = homepage.getUrl();

      Assert.assertTrue(url.contains("planetarium"));
    }

    @When("the user types in a valid planet body")
    public void the_user_types_in_a_valid_planet_body() {
        homepage.selectPlanetOrMoon("planet");
        homepage.waitPageLoad();
        homepage.celestialBodyDeleteInput("Earth");
    }

    @Then("the corresponding planet and moon should be removed")
    public void the_corresponding_planet_and_moon_should_be_removed() {
        int before = homepage.getListcount();
        homepage.setListcount();
        System.out.println("this is the before:"+before+"  ---This is the after:"+homepage.getListcount());
        Assert.assertEquals(1, homepage.getListcount());
    }

    @When("the user types in a valid moon body")
    public void the_user_types_in_a_valid_moon_body() {
        homepage.selectPlanetOrMoon("moon");
        homepage.waitPageLoad();
     homepage.celestialBodyDeleteInput("Luna");

    }

    @Then("the corresponding moon should be removed")
    public void the_corresponding_moon_should_be_removed() {
        int before = homepage.getListcount();
        homepage.setListcount();
        System.out.println("this is the before:"+before+"  ---This is the after:"+homepage.getListcount());
        Assert.assertTrue(before > homepage.getListcount());
    }
}
