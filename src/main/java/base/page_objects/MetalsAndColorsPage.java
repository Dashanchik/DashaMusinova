package base.page_objects;

import base.DataProviders.MetalsAndColorsTestData;
import base.jdi.forms.MetalsAndColorsForm;
import com.epam.jdi.light.elements.composite.WebPage;

public class MetalsAndColorsPage extends WebPage {
    public static final String PAGE_TITLE = "Metal and Colors";

    private MetalsAndColorsForm metalsAndColorsForm;


    public void fillMetalsAndColorsForm(MetalsAndColorsTestData testData) {
       metalsAndColorsForm.fillMetalsAndColorsForm(testData);
    }

    public void submit() {
        metalsAndColorsForm.submit();
    }

    public void checkResultsLog(String... logRows) {
       metalsAndColorsForm.checkResultsLog(logRows);
    }
}