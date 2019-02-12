package base.page_objects;

import base.DataProviders.ServicesData;
import base.SelenideBase;
import base.enums.*;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SelenideIndexPage extends SelenideBase {

    public static final String PAGE_TITLE = "Home Page";

    @FindBy(id = "user-icon")
    private SelenideElement loginIcon;

    @FindBy(css = "[id='name']")
    private SelenideElement loginField;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordField;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    public SelenideElement getUserName() {
        return userName;
    }

    @FindBy(css = "[id='user-name']")
    private SelenideElement userName;

    @FindBy(css = "[class='uui-navigation nav navbar-nav m-l8']>li")
    private List<SelenideElement> headerMenuItems;

    @FindBy(css = "[class='dropdown']")
    private SelenideElement servicesDropdownHeaderMenuItem;

    @FindBy(css = "[class='dropdown-menu")
    private SelenideElement servicesDropdownHeaderMenuList;

    @FindBy(css = "[class^='icons-benefit']")
    private List<SelenideElement> benefitIcons;

    @FindBy(css = "[class='row clerafix benefits'] .benefit-txt")
    private List<SelenideElement> benefitIconsText;

    @FindBy(name = "main-title")
    private SelenideElement mainHeader;

    @FindBy(name = "jdi-text")
    private SelenideElement textUnderHeader;

    @FindBy(css = "[src='https://epam.github.io/JDI/index.html']")
    private SelenideElement iFrame;

    @FindBy(xpath = "//*[@id='epam_logo']")
    private SelenideElement epamLogo;

    @FindBy(css = "[class='text-center']>a")
    private SelenideElement subHeader;

    @FindBy(name = "navigation-sidebar")
    private SelenideElement sidebarMenu;

    @FindBy(css = "[class^='footer']")
    private SelenideElement footer;

    public SelenideIndexPage() {
        page(this);
    }

    public void login(Users user) {
        loginIcon.click();
        loginField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
        assertEquals(user.name, userName.getText());
    }

    public void checkPageTitle(String pageTitle) {
        $("title").shouldHave(text(pageTitle));
    }

    public void checkNavigationBarItems() {
        assertEquals(headerMenuItems.size(), 4);
        for (SelenideElement element : headerMenuItems) {
            assertTrue(element.isDisplayed());
        }
        assertEquals(headerMenuItems.get(0).getText(), NavBarMenuItems.HOME.toString());
        assertEquals(headerMenuItems.get(1).getText(), NavBarMenuItems.CONTACT.toString());
        assertEquals(headerMenuItems.get(2).getText(), NavBarMenuItems.SERVICE.toString());
        assertEquals(headerMenuItems.get(3).getText(), NavBarMenuItems.METALS_COLORS.toString());

    }

    public void checkBenefitIcons() {
        assertEquals(benefitIcons.size(), 4);
        for (SelenideElement element : benefitIcons) {
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
        switchTo().frame(iFrame);
        assertTrue(epamLogo.isDisplayed());
        switchTo().defaultContent();
    }

    public void checkSubHeaderText() {
        assertEquals(subHeader.getText(), Headers.SUB_HEADER.toString());
    }

    public void checkSubHeaderLinkURL() {
        assertEquals(subHeader.getAttribute("href"), Links.JDI_GITHUB.toString());
    }

    public void checkLeftMenuBarIsDisplayed() {
        assertTrue(sidebarMenu.isDisplayed());
    }

    public void checkFooter() {
        assertTrue(footer.isDisplayed());
    }

    // TODO This method should be parametrized
    public void checkServicesDropdownMenuInHeader() {
        SelenideElement servicesDropdownHeaderMenu = headerMenuItems.get(2);
        servicesDropdownHeaderMenu.click();
        Collection<SelenideElement> servicesHeaderElements = servicesDropdownHeaderMenu.findAll(By.cssSelector("ul>li"));
        // TODO Please look to the IDEA warning
        Collection<String> serviceHeaderElementsTexts = servicesHeaderElements.stream().map(element -> element.getText()).collect(Collectors.toList());
        assertTrue(serviceHeaderElementsTexts.containsAll(Arrays.asList(ServicesData.servicesMenuItems())));
    }

    // TODO This method should be parametrized
    public void checkServicesDropdownMenuInSidebar() {
        SelenideElement servicesDropdownSidebarMenu = sidebarMenu.find(By.cssSelector("[index='3']"));
        servicesDropdownSidebarMenu.click();
        Collection<SelenideElement> servicesSidebarElements = servicesDropdownSidebarMenu.findAll(By.cssSelector("ul>li"));
        Collection<String> servicesSidebarElementsTexts = servicesSidebarElements.stream().map(element -> element.getText().toUpperCase()).collect(Collectors.toList());
        assertTrue(servicesSidebarElementsTexts.containsAll(Arrays.asList(ServicesData.servicesMenuItems())));
    }

    // TODO This method should be parametrized
    public void openDifferentElementsPage() {
        servicesDropdownHeaderMenuItem.click();
        servicesDropdownHeaderMenuList.find(byText("Different elements")).click();
    }

    // TODO This method should be parametrized
    public void openDatesPage() {
        servicesDropdownHeaderMenuItem.click();
        servicesDropdownHeaderMenuList.find(byText("Dates")).click();
    }
}