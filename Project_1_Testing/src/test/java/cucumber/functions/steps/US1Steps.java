package cucumber.functions.steps;

import static cucumber.functions.steps.RunnerTest.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;


//import static hooks.HooksUS1.*;


public class US1Steps {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
//        Loginpage loginpage = new Loginpage();
        // Write code here that turns the phrase above into concrete actions
        loginpage.goToLoginPage();
        String actualUrl = loginpage.getUrl();
        String expectedUrl = "http://localhost:8080/";
        Assert.assertEquals(expectedUrl,actualUrl);

//        throw new io.cucumber.java.PendingException();
    }

    @When("the user clicks the register link")
    public void the_user_clicks_the_register_link() {
        // Write code here that turns the phrase above into concrete actions
        loginpage.clickRegisterLink();

        String actualUrl = registerpage.getUrl();

        Assert.assertTrue(actualUrl.contains("register"));
//        throw new io.cucumber.java.PendingException();
    }

    @When("the user provides a valid {string} and {string}")
    public void the_user_provides_a_valid_and(String string, String string2) {
        registerpage.enterUsername(string);
        registerpage.enterPassword(string2);
        registerpage.inputSubmit();
    }

    @Then("an alert should appear saying {string}")
    public void an_alert_should_appear_saying(String string) {

        Alert alert = null;
        registerpage.waitForAlert();
        alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();
        Assert.assertEquals(string,alertMessage);
    }
    @Then("the user should be directed to the login page")
    public void the_user_should_be_directed_to_the_login_page() {
        String actualUrl = loginpage.getUrl();
        Assert.assertTrue(actualUrl.contains("localhost:8080"));
    }


    @Then("the user should remain on the registration page")
    public void the_user_should_remain_on_the_registration_page() {
        // Write code here that turns the phrase above into concrete actions

        String actualUrl = registerpage.getUrl();
        Assert.assertTrue(actualUrl.contains("register"));

    }



    @When("the user provides an invalid {string} and_or {string}")
    public void the_user_provides_an_invalid_and_or(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        registerpage.enterUsername(string);
        registerpage.enterPassword(string2);
        registerpage.inputSubmit();
    }

}
