package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;          // TODO please don't place unused imports
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public abstract class SeleniumBase {

    @BeforeSuite(alwaysRun = true)
                                    // TODO is this empty line required here?
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
    }

    @AfterSuite
    public void afterSuite(){
        // TODO What is purpose of setting current property?
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

}
