package hw4;

import base.SelenideBase;
import base.enums.*;
import base.page_objects.SelenideDatesPage;
import base.page_objects.SelenideIndexPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureTestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

@Listeners(AllureTestListener.class)
@Feature("Feature - Dates page elements")
public class SelenideDatesPageTest extends SelenideBase {

    private SelenideIndexPage indexPage;
    private SelenideDatesPage datesPage;

    @BeforeMethod
    public void initTest() {
        open(Links.INDEX_PAGE.toString());
        indexPage = page(SelenideIndexPage.class);
        datesPage = page(SelenideDatesPage.class);
    }

    @AfterMethod
    public void closeTest() {
        close();
    }

    @Story("Story - Dates page should have different elements")
    @Test
    public void datedPageSlidersCheck() {
        //1 Open test site by URL
        open(Links.INDEX_PAGE.toString());

        //2 Assert Browser title
        assertEquals(title(), SelenideIndexPage.PAGE_TITLE);

        //3 Perform login
        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.login(Users.PITER_CHAILOVSKII);

        //5 Open through the header menu Service -> Dates Page
        indexPage.openPage("Dates");

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPage.dragAndDropLeftSlider(0);
        datesPage.dragAndDropRightSlider(100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLeftSliderLog(0, 1);
        datesPage.checkRightSliderLog(100, 0);

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPage.dragAndDropLeftSlider(0);
        datesPage.dragAndDropRightSlider(0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLeftSliderLog(0, 1);
        datesPage.checkRightSliderLog(0, 0);

        //10 Using drag-and-drop set Range sliders. left sliders - the most rigtht position, right slider - the most rigth position.
        datesPage.dragAndDropRightSlider(100);
        datesPage.dragAndDropLeftSlider(100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkRightSliderLog(100, 1);
        datesPage.checkLeftSliderLog(100, 0);

        //12 Using drag-and-drop set Range sliders.
        datesPage.dragAndDropLeftSlider(30);
        datesPage.dragAndDropRightSlider(70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLeftSliderLog(30, 1);
        datesPage.checkRightSliderLog(70, 0);
    }
}
