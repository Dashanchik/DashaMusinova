package base.page_objects;

import base.enums.CheckboxesLabels;
import base.enums.RadioControls;
import base.jdi.forms.MetalsAndColorsForm;
import com.epam.jdi.light.elements.composite.WebPage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class MetalsAndColorsPage extends WebPage {
    public static final String PAGE_TITLE = "Metal and Colors";

    private MetalsAndColorsForm metalsAndColorsForm;

    public void chooseSummary(int selectRadio) {
        metalsAndColorsForm.summaryBlock.select(Integer.toString(selectRadio));
    }

    public void chooseElement(String... labels) {
        List<CheckboxesLabels> checkboxesLabels = Arrays.stream(labels).map(CheckboxesLabels::getCheckboxByTheName).collect(Collectors.toList());
        for (int index = 0; index < metalsAndColorsForm.elementsChecklist.size(); index++) {
            for (CheckboxesLabels label : checkboxesLabels) {
                if (metalsAndColorsForm.elementsChecklist.get(index).getText().contains(label.toString())) {
                    metalsAndColorsForm.elementsChecklist.get(index).click();
                }
            }
        }
    }

    public void submit() {
        metalsAndColorsForm.submit.click();
    }

    public void chooseColor(String... colors) {
        for (String color : colors) {
            metalsAndColorsForm.colorsBlock.select(color);
        }
    }

    public void chooseMetal(String metalName) {
        metalsAndColorsForm.metalsBlock.select(RadioControls.getRadioControlByTheName(metalName));
    }

    public void chooseVegetable(String... vars) {
        String selected = metalsAndColorsForm.vegetablesBlock.getSelected();
        Arrays.stream(selected.split(", ")).forEach(e -> metalsAndColorsForm.vegetablesBlock.select(e));
        for (String var : vars) {
            metalsAndColorsForm.vegetablesBlock.select(var);
        }
    }

    public void checkResults(String... row) {
        for (int i = 0; i < row.length; i++) {
            assertEquals(metalsAndColorsForm.resultsBlock.get(i).getText(), row[i]);
        }
    }
}