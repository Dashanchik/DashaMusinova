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
        assert userTable.find(By.xpath("//tbody/tr[1]/th[1]")).getText().equals(data.get(0).get(0));
        assert userTable.find(By.xpath("//tbody/tr[1]/th[3]")).getText().equals(data.get(0).get(1));
        assert userTable.find(By.xpath("//tbody/tr[1]/th[4]")).getText().equals(data.get(0).get(2));
        assert userTable.find(By.xpath("//tbody/tr[2]/td[1]")).getText().equals(data.get(1).get(0));
        assert userTable.find(By.xpath("//tbody/tr[2]/td[3]")).getText().equals(data.get(1).get(1));
        assert userTable.find(By.xpath("//tbody/tr[2]/td[4]/div/span")).getText().equals(data.get(1).get(2));
        assert userTable.find(By.xpath("//tbody/tr[3]/td[1]")).getText().equals(data.get(2).get(0));
        assert userTable.find(By.xpath("//tbody/tr[3]/td[3]")).getText().equals(data.get(2).get(1));
        assert userTable.find(By.xpath("//tbody/tr[3]/td[4]/div/span")).getText().equals(data.get(2).get(2));
        assert userTable.find(By.xpath("//tbody/tr[4]/td[1]")).getText().equals(data.get(3).get(0));
        assert userTable.find(By.xpath("//tbody/tr[4]/td[3]")).getText().equals(data.get(3).get(1));
        assert userTable.find(By.xpath("//tbody/tr[4]/td[4]/div/span")).getText().equals(data.get(3).get(2));
        assert userTable.find(By.xpath("//tbody/tr[5]/td[1]")).getText().equals(data.get(4).get(0));
        assert userTable.find(By.xpath("//tbody/tr[5]/td[3]")).getText().equals(data.get(4).get(1));
        assert userTable.find(By.xpath("//tbody/tr[5]/td[4]/div/span")).getText().replace("\n", " ").contains(data.get(4).get(2));
        assert userTable.find(By.xpath("//tbody/tr[6]/td[1]")).getText().equals(data.get(5).get(0));
        assert userTable.find(By.xpath("//tbody/tr[6]/td[3]")).getText().equals(data.get(5).get(1));
        assert userTable.find(By.xpath("//tbody/tr[6]/td[4]/div/span")).getText().replace("\n", " ").equals(data.get(5).get(2));
        assert userTable.find(By.xpath("//tbody/tr[7]/td[1]")).getText().equals(data.get(6).get(0));
        assert userTable.find(By.xpath("//tbody/tr[7]/td[3]")).getText().equals(data.get(6).get(1));
        assert userTable.find(By.xpath("//tbody/tr[7]/td[4]/div/span")).getText().replace("\n", " ").equals(data.get(6).get(2));
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

    public void clickDropdownOfUser() {
        SelenideElement userRowForDropdownMethod = userTable.find(By.xpath("//*[contains(text(), 'Roman')]//ancestor::tr"));
        SelenideElement dropDown = userRowForDropdownMethod.find(By.tagName("select"));
        dropDown.click();
    }

    public void checkTheDropDownUserTypeItems(List<String> dropDownValuesHTML) {
        SelenideElement userRowForDropdownMethod = userTable.find(By.xpath("//*[contains(text(), 'Roman')]//ancestor::tr"));
        SelenideElement dropDown = userRowForDropdownMethod.find(By.tagName("select"));
        List<String> dropDownTextList = dropDown.findAll(By.tagName("option")).stream().map(SelenideElement::getText).collect(Collectors.toList());
        assert dropDownTextList.containsAll(dropDownValuesHTML);
    }
}
