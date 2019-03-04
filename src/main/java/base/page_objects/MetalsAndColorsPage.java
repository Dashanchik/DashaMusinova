package base.page_objects;

import base.jdi.entities.MetalsAndColors;
import base.jdi.forms.MetalsAndColorsForm;
import com.epam.jdi.light.elements.composite.WebPage;

public class MetalsAndColorsPage extends WebPage {
    public static final String PAGE_TITLE = "Metal and Colors";

    public MetalsAndColorsForm metalsAndColorsForm;


    public void fillMetalsAndColorsForm(MetalsAndColors metalsAndColors) {
       metalsAndColorsForm.fillMetalsAndColorsForm(metalsAndColors);
    }

    public void submit() {
        metalsAndColorsForm.submit();
    }

    public void checkResultsLog(String... logRows) {
       metalsAndColorsForm.checkResultsLog(logRows);
    }
}