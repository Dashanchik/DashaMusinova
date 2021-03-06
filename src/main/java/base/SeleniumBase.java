package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public abstract class SeleniumBase {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
    }

    @AfterSuite
    public void afterSuite(){
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

}
