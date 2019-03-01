package base.jdi.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.*;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MetalsAndColorsForm extends Form {

    @FindBy(css = "[id='summary-block']")
    public RadioButtons summaryBlock;

    @FindBy(css = "p[class='checkbox'] label")
    public List<WebElement> elementsChecklist;

    @JDropdown(root = "div[ui=dropdown]", value = ".filter-option", list = "li", expand = ".caret")
    public Droplist colorsBlock;

    //    @FindBy(css = "[class='form-group metals']")
    @UI("[class='form-group metals']>input")
    public DataList metalsBlock;

    @JDropdown(root = "div[ui=droplist]", value = ".dropdown-toggle", list = "li", expand = ".caret")
    public Droplist vegetablesBlock;

    @ByText("Submit")
    public Button submit;

    @Css("[class$='info-panel-body-result'] li")
    public List<WebElement> resultsBlock;
}