package jdi.hw7;

import base.DataProviders.MetalsAndColorsDataProvider;
import base.DataProviders.MetalsAndColorsTestData;
import base.jdi.JdiSite;
import com.epam.jdi.light.driver.get.DriverData;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.*;

import static base.jdi.entities.User.PETER_CHAILOVSKII;
import static com.epam.jdi.light.driver.WebDriverFactory.close;

public class JdiSimpleExample {

    @BeforeTest(alwaysRun = true)
    public void beforeSuite() {
        DriverData.DRIVER_VERSION = "2.46";
        PageFactory.initElements(JdiSite.class);
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        close();
    }

    @Test(dataProvider = "MetalsAndColorsData", dataProviderClass = MetalsAndColorsDataProvider.class)
    public void simpleJdiTest(MetalsAndColorsTestData testData) {
        //1 Login on JDI site as User
        JdiSite.indexPageJdi.open();
        JdiSite.indexPageJdi.login(PETER_CHAILOVSKII);

        //2 Open Metals & Colors page by Header menu
        JdiSite.indexPageJdi.goToPageFromHeaderMenu("Metals & Colors");

        //3 Fill form Metals & Colors by data
        JdiSite.metalsAndColorsPage.fillMetalsAndColorsForm(testData);
        //4 Submit form Metals & Colors
        JdiSite.metalsAndColorsPage.submit();

        //5 Result section should contain data
        JdiSite.metalsAndColorsPage.checkResultsLog(
                "Summary: " + (testData.getSummary()[0] + testData.getSummary()[1]),
                "Elements: " + String.join(", ", testData.getElements()),
                "Color: " + testData.getColor(),
                "Metal: " + testData.getMetal(),
                "Vegetables: " + String.join(", ", testData.getVegetables()));

        //6 Logout
        JdiSite.indexPageJdi.logOut();
    }
}