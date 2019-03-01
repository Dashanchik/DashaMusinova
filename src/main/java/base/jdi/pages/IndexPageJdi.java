package base.jdi.pages;

import base.jdi.entities.User;
import base.jdi.forms.Header;
import base.jdi.forms.LoginForm;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Icon;
import org.openqa.selenium.support.FindBy;

import static base.jdi.forms.LoginForm.logout;
import static org.hamcrest.MatcherAssert.assertThat;

public class IndexPageJdi extends WebPage {
    public static final String PAGE_TITLE = "Home Page";

    private LoginForm loginForm;
    private Header headerMenu;

    @FindBy(id = "user-icon")
    private Icon loginIcon;

    @FindBy(css = "[id='user-name']")
    private UIElement userName;

    public void login(User user) {
        loginIcon.click();
        loginForm.login(user);
    }

    public void goToPageFromHeaderMenu(String pageName) {
        headerMenu.clickMenuItem(pageName);
        assertThat("Validate page title is Metal and Colors", getTitle().equalsIgnoreCase("Metal and Colors"));
    }

    public void logOut() {
        loginIcon.click();
        logout.click();
    }
}