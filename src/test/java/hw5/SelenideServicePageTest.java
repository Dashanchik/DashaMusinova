//package hw5;
//
//import base.SelenideBase;
//import base.enums.*;
//import base.page_objects.SelenideDifferentElementsPage;
//import base.page_objects.SelenideIndexPage;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import static com.codeborne.selenide.Selenide.*;
//import static org.testng.Assert.*;
//
//public class SelenideServicePageTest extends SelenideBase {
//
//    private SelenideIndexPage indexPage;
//    private SelenideDifferentElementsPage differentElementsPage;
//
//    @BeforeMethod
//    public void initTest() {
//        open(Links.INDEX_PAGE.toString());
//        indexPage = page(SelenideIndexPage.class);
//        differentElementsPage = page(SelenideDifferentElementsPage.class);
//    }
//
//    @AfterMethod
//    public void closeTest() {
//        close();
//    }
//
//    @Test
//    public void servicePageInterfaceCheck() {
//        //1 Open test site by URL
//        open(Links.INDEX_PAGE.toString());
//
//        //2 Assert Browser title
//        assertEquals(title(), SelenideIndexPage.PAGE_TITLE);
//
//        //3 Perform login
//        //4 Assert User name in the left-top side of screen that user is loggined
//        indexPage.login(Users.PITER_CHAILOVSKII);
//
//        //5 Click on "Service" subcategory in the header and check that drop down contains options
//        indexPage.checkServicesDropdownMenuInHeader(ServiceMenuItems.values());
//
//        //6 Click on Service subcategory in the left section and check that drop down contains options
//        indexPage.checkServicesDropdownMenuInSidebar(ServiceMenuItems.values());
//
//        //7 Open through the header menu Service -> Different Elements Page
//        indexPage.openPage("Different elements");
//
//        //8 Check interface on Different elements page, it contains all needed elements
//        differentElementsPage.checkDifferentElementsPageGUI();
//
//        //9 Assert that there is Right Section
//        differentElementsPage.assertRightSectionDisplayed();
//
//        //10 Assert that there is Left Section
//        differentElementsPage.assertLeftSectionDisplayed();
//
//        //11 Select checkboxes Water and Wind
//        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
//        differentElementsPage.checkCheckboxesEnabledActionLog(CheckboxesLabels.EARTH);
//        differentElementsPage.checkCheckboxesEnabledActionLog(CheckboxesLabels.WATER);
//        differentElementsPage.checkCheckboxesEnabledActionLog(CheckboxesLabels.FIRE);
//        differentElementsPage.checkCheckboxesEnabledActionLog(CheckboxesLabels.WIND);
//
//        //13 Select radio Selen
//        differentElementsPage.selectRadio(RadioControls.SELEN);
//
//        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
//        differentElementsPage.checkRadioControlsActionLog(RadioControls.GOLD);
//        differentElementsPage.checkRadioControlsActionLog(RadioControls.SILVER);
//        differentElementsPage.checkRadioControlsActionLog(RadioControls.BRONZE);
//        differentElementsPage.checkRadioControlsActionLog(RadioControls.SELEN);
//
//        //15 Select in dropdown Yellow
//        differentElementsPage.selectDropdownItem(DropDownValues.YELLOW);
//
//        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value.
//        differentElementsPage.checkDropdownActionLog(DropDownValues.RED);
//        differentElementsPage.checkDropdownActionLog(DropDownValues.BLUE);
//        differentElementsPage.checkDropdownActionLog(DropDownValues.GREEN);
//        differentElementsPage.checkDropdownActionLog(DropDownValues.YELLOW);
//
//        //17 Unselect and assert checkboxes
//        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
//        differentElementsPage.checkCheckboxesDisabledActionLog(CheckboxesLabels.WATER);
//        differentElementsPage.checkCheckboxesDisabledActionLog(CheckboxesLabels.WIND);
//        differentElementsPage.assertCheckboxDisabled(CheckboxesLabels.WATER);
//        differentElementsPage.assertCheckboxDisabled(CheckboxesLabels.WIND);
//
//        //19 assertion fail
//        fail();
//    }
//}
