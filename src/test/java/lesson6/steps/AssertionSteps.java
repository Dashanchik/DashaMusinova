package lesson6.steps;

import base.enums.Users;
import cucumber.api.java.en.Then;
import lesson6.SelenideIndexPage;

public class AssertionSteps {

    @Then("^User name should be '([^\"]*)'$")
    public void userNameShouldBe(Users user) {
        new SelenideIndexPage().getUserName().equalsIgnoreCase(user.login);
    }
}
