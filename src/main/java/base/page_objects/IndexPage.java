package base.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {
    @FindBy(css = "[id='user-icon']")
    private WebElement loginIcon;

    @FindBy(css = "[id='name']")
    private WebElement userField;

    @FindBy(css = "[id='password']")
    private WebElement passwordField;

    @FindBy(css = "[id='login-button']")
    private WebElement submitButton;

    private WebDriver driver;

    public IndexPage(WebDriver driver){
        this.driver = driver;

    }

    public void login(String name, String password) {
        loginIcon.click();
        userField.sendKeys(name);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public void open() {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }
}