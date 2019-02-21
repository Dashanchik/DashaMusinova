package hw6.steps;

import base.page_objects.SelenideDifferentElementsPage;
import base.page_objects.SelenideUserTablePage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import lesson6.SelenideIndexPage;

import java.util.List;

import static base.enums.DropDownValues.getDropDownByTheName;
import static base.enums.RadioControls.getRadioControlByTheName;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertionSteps {

    @Then("^User name should be as '([^\"]*)'$")
    public void userNameShouldBe(String username) {
        // TODO Why you don't use Assert? - fixed, changed to assertThat
         assertThat("Username is correct", new SelenideIndexPage().getUserName().equals(username));
    }

    // TODO It will be better if you change all @And to @Then - fixed
    @Then("^I am on the '([^\"]*)'$")
    public void iAmOnTheHomePage(String pageTitle) {
        assertThat("Page title is correct", pageTitle.equalsIgnoreCase(getWebDriver().getTitle()));
    }

    @Then("^I see the pictures and texts underneath them$")
    public void iSeeThePicturesAndTextsUnderneathThem() {
        new SelenideIndexPage().checkBenefitIcons();
        new SelenideIndexPage().checkBenefitIconsText();
    }

    @Then("^There's Service Dropdown with the correct items in the header menu$")
    public void thereSServiceDropdownWithTheCorrectItems() {
        new SelenideIndexPage().checkServicesDropdownMenuInHeader();
    }

    @Then("^There's Service Dropdown with the correct items in the sidebar menu$")
    public void thereSServiceDropdownWithTheCorrectItemsInTheSidebarMenu() {
        new SelenideIndexPage().checkServicesDropdownMenuInSidebar();
    }

    @Then("^I see all needed elements on the Different Elements Page$")
    public void seeAllNeededElementsOnTheDifferentElementsPage() {
        new SelenideDifferentElementsPage().checkDifferentElementsPageGUI();
    }

    @Then("^I see the left section$")
    public void iSeeTheLeftSection() {
        new SelenideDifferentElementsPage().assertLeftSectionDisplayed();
    }

    @Then("^I see the right section$")
    public void iSeeTheRightSection() {
        new SelenideDifferentElementsPage().assertRightSectionDisplayed();
    }

        @Then("^I can select radiobutton '([^\"]*)' and the selection is logged$")
    public void iCanSelectRadiobuttonAndTheSelectionIsLogged(String radioButtonLabel) {
        // TODO IF enum is one word you could send it as parameter into method - it's more convenient to the Cucumber feature file User to write it as a simple line, not using Caps (as in Enum), I'd prefer not to change it
        new SelenideDifferentElementsPage().checkRadioControlsActionLog(getRadioControlByTheName(radioButtonLabel));

    }

    @Then("^I can select dropdown '([^\"]*)'$")
    public void iCanSelectDropdownYELLOW(String dropdownName) {
        // TODO IF enum is one word you could send it as parameter into method - it's more convenient to the Cucumber feature file User to write it as a simple line, not using Caps (as in Enum), I'd prefer not to change it
        new SelenideDifferentElementsPage().selectDropdownItem(getDropDownByTheName(dropdownName));
    }

    @Then("^'([^\"]*)' page is opened$")
    public void pageIsOpened(String pageName) {
        // TODO Why you use hardcode here? - the test validates the page name from the PO SelenideUserTablePage. In case the name will change, it'd be necessary to change it in the PO too
        assert pageName.equals(SelenideUserTablePage.PAGE_TITLE);
    }

    @Then("^(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void numbertypeDropdownsAreDisplayedOnUsersTableOnUserTablePage(int numberOfDropdowns) {
        new SelenideUserTablePage().checkTheNumberOfDropdownsInTheUserTable(numberOfDropdowns);
    }

    @Then("^(\\d+) User names are displayed on Users Table on User Table Page$")
    public void userNamesAreDisplayedOnUsersTableOnUserTablePage(int numberOfUsernames) {
        new SelenideUserTablePage().checkTheNumberOfUserNamesInTheUserTable(numberOfUsernames);
    }

    @Then("^(\\d+) Description images are displayed on Users Table on User Table Page$")
    public void descriptionImagesAreDisplayedOnUsersTableOnUserTablePage(int numberOfImages) {
        new SelenideUserTablePage().checkTheNumberOfImagesInTheTable(numberOfImages);
    }

    @Then("^(\\d+) Description texts under images are displayed on Users Table on User Table Page$")
    public void descriptionTextsUnderImagesAreDisplayedOnUsersTableOnUserTablePage(int numberOfImagesDescriptionText) {
        new SelenideUserTablePage().checkTheNumberOfImageDescriptionTextsInTheTable(numberOfImagesDescriptionText);
    }

    @Then("^(\\d+) checkboxes are displayed on Users Table on User Table Page$")
    public void checkboxesAreDisplayedOnUsersTableOnUserTablePage(int numberOfCheckboxes) {
        new SelenideUserTablePage().checkTheNumberOfCheckboxesInTheTable(numberOfCheckboxes);
    }

    @Then("^(\\d+) log row has '([^\"]*)' text in log section$")
    public void logRowHasTextInLogSection(int numberOfRowInLog, String textInLog) {
        new SelenideUserTablePage().checkRightPanelLog(numberOfRowInLog, textInLog);
    }

    @Then("^User table contains following values:$")
    public void userTableContainsFollowingValues(DataTable userTable) {
        List<List<String>> data = userTable.raw();
        new SelenideUserTablePage().checkTheTableContents(data);
    }

    @Then("^'([^\"]*)' droplist contains values$")
    // TODO List<String> could be used instead of DataTable - fixed
    public void droplistContainsValues(String username, List<String> dropDownItems){
    new SelenideUserTablePage().checkTheDropDownUserTypeItems(username, dropDownItems);
    }

    @Then("^The selection of '([^\"]*)' is logged$")
    public void theSelectionOfWindIsLogged(String label) {
        new SelenideDifferentElementsPage().checkCheckboxesEnabledActionLog(label);
    }


    @Then("^The deselection of '([^\"]*)' is logged$")
    public void theDeselectionOfWaterIsLogged(String label) {
        new SelenideDifferentElementsPage().checkCheckboxesDisabledActionLog(label);
    }
}
