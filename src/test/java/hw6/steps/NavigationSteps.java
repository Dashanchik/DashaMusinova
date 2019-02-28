package hw6.steps;

// TODO Delete unused imports
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.Given;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class NavigationSteps {
    private static final String INDEX_PAGE_URL = "https://epam.github.io/JDI/index.html";

    @Given("^I open EPAM JDI page$")
    public void iOpenEpamJDIPage() {
        Selenide.open(INDEX_PAGE_URL);
    }




}
