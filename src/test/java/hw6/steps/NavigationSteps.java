package hw6.steps;

// TODO Delete unused imports - fixed

import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Given;

public class NavigationSteps {
    private static final String INDEX_PAGE_URL = "https://epam.github.io/JDI/index.html";

    @Given("^I open EPAM JDI page$")
    public void iOpenEpamJDIPage() {
        Selenide.open(INDEX_PAGE_URL);
    }
}
