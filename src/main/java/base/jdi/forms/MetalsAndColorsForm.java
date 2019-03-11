package base.jdi.forms;

import base.DataProviders.MetalsAndColorsTestData;
import base.enums.CheckboxesLabels;
import base.enums.RadioControls;
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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class MetalsAndColorsForm extends Form<MetalsAndColorsTestData> {

    @FindBy(css = "[id='summary-block']")
    private RadioButtons summary;

    @FindBy(css = "p[class='checkbox'] label")
    public List<WebElement> elements;

    @JDropdown(root = "div[ui=dropdown]", value = ".filter-option", list = "li", expand = ".caret")
    public Droplist colors;

    @UI("[class='form-group metals']>input")
    public DataList metal;

    @JDropdown(root = "div[ui=droplist]", value = ".dropdown-toggle", list = "li", expand = ".caret")
    private Droplist vegetables;

    @ByText("Submit")
    public Button submit;

    @Css("[class$='info-panel-body-result'] li")
    private List<WebElement> resultsBlock;

    public void fillMetalsAndColorsForm(MetalsAndColorsTestData testData) {
        List<CheckboxesLabels> checkboxesLabels = Arrays.stream(testData.getElements())
                .map(CheckboxesLabels::getCheckboxByTheName)
                .collect(Collectors.toList());
        for (WebElement element : elements) {
            for (CheckboxesLabels label : checkboxesLabels) {
                if (element.getText().contains(label.toString())) {
                    element.click();
                }
            }
        }
        this.colors.select(testData.getColor());
        metal.select(RadioControls.getRadioControlByTheName(testData.getMetal()));
        String selected = this.vegetables.getSelected();
        Arrays.stream(selected.split(", ")).forEach(e -> this.vegetables.select(e));
        for (String var : testData.getVegetables()) {
            this.vegetables.select(var);
        }
        for (int radio : testData.getSummary()) {
            summary.select(Integer.toString(radio));
        }
    }

    public void checkResultsLog(String[] logRows) {
        for (int i = 0; i < logRows.length; i++) {
            assertEquals(resultsBlock.get(i).getText(), logRows[i]);
        }
    }

    public void submit() {
        submit.click();
    }
}