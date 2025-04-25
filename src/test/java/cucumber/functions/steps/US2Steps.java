package cucumber.functions.steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.time.Duration;

import static cucumber.functions.steps.RunnerTest.*;

public class US2Steps {
    @When("the user enters in the correct {string} and {string}")
    public void the_user_enters_in_the_correct_and(String string, String string2) {
      loginpage.enterUsername(string);
      loginpage.enterPassword(string2);
      loginpage.inputSubmit();

    }
    @Then("the user is redirected to the planetarium homepage")
    public void the_user_is_redirected_to_the_planetarium_homepage() {

        String actualTitle = homepage.getTitle();

        Assert.assertEquals("Home", actualTitle);
    }

    @When("the user enters in the incorrect {string} and_or {string}")
    public void the_user_enters_in_the_incorrect_and_or(String string, String string2) {
        loginpage.enterUsername(string);
        loginpage.enterPassword(string2);
        loginpage.inputSubmit();
    }
    @Then("an alert message should be shown {string}")
    public void an_alert_message_should_be_shown(String string) {
        Alert alert = null;
        loginpage.waitForAlert();
      alert = driver.switchTo().alert();
      String alertText = alert.getText();
      alert.dismiss();
      Assert.assertEquals(string,alertText);

    }
    @Then("the user should remain on the login page")
    public void the_user_should_remain_on_the_login_page() {
      Assert.assertEquals("Planetarium Login",loginpage.getPageTitle());
    }

}
