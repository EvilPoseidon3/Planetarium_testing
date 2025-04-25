package cucumber.functions.steps;

import POM.Homepage;
import POM.Loginpage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.PageFactory;
import static cucumber.functions.steps.RunnerTest.*;


public class US4Steps {

    @When("the user clicks on the planet creation tab")
    public void the_user_clicks_on_the_planet_creation_tab() {
       homepage.selectPlanetOrMoon("planet");
       homepage.waitPageLoad();

    }

    @When("the user clicks on the moon creation tab")
    public void the_user_clicks_on_the_moon_creation_tab() {
       homepage.selectPlanetOrMoon("moon");
       homepage.waitPageLoad();
    }

    @Given("the user has logged in successfully")
    public void the_user_has_logged_in_successfully(){
        loginpage.goToLoginPage();
        loginpage.enterUsername("Batman");
        loginpage.enterPassword("Iamthenight1939");
        loginpage.inputSubmit();

    }

    @When("the user enters in planet {string}")
    public void the_user_enters_in_planet(String string) {
        homepage.planetNameInput(string);
        homepage.setWorkingName(string);

    }

    @When("the user enters a picture {string}")
    public void the_user_enters_a_picture(String string) {
        String absolutePath = switch (string) {
            case "JPEG" ->
                    "C:\\Users\\Preston\\OneDrive\\Desktop\\Code\\Planetarium_testing\\Project_1_Testing\\src\\test\\resources\\Test Data\\JPEG-picuture.jpg";
            case "PNG" ->
                    "C:\\Users\\Preston\\OneDrive\\Desktop\\Code\\Planetarium_testing\\Project_1_Testing\\src\\test\\resources\\Test Data\\PNG-picture.png";
            default ->
                    "C:\\Users\\Preston\\OneDrive\\Desktop\\Code\\Planetarium_testing\\Project_1_Testing\\src\\test\\resources\\Test Data\\picture.txt";
        };
        homepage.uploadPicture(absolutePath);
        homepage.waitForPicture();
    }

    @When("the user clicks submit")
    public void the_user_clicks_submit() throws InterruptedException {
        homepage.setListcount();
        homepage.clickSubmitButton();



    }

    @When("the user enters in moon {string}")
    public void the_user_enters_in_moon(String string) {
       homepage.setMoonInput(string);
       homepage.setWorkingName(string);
    }

    @When("the user enters in planetId {string}")
    public void the_user_enters_in_planet_id(String string) {
        homepage.planetIdInput(string);
    }

    @Then("the table should refresh")
    public void the_table_should_refresh() {
        int before = homepage.getListcount();
        homepage.setListcount();
        System.out.println("this is the before:"+before+"  ---This is the after:"+homepage.getListcount());
        Assert.assertTrue(before < homepage.getListcount());

    }

    @Then("no {string} should show up")
    public void no_should_show_up(String string) {
        boolean alertPresent;
        try {
            Alert alert = driver.switchTo().alert();
            // If alert is present, return true
            alertPresent = true;
        } catch (NoAlertPresentException e) {
            // If no alert is present, return false
            alertPresent = false;
        }
        Assert.assertFalse(alertPresent);
    }

    @Then("the new data should be associated with the {string}")
    public void the_new_data_should_be_associated_with_the(String string) {
        String actualId = homepage.getCelestialOwnerId(homepage.getWorkingName());

        Assert.assertEquals(string,actualId);
    }

    @Then("the user should be on the home page")
    public void the_user_should_be_on_the_home_page() {
     Assert.assertTrue(homepage.getUrl().contains("planetarium"));
    }

    @Then("there should be a browser alert {string}")
    public void there_should_be_a_browser_alert(String string) {
        boolean alertPresent = false;
        Alert alert;
        try {
            homepage.waitForAlert();
            alert = driver.switchTo().alert();
            String alertText = alert.getText().trim();
            alert.dismiss();
            // If alert is present, return true
            alertPresent = alertText.equals(string);
        } catch (NoAlertPresentException e) {
            // If no alert is present, return false
//            alertPresent = false;
        }
        Assert.assertTrue(alertPresent);
      }
    }


