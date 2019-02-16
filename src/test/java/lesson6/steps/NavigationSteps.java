package lesson6.steps;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Given;

public class NavigationSteps {
    private static final String INDEX_PAGE_URL = "https://epam.github.io/JDI/index.html";

    @Given("^I open EPAM JDI site$")
    public void iOpenEpamJDIPage(){
        Selenide.open(INDEX_PAGE_URL);
}
}
