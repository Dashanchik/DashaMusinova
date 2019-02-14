package base.page_objects;

import base.SelenideBase;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import java.util.List;

public class SelenideDatesPage extends SelenideBase {

    // TODO Why is it public - deleted,  not needed for test - fixed
    @FindBy(css = "[class='uui-navigation nav navbar-nav m-l8']>li")
    private List<SelenideElement> headerMenuItems;

    @FindBy(css = "[name=navigation-sidebar]")
    private SelenideElement sidebarMenu;

    @FindBy(css = "[class^='footer']")
    private SelenideElement footer;

    @FindBy(css = "[class='panel-body-list logs']")
    private SelenideElement rightPanelLogWindow;

    @FindBy(css = "[class^='uui-slider']")
    private SelenideElement slider;

    private SelenideElement getLeftSliderHandle() {
        List<SelenideElement> sliders = slider.findAll(By.tagName("a"));
        return sliders.get(0);
    }

    private SelenideElement getRightSliderHandle() {
        List<SelenideElement> sliders = slider.findAll(By.tagName("a"));
        return sliders.get(1);
    }

    private int getSliderHandlePosition(SelenideElement slider) {
        String position = slider.getCssValue("left");
        String res = position.substring(0, (position.length() - 2));
        return (int) Math.ceil(Double.valueOf(res));
    }

    private void dragAndDropSlider(SelenideElement sliderHandle, int targetPosition) {
        int sliderHandlePosition = getSliderHandlePosition(sliderHandle);
        int sliderElementWidth = slider.getSize().width;
        int rangeToMove = sliderHandlePosition - sliderElementWidth * targetPosition / 100;
        Actions action = new Actions(getWebDriver());
        action.dragAndDropBy(sliderHandle, -rangeToMove, 0).release().build().perform();
    }

    @Step("Drag and drop left slider")
    public void dragAndDropLeftSlider(int leftHandleTargetPosition) {
        SelenideElement leftSliderHandle = getLeftSliderHandle();
        dragAndDropSlider(leftSliderHandle, leftHandleTargetPosition);
    }

    @Step("Drag and drop right slider")
    public void dragAndDropRightSlider(int rightHandleTargetPosition) {
        SelenideElement rightSliderHandle = getRightSliderHandle();
        dragAndDropSlider(rightSliderHandle, rightHandleTargetPosition);
    }

    @Step("Check log of the right slider")
    public void checkRightSliderLog(int rightSliderPosition, int rowIndex) {
        rightPanelLogWindow.findAll(By.tagName("li")).get(rowIndex).shouldHave(text("Range 2(To):" + rightSliderPosition + " link clicked"));
    }

    @Step("Check log of the left slider")
    public void checkLeftSliderLog(int leftSliderPosition, int rowIndex) {
        rightPanelLogWindow.findAll(By.tagName("li")).get(rowIndex).shouldHave(text("Range 2(From):" + leftSliderPosition + " link clicked"));
    }
}