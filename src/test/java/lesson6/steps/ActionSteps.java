package lesson6.steps;

import base.enums.Users;
import cucumber.api.java.en.When;
import lesson6.SelenideIndexPage;

public class ActionSteps {

    @When("^I login as user '([^\"]*)'$")
    public void iLoginAsUser(Users user){
        new SelenideIndexPage().login(user);

    }

}
