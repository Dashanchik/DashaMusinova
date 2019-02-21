package lesson6.steps;

import base.enums.Users;
import base.lesson7.entities.PO.SelenideUserTablePage;
import base.lesson7.entities.SuperHero;
import cucumber.api.java.en.Then;
import lesson6.SelenideIndexPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;


public class AssertionSteps {

    @Then("^User name should be '([^\"]*)'$")
    public void userNameShouldBe(Users user) {
        assertThat("User name is correct", new SelenideIndexPage().getUserName().equals(user.login));
    }

    @Then("^User table contains following values:$")
    public void userTableContainsFollowingValues(List<SuperHero> superhero) {
        new SelenideUserTablePage().checkSuperheroes(superhero);
    }
}
