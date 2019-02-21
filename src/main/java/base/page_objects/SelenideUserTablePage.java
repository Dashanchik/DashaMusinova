package base.page_objects;

import base.SelenideBase;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;
import static org.hamcrest.MatcherAssert.assertThat;

public class SelenideUserTablePage extends SelenideBase {

    public static final String PAGE_TITLE = "User Table";

    @FindBy(css = "[id='user-table']")
    private SelenideElement userTable;

    @FindBy(css = "[class='panel-body-list logs']")
    private SelenideElement rightPanelLogWindow;

    public SelenideUserTablePage() {
        page(this);
    }

    public void checkTheNumberOfDropdownsInTheUserTable(int numberOfDropdowns) {
        List<SelenideElement> dropdownsList = userTable.findAll(By.tagName("select"));
        ((ElementsCollection) dropdownsList).shouldHaveSize(numberOfDropdowns);
    }

    public void checkTheNumberOfUserNamesInTheUserTable(int numberOfUsernames) {
        List<SelenideElement> userNamesList = userTable.findAll(By.tagName("a"));
        ((ElementsCollection) userNamesList).shouldHaveSize(numberOfUsernames);
    }

    public void checkTheNumberOfImagesInTheTable(int numberOfImages) {
        List<SelenideElement> imagesList = userTable.findAll(By.tagName("img"));
        ((ElementsCollection) imagesList).shouldHaveSize(numberOfImages);
    }

    public void checkTheNumberOfImageDescriptionTextsInTheTable(int numberOfImagesDescriptionText) {
        List<SelenideElement> descriptionTextsList = userTable.findAll(By.className("user-descr"));
        ((ElementsCollection) descriptionTextsList).shouldHaveSize(numberOfImagesDescriptionText);
    }

    public void checkTheNumberOfCheckboxesInTheTable(int numberOfCheckboxes) {
        List<SelenideElement> checkBoxesList = userTable.findAll(By.cssSelector("[type='checkbox']"));
        ((ElementsCollection) checkBoxesList).shouldHaveSize(numberOfCheckboxes);
    }

    public void checkTheTableContents(List<List<String>> data) {
        // TODO Why List<SelenideElement>??? - fixed
        ElementsCollection actualRowsOfElements = userTable.findAll(By.tagName("tr"));
        List<String> testTableFirstRow = data.get(0);
        List<String> actualTableHeaderRow = actualRowsOfElements.get(0).findAll(By.tagName("th")).stream().map(SelenideElement::getText).collect(Collectors.toList());
        validateTableRowsData(testTableFirstRow, actualTableHeaderRow);

        for (int index = 1; index < data.size(); index++) {
            List<String> testTableRow = data.get(index);
            List<String> actualTableRow = actualRowsOfElements.get(index).findAll(By.tagName("td")).stream().map(SelenideElement::getText).collect(Collectors.toList());
            validateTableRowsData(testTableRow, actualTableRow);
        }
    }

    private void validateTableRowsData(List<String> testTableRow, List<String> actualTableRow) {
        // TODO assert??? - fixed
        assertThat("Table row 0 is equal", testTableRow.get(0).equals(actualTableRow.get(0).substring(0,testTableRow.get(0).length()).replace("\n", " ")));
        assertThat("Table row 1 is equal", testTableRow.get(1).equals(actualTableRow.get(2).substring(0,testTableRow.get(1).length()).replace("\n", " ")));
        assertThat("Table row 2 is equal", testTableRow.get(2).equals(actualTableRow.get(3).substring(0,testTableRow.get(2).length()).replace("\n", " ")));
    }

    public void seleckVipCheckboxForUser(String userName) {
        SelenideElement userRow = userTable.find(By.xpath("//*[contains(text(), '" + userName + "')]//ancestor::tr"));
        SelenideElement checkBox = userRow.find(By.cssSelector("[type='checkbox'"));
        checkBox.click();
    }

    public void checkRightPanelLog(int numberOfRow, String textInLog) {
        List<SelenideElement> logRows = rightPanelLogWindow.findAll(By.tagName("li"));
        logRows.get(numberOfRow - 1).shouldHave(text(textInLog));
    }

    public void clickDropdownOfUser(String username) {
        SelenideElement userRowForDropdownMethod = userTable.find(By.xpath("//*[contains(text(), '" + username + "')]//ancestor::tr"));
        SelenideElement dropDown = userRowForDropdownMethod.find(By.tagName("select"));
        dropDown.click();
    }

    public void checkTheDropDownUserTypeItems(String username, List<String> dropDownValuesHTML) {
        SelenideElement userRowForDropdownMethod = userTable.find(By.xpath("//*[contains(text(), '" + username + "')]//ancestor::tr"));
        SelenideElement dropDown = userRowForDropdownMethod.find(By.tagName("select"));
        List<String> dropDownTextList = dropDown.findAll(By.tagName("option")).stream().map(SelenideElement::getText).collect(Collectors.toList());
        assert dropDownTextList.containsAll(dropDownValuesHTML);
    }
}
