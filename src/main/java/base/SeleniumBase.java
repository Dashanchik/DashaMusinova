package base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public class SeleniumBase {

    @BeforeSuite

    public void beforeSuite() {
        //setProperty("webdriber", 'khkhk');
    }
}
