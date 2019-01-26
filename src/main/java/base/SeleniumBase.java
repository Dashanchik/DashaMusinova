package base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public abstract class SeleniumBase {

    @BeforeSuite

    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
    }
}
