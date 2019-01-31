package hw2.ex3;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// TODO Check comments for the HW1 - fixed
public class AllNotationsTest extends SeleniumBase {

    private WebDriver driver;
    // TODO should be 1 empty line - fixed

    @BeforeClass
    // TODO I recommend think about creation driver for the class instance in BeforeClass - fixed
    public void beforeClass() {
        System.out.println(System.currentTimeMillis());
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @AfterClass
    // TODO I recommend think about close driver for the class instance in AfterClass - fixed
    public void afterClass() {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void hardAssertEpamGithubTest() {
        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector(("[id='password']"))).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button'")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.cssSelector("[id='user-name']")).getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section displayed and they have proper texts
        List<WebElement> navBar = driver.findElements(By.cssSelector("[class='uui-navigation nav navbar-nav m-l8']>li"));
        assertEquals(navBar.size(), 4);
        assertEquals(navBar.get(0).getText(), "HOME");
        assertEquals(navBar.get(1).getText(), "CONTACT FORM");
        assertEquals(navBar.get(2).getText(), "SERVICE");
        assertEquals(navBar.get(3).getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitsIcons = driver.findElements(By.cssSelector("[class='row clerafix benefits'] [class^='icons']"));
        assertEquals(benefitsIcons.size(), 4);
        for (WebElement element : benefitsIcons) {
            assertTrue(element.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitsTexts = driver.findElements(By.cssSelector("[class='row clerafix benefits'] .benefit-txt"));
        assertEquals(benefitsTexts.size(), 4);
        assertEquals(benefitsTexts.get(0).getText(), "To include good practices\nand ideas from successful\nEPAM project");
        assertEquals(benefitsTexts.get(1).getText(), "To be flexible and\ncustomizable");
        assertEquals(benefitsTexts.get(2).getText(), "To be multiplatform");
        assertEquals(benefitsTexts.get(3).getText(), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        //9 Assert a text of the main headers
        assertEquals(driver.findElement(By.name("main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.name("jdi-text")).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.cssSelector("[src='https://epam.github.io/JDI/index.html']")).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.cssSelector("[class='epam-logo'] img")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        assertEquals(driver.findElement(By.cssSelector("[class='text-center']")).getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        String jdiLink = driver.findElement(By.linkText("JDI GITHUB")).getAttribute("href");
        assertEquals(jdiLink, "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        assertTrue(driver.findElement(By.name("navigation-sidebar")).isDisplayed());

        //16 Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector("[class^='footer'")).isDisplayed());

    }

}