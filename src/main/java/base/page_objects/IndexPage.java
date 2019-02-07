package base.page_objects;

import base.enums.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {

    public static final String PAGE_TITLE = "Home Page";

    @FindBy(id = "user-icon")
    private WebElement loginIcon;

    @FindBy(css = "[id='name']")
    private WebElement loginField;

    @FindBy(css = "[id='password']")
    private WebElement passwordField;

    @FindBy(css = "[id='login-button']")
    private WebElement submitButton;

    @FindBy(css = "[id='user-name']")
    private WebElement userName;

    @FindBy(css = "[class='uui-navigation nav navbar-nav m-l8']>li")
    private List<WebElement> navBarItems;

    @FindBy(css = "[class^='icons-benefit']")
    private List<WebElement> benefitIcons;

    @FindBy(css = "[class='row clerafix benefits'] .benefit-txt")
    private List<WebElement> benefitIconsText;

    @FindBy(name = "main-title")
    private WebElement mainHeader;

    @FindBy(name = "jdi-text")
    private WebElement textUnderHeader;

    @FindBy(css = "[src='https://epam.github.io/JDI/index.html']")
    private WebElement iFrame;

    // TODO Why you decide use '@FindBy(id = "epam_logo")' here? - xpath used instead, fixed
    @FindBy(xpath = "//*[@id='epam_logo']")
    private WebElement epamLogo;

    @FindBy(css = "[class='text-center']>a")
    private WebElement subHeader;

    @FindBy(name = "navigation-sidebar")
    private WebElement leftSection;

    @FindBy(css = "[class^='footer']")
    private WebElement footer;

    private WebDriver driver;
    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(Users user) {
        loginIcon.click();
        loginField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
        assertEquals(user.name, userName.getText());
    }

    public void open(Links url) {
        driver.navigate().to(url.value);
    }

    public void checkPageTitle(String pageTitle) {
        assertEquals(driver.getTitle(), pageTitle);
    }

    public void checkNavigationBarItems() {
        assertEquals(navBarItems.size(), 4);
        for (WebElement element : navBarItems) {
            assertTrue(element.isDisplayed());
        }
        assertEquals(navBarItems.get(0).getText(), NavBarMenuItems.HOME.toString());
        assertEquals(navBarItems.get(1).getText(), NavBarMenuItems.CONTACT.toString());
        assertEquals(navBarItems.get(2).getText(), NavBarMenuItems.SERVICE.toString());
        assertEquals(navBarItems.get(3).getText(), NavBarMenuItems.METALS_COLORS.toString());

    }

    public void checkBenefitIcons() {
        assertEquals(benefitIcons.size(), 4);
        for(WebElement element : benefitIcons) {
            assertTrue(element.isDisplayed());
        }
    }

    public void checkBenefitIconsText() {
        assertEquals(benefitIconsText.get(0).getText(), BenefitIconsText.PRACTICE.toString());
        assertEquals(benefitIconsText.get(1).getText(), BenefitIconsText.CUSTOM.toString());
        assertEquals(benefitIconsText.get(2).getText(), BenefitIconsText.MULTI.toString());
        assertEquals(benefitIconsText.get(3).getText(), BenefitIconsText.BASE.toString());
    }

    public void checkMainHeaderText() {
        assertEquals(mainHeader.getText(), Headers.MAIN_HEADER.toString());
    }

    public void checkTextUnderHeader() {
        assertEquals(textUnderHeader.getText(), Headers.TEXT_UNDER_HEADER.toString());
    }

    public void checkIFrameLogo() {
        assertTrue(iFrame.isDisplayed());
        driver.switchTo().frame(iFrame);
        assertTrue(epamLogo.isDisplayed());
        driver.switchTo().defaultContent();
    }

    public void checkSubHeaderText() {
        assertEquals(subHeader.getText(), Headers.SUB_HEADER.toString());
    }

    public void checkSubHeaderLinkURL() {
        assertEquals(subHeader.getAttribute("href"), Links.JDI_GITHUB.toString());
    }

    public void leftMenuBar() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkFooter() {
        assertTrue(footer.isDisplayed());

    }
}