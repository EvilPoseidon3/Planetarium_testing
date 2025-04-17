package cucumber.functions.steps;

import io.cucumber.java.en.*;

public class US1Steps {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Action 1");
//        throw new io.cucumber.java.PendingException();
    }
    @When("the user clicks the register link")
    public void the_user_clicks_the_register_link() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Action 2");
//        throw new io.cucumber.java.PendingException();
    }
    @When("the user provides a valid username")
    public void the_user_provides_a_valid_username() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Action 3");
//        throw new io.cucumber.java.PendingException();
    }
    @When("the user provides a valid password")
    public void the_user_provides_a_valid_password() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Action 4");
//        throw new io.cucumber.java.PendingException();
    }
    @Then("an alert should appear saying {string}")
    public void an_alert_should_appear_saying(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Action 5");
//        throw new io.cucumber.java.PendingException();
    }
    @Then("the user should be directed to the login page")
    public void the_user_should_be_directed_to_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Action 6");
//        throw new io.cucumber.java.PendingException();
    }

    @When("the user provides invalid registration information")
    public void the_user_provides_invalid_registration_information() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        System.out.println("Action 7");

    }
    @Then("the user should be shown an alert {string}")
    public void the_user_should_be_shown_an_alert(String string) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        System.out.println("Action 8");

    }
    @Then("the user should remain on the registration page")
    public void the_user_should_remain_on_the_registration_page() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        System.out.println("Action 9");

    }

    @When("the user provides a valid {string} and {string}")
    public void the_user_provides_a_valid_and(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user provides an invalid {string} and_or {string}")
    public void the_user_provides_an_invalid_and_or(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
