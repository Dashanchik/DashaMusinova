package base.jdi.lesson1.pages;

import base.enums.Users;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.common.TextField;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class IndexPageJdi extends WebPage {
    public static final String PAGE_TITLE = "Home Page";

    @FindBy(id = "user-icon")
    private Icon loginIcon;

    @FindBy(css = "[id='name']")
    private TextField loginField;

    @FindBy(css = "[id='password']")
    private TextField passwordField;

    @FindBy(css = "[id='login-button']")
    private Button submitButton;

    @FindBy(css = "[id='user-name']")
    private UIElement userName;


    public void login(Users user) {
        loginIcon.click();
        loginField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
        assertEquals(user.name, userName.getText());
    }
}