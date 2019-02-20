package hw6.steps;

import base.enums.CheckboxesLabels;
import base.page_objects.SelenideDifferentElementsPage;
import base.page_objects.SelenideUserTablePage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import lesson6.SelenideIndexPage;

import java.util.List;

import static base.enums.CheckboxesLabels.getCheckboxByTheName;
import static base.enums.DropDownValues.getDropDownByTheName;
import static base.enums.RadioControls.getRadioControlByTheName;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AssertionSteps {

    @Then("^User name should be as '([^\"]*)'$")
    public void userNameShouldBe(String username) {
        // TODO Why you don't use Assert?
        assert new SelenideIndexPage().getUserName().equals(username);
    }

    // TODO It will be better if you change all @And to @Then
    @And("^I am on the '([^\"]*)'$")
    public void iAmOnTheHomePage(String pageTitle) {
        assert pageTitle.equalsIgnoreCase(getWebDriver().getTitle());
    }

    @And("^I see the pictures and texts underneath them$")
    public void iSeeThePicturesAndTextsUnderneathThem() {
        new SelenideIndexPage().checkBenefitIcons();
        new SelenideIndexPage().checkBenefitIconsText();
    }

    @And("^There's Service Dropdown with the correct items in the header menu$")
    public void thereSServiceDropdownWithTheCorrectItems() {
        new SelenideIndexPage().checkServicesDropdownMenuInHeader();
    }

    @And("^There's Service Dropdown with the correct items in the sidebar menu$")
    public void thereSServiceDropdownWithTheCorrectItemsInTheSidebarMenu() {
        new SelenideIndexPage().checkServicesDropdownMenuInSidebar();
    }

    @And("^See all needed elements on the Different Elements Page$")
    public void seeAllNeededElementsOnTheDifferentElementsPage() {
        new SelenideDifferentElementsPage().checkDifferentElementsPageGUI();
    }

    @And("^I see the left section$")
    public void iSeeTheLeftSection() {
        new SelenideDifferentElementsPage().assertLeftSectionDisplayed();
    }

    @And("^I see the right section$")
    public void iSeeTheRightSection() {
        new SelenideDifferentElementsPage().assertRightSectionDisplayed();
    }

    @And("^I can select checkbox '([^\"]*)' and the selection is logged$")
    public void iCanSelectCheckboxesWINDAndWATERAndTheyReLogged(String checboxLabel) {
        // TODO IF enum is one word you could send it as parameter into method
        new SelenideDifferentElementsPage().checkCheckboxesEnableActionLog(getCheckboxByTheName(checboxLabel));
    }

    @And("^I can select radiobutton '([^\"]*)' and the selection is logged$")
    public void iCanSelectRadiobuttonAndTheSelectionIsLogged(String radioButtonLabel) {
        // TODO IF enum is one word you could send it as parameter into method
        new SelenideDifferentElementsPage().checkRadioControlsActionLog(getRadioControlByTheName(radioButtonLabel));

    }

    @And("^I can select dropdown '([^\"]*)'$")
    public void iCanSelectDropdownYELLOW(String dropdownName) {
        // TODO IF enum is one word you could send it as parameter into method
        new SelenideDifferentElementsPage().selectDropdownItem(getDropDownByTheName(dropdownName));
    }

    @And("^I can unselect the checkbox '([^\"]*)' and the selection is logged$")
    public void iCanUnselectTheCheckboxAndTheSelectionIsLogged(CheckboxesLabels checkboxLabel) {
        // TODO IF enum is one word you could send it as parameter into method
        new SelenideDifferentElementsPage().checkCheckboxesDisableActionLog(checkboxLabel);
    }

    @Then("^'([^\"]*)' page is opened$")
    public void pageIsOpened(String pageName) {
        // TODO Why you use hardcode here?
        assert pageName.equals(SelenideUserTablePage.PAGE_TITLE);
    }

    @And("^(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void numbertypeDropdownsAreDisplayedOnUsersTableOnUserTablePage(int numberOfDropdowns) {
        new SelenideUserTablePage().checkTheNumberOfDropdownsInTheUserTable(numberOfDropdowns);
    }

    @And("^(\\d+) User names are displayed on Users Table on User Table Page$")
    public void userNamesAreDisplayedOnUsersTableOnUserTablePage(int numberOfUsernames) {
        new SelenideUserTablePage().checkTheNumberOfUserNamesInTheUserTable(numberOfUsernames);
    }

    @And("^(\\d+) Description images are displayed on Users Table on User Table Page$")
    public void descriptionImagesAreDisplayedOnUsersTableOnUserTablePage(int numberOfImages) {
        new SelenideUserTablePage().checkTheNumberOfImagesInTheTable(numberOfImages);
    }

    @And("^(\\d+) Description texts under images are displayed on Users Table on User Table Page$")
    public void descriptionTextsUnderImagesAreDisplayedOnUsersTableOnUserTablePage(int numberOfImagesDescriptionText) {
        new SelenideUserTablePage().checkTheNumberOfImageDescriptionTextsInTheTable(numberOfImagesDescriptionText);
    }

    @And("^(\\d+) checkboxes are displayed on Users Table on User Table Page$")
    public void checkboxesAreDisplayedOnUsersTableOnUserTablePage(int numberOfCheckboxes) {
        new SelenideUserTablePage().checkTheNumberOfCheckboxesInTheTable(numberOfCheckboxes);
    }

    @Then("^(\\d+) log row has '([^\"]*)' text in log section$")
    public void logRowHasTextInLogSection(int numberOfRowInLog, String textInLog) {
        new SelenideUserTablePage().checkRightPanelLog(numberOfRowInLog, textInLog);
    }

    @And("^User table contains following values:$")
    public void userTableContainsFollowingValues(DataTable userTable) {
        List<List<String>> data = userTable.raw();
        new SelenideUserTablePage().checkTheTableContents(data);
    }

    @Then("^droplist contains values$")
    // TODO List<String> could be used instead of DataTable
    public void droplistContainsValues(DataTable dropDownItems){
    List<String> listOfDDownItems = dropDownItems.asList(String.class);
    new SelenideUserTablePage().checkTheDropDownUserTypeItems(listOfDDownItems);
    }
}
