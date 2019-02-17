package hw6;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.close;

@CucumberOptions(
        features = "classpath:hw6",
        glue = "classpath:hw6.steps",
        tags = "@HomePageTest"
)

public class RunServisePageCucumberTests extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void driverSetup() {
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
    }

    @AfterClass
    public void finish() {
        close();
    }
}
