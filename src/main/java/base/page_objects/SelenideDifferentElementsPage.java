package base.page_objects;

import base.SelenideBase;
import base.enums.*;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SelenideDifferentElementsPage extends SelenideBase {

    @FindBy(css = "[class='uui-navigation nav navbar-nav m-l8']>li")
    private List<SelenideElement> headerMenuItems;

    @FindBy(css = "[name=navigation-sidebar]")
    private SelenideElement sidebarMenu;

    @FindBy(css = "[class^='footer']")
    private SelenideElement footer;

    @FindBy(css = "[class='checkbox-row']")
    private SelenideElement checkboxesRow;

    @FindBy(css = "[class='label-checkbox']")
    private List<SelenideElement> checkboxes;

    @FindBy(css = "[class='label-radio']")
    private List<SelenideElement> radioControls;

    @FindBy(css = "select")
    private List<SelenideElement> dropdownColors;

    @FindBy(css = "[class='uui-button']")
    private List<SelenideElement> buttons;

    @FindBy(css = "[class='panel-body-list logs']")
    private SelenideElement rightPanelLogWindow;

    public SelenideDifferentElementsPage() {
        page(this);
    }

    public void checkDifferentElementsPageGUI(int checkboxesCount, int radiosCount, int dropdownsCount, int buttonsCount) {
        assertEquals(checkboxes.size(), checkboxesCount);
        assertEquals(checkboxes.stream().filter(box -> !box.isDisplayed()).collect(Collectors.toList()).size(), 0);
        assertEquals(radioControls.size(), radiosCount);
        assertEquals(radioControls.stream().filter(control -> !control.isDisplayed()).collect(Collectors.toList()).size(), 0);
        assertEquals(dropdownColors.size(), dropdownsCount);
        assertTrue(dropdownColors.get(0).isDisplayed());
        assertEquals(buttons.size(), buttonsCount);
        assertEquals(buttons.stream().filter(button -> !button.isDisplayed()).collect(Collectors.toList()).size(), 0);
    }

    public void assertRightSectionDisplayed() {
        assertTrue($("[class^='uui-side-bar right']").isDisplayed());
    }

    public void assertLeftSectionDisplayed() {
        assertTrue($("[name^='navigation-sidebar']").isDisplayed());
    }

    public void changeCheckboxState(String label) {
        checkboxesRow.find(new Selectors.ByText(label)).click();
    }

    public void checkCheckboxesEnabledActionLog(String label) {
        rightPanelLogWindow.find(By.tagName("li")).shouldHave(text(label + ": condition changed to true"));
    }

    public void checkCheckboxesDisabledActionLog(String label) {
        rightPanelLogWindow.find(By.tagName("li")).shouldHave(text(label + ": condition changed to false"));
    }

    public void checkActionLog(List<String> log) {
        for (int index = 0; index < log.size(); index++) {
            rightPanelLogWindow.findAll(By.tagName("li")).get(index).shouldHave(text(log.get(index)));
        }
    }

    public void selectRadio(RadioControls label) {
        SelenideElement radioControl = radioControls.stream().filter(box -> box.getText().equalsIgnoreCase(label.toString())).findFirst().get();
        radioControl.click();
    }

    public void checkRadioControlsActionLog(RadioControls label) {
        rightPanelLogWindow.find(By.tagName("li")).shouldHave(text("metal: value changed to " + label.toString()));
    }

    public void selectDropdownItem(DropDownValues dropDownItem) {
        dropdownColors.get(0).selectOptionContainingText(dropDownItem.toString());
    }

    public void checkDropdownActionLog(DropDownValues dropDownItem) {
        selectDropdownItem(dropDownItem);
        rightPanelLogWindow.find(By.tagName("li")).shouldHave(text("Colors: value changed to " + dropDownItem.toString()));
    }

    public void assertCheckboxDisabled(CheckboxesLabels label) {
        checkboxes.stream().filter(box -> box.getText().equalsIgnoreCase(label.toString())).findFirst().get().shouldNotBe(checked);
    }
}