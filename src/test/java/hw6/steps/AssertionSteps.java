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
        assertThat("Username is correct", new SelenideIndexPage().getUserName().equals(username));
    }

    @Then("^I am on the '([^\"]*)'$")
    public void iAmOnTheHomePage(String pageTitle) {
        assertThat("Page title is correct", pageTitle.equalsIgnoreCase(getWebDriver().getTitle()));
    }

    @Then("^I see the pictures and texts underneath them$")
    public void iSeeThePicturesAndTextsUnderneathThem(List<String> textUnderPictures) {
        new SelenideIndexPage().checkBenefitIcons();
        new SelenideIndexPage().checkBenefitIconsText(textUnderPictures);
    }

    @Then("^There's Service Dropdown with the correct items in the header menu$")
    public void thereSServiceDropdownWithTheCorrectItems() {
        new SelenideIndexPage().checkServicesDropdownMenuInHeader();
    }

    @Then("^There's Service Dropdown with the correct items in the sidebar menu$")
    public void thereSServiceDropdownWithTheCorrectItemsInTheSidebarMenu() {
        new SelenideIndexPage().checkServicesDropdownMenuInSidebar();
    }

    @Then("^I see (\\d+) checkboxes, (\\d+) radios, (\\d+) buttons and (\\d+) dropdown on the Different Elements Page$")
    public void seeAllNeededElementsOnTheDifferentElementsPage(int totalCheckboxes, int totalRadios, int totalButtons, int totalDropdowns) {
        new SelenideDifferentElementsPage().checkDifferentElementsPageGUI(totalCheckboxes, totalRadios, totalDropdowns, totalButtons);
    }

    @Then("^I see the left section$")
    public void iSeeTheLeftSection() {
        new SelenideDifferentElementsPage().assertLeftSectionDisplayed();
    }

    @Then("^I see the right section$")
    public void iSeeTheRightSection() {
        new SelenideDifferentElementsPage().assertRightSectionDisplayed();
    }

    @Then("^I can select radiobutton '([^\"]*)'$")
    public void iCanSelectRadiobuttonAndTheSelectionIsLogged(String radioButtonLabel) {
        new SelenideDifferentElementsPage().selectRadio(getRadioControlByTheName(radioButtonLabel));
    }

    @Then("^I can select dropdown '([^\"]*)'$")
    public void iCanSelectDropdownYELLOW(String dropdownName) {
        new SelenideDifferentElementsPage().selectDropdownItem(getDropDownByTheName(dropdownName));
    }

    @Then("^'([^\"]*)' page is opened$")
    public void pageIsOpened(String pageName) {
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
    public void droplistContainsValues(String username, List<String> dropDownItems) {
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

    @Then("^I see following strings in the log$")
    public void iSeeFollowingStringsInTheLog(List<String> logText) {
        new SelenideDifferentElementsPage().checkActionLog(logText);
    }
}
