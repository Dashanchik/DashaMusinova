package base.jdi.forms;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.complex.Menu;

public class Header extends Section {

    @XPath("//ul[@class='uui-navigation nav navbar-nav m-l8'] //a[text()='%s']")
    private Menu navigationMenu;

    public void clickMenuItem(String menuItemName) {
        navigationMenu.select(menuItemName);
    }
}
