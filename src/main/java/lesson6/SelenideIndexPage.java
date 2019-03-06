package lesson6;

import base.SelenideBase;
import base.enums.BenefitIconsText;
import base.enums.ServiceMenuItems;
import base.enums.Users;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.page;
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

    public String getUserName() {
        return userName.getText();
    }

    public void login(Users user) {
        loginIcon.click();
        loginField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
        assertEquals(user.name, userName.getText());
    }

    public void login(String username, String password) {
        loginIcon.click();
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
        assertEquals(getUserName(), userName.getText());
    }

    public void checkBenefitIcons() {
        assertEquals(benefitIcons.size(), 4);
        for (WebElement element : benefitIcons) {
            assertTrue(element.isDisplayed());
        }
    }

    public void checkBenefitIconsText(List<String> textUnderPictures) {
        for (int index=0;index<textUnderPictures.size();index++){
            assertEquals(benefitIconsText.get(index).getText(), BenefitIconsText.values()[index].toString());
        }
    }

    public SelenideElement getHeaderMenuItemByName(String menuItemName) {
        for (SelenideElement headerMenuItem : headerMenuItems) {
            if (headerMenuItem.getText().toUpperCase().contains(menuItemName.toUpperCase())) {
                return headerMenuItem;
            }
        }
        throw new IllegalArgumentException("Wrong menu item name");
    }

    private SelenideElement getServicesDropdownHeaderMenuItemByName(String itemName){
        List<SelenideElement> servicesDropdownHeaderMenuItems = servicesDropdownHeaderMenuList.findAll(By.cssSelector("ul>li>a"));
        for (SelenideElement servicesDropdownHeaderMenuItem1 : servicesDropdownHeaderMenuItems) {
            if (servicesDropdownHeaderMenuItem1.getAttribute("innerHTML").trim().toUpperCase().equals(itemName.toUpperCase())) {
                return servicesDropdownHeaderMenuItem1;
            }
        }
        throw new IllegalArgumentException("Wrong Services dropdown menu item name");
    }

    public void checkServicesDropdownMenuInHeader() {
        SelenideElement servicesDropdownHeaderMenu = headerMenuItems.get(2);
        Collection<SelenideElement> servicesHeaderElements;
        Collection<String> serviceHeaderElementsTexts;
        List<String> serviceMenuItems;
        servicesDropdownHeaderMenu.click();
        servicesHeaderElements = servicesDropdownHeaderMenu.findAll(By.cssSelector("ul>li"));
        serviceHeaderElementsTexts = servicesHeaderElements.stream().map(SelenideElement::getText).collect(Collectors.toList());
        serviceMenuItems = Arrays.stream(ServiceMenuItems.values()).map(ServiceMenuItems::toString).collect(Collectors.toList());
        assertTrue(serviceHeaderElementsTexts.containsAll(serviceMenuItems));
    }

    public void checkServicesDropdownMenuInSidebar() {
        SelenideElement servicesDropdownSidebarMenu = sidebarMenu.find(By.cssSelector("[index='3']"));
        Collection<SelenideElement> servicesSidebarElements;
        Collection<String> servicesSidebarElementsTexts;
        List<String> serviceMenuItems;
        servicesDropdownSidebarMenu.click();
        servicesSidebarElements = servicesDropdownSidebarMenu.findAll(By.cssSelector("ul>li"));
        servicesSidebarElementsTexts = servicesSidebarElements.stream().map(element -> element.getText().toUpperCase()).collect(Collectors.toList());
        serviceMenuItems = Arrays.stream(ServiceMenuItems.values()).map(ServiceMenuItems::toString).collect(Collectors.toList());
        assertTrue(servicesSidebarElementsTexts.containsAll(serviceMenuItems));
    }

    public void openPageFromServicesMenuItemDropdown(String pageName) {
        getServicesDropdownHeaderMenuItemByName(pageName).click();
    }

}