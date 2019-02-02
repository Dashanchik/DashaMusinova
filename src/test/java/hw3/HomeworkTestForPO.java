package hw3;

import base.SeleniumBase;
import base.enums.Headers;
import base.enums.Links;
import base.enums.Users;
import base.page_objects.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeworkTestForPO extends SeleniumBase {

    private WebDriver driver;
    public IndexPage indexPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void hardAssertEpamGithubTest() {
        //1 Open test site by URL
        indexPage.open(Links.INDEX_PAGE);

        //2 Assert Browser title
        indexPage.checkPageTitle(Headers.PAGE_TITLE);

        //3 Perform login and Assert User name in the left-top side of screen that user is loggined
        indexPage.login(Users.PITER);

        //4 Assert that there are 4 items on the header section displayed and they have proper texts
        indexPage.checkNavigationBarItems();

        //5 Assert that there are 4 images on the Index Page and they are displayed
        indexPage.checkBenefitIcons();

        //6 Assert that there are 4 texts on the Index Page under icons and they have proper text
        indexPage.checkBenefitIconsText();

        //7 Assert a text of the main headers
        indexPage.checkMainHeader();
        indexPage.checkMainHeaderText();

        //8 Assert that there is the iframe in the center of page, switch to the iframe and check that there is Epam logo in the left top conner of iframe and switch back to original window
        indexPage.checkIFrameLogo();

        //9 Assert a text of the sub header is correct
        indexPage.checkSubHeader();

        //10 Assert that JDI GITHUB is a link and has a proper URL
        indexPage.checkSubHeaderLink();

        //11 Assert that there is Left Section
        indexPage.checkLeftSection();

        //12 Assert that there is Footer
        indexPage.checkFooter();
    }
}