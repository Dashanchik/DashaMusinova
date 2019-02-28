package hw6.steps;

// TODO Delete unused imports
import base.enums.Users;
import base.page_objects.SelenideDifferentElementsPage;
import base.page_objects.SelenideUserTablePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lesson6.SelenideIndexPage;

import static base.enums.CheckboxesLabels.getCheckboxByTheName;

public class ActionSteps {

    @When("^I login as a user '([^\"]*)'$")
    public void iLoginAsUser(String user){
        new SelenideIndexPage().login(Users.getUserByTheName(user));

    }

    @When("^I go to '([^\"]*)' Page$")
    public void iGoToDifferentElementsPage(String pageName) {
        new SelenideIndexPage().openPageFromServicesMenuItemDropdown(pageName);

    }

    @When("^I click on '([^\"]*)' button in Header$")
    public void iClickOnServiceButtonInHeader(String menuItemName) {
        new SelenideIndexPage().getHeaderMenuItemByName(menuItemName).click();
    }

    // TODO Please make proper annotation
    @And("^I click on '([^\"]*)' button in Service dropdown$")
    public void iClickOnButtonInServiceDropdown(String menuItemName) {
        new SelenideIndexPage().openPageFromServicesMenuItemDropdown(menuItemName);
    }

    @When("^I select vip checkbox for '([^\"]*)'$")
    public void iSelectVipCheckboxFor(String userName) {
        new SelenideUserTablePage().seleckVipCheckboxForUser(userName);
    }

    @When("^I click on dropdown in column Type for user '([^\"]*)'$")
    public void iClickOnDropdownInColumnTypeForUserRoman(String username) {
        new SelenideUserTablePage().clickDropdownOfUser(username);
    }


    @When("^I select checkbox '([^\"]*)'$")
    public void iSelectCheckboxWind(String checkboxLabel) {
        new SelenideDifferentElementsPage().changeCheckboxState(checkboxLabel);
    }
}