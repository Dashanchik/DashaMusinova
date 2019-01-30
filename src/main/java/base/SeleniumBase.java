package base;

import org.testng.annotations.AfterSuite; // TODO please don't place unused imports - import deleted, fixed
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public abstract class SeleniumBase {

    @BeforeSuite(alwaysRun = true) // TODO is this empty line required here? - line deleted, fixed
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
    }

    @AfterSuite
    public void afterSuite(){
        // TODO What is purpose of setting current property? - to set the property to it's default value and to use the @AfterSuite in the exercise3 hw2
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

}
