package base.lesson6.entities.PO;

import base.lesson6.entities.SuperHero;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.page;

public class SelenideUserTablePage {
    @FindBy(css = "#user-table tr")
    private ElementsCollection table;

    public SelenideUserTablePage() {
        page(this);
    }

    public void checkSuperheroes(List<SuperHero> superhero) {
        List<SuperHero> superHeroes = getSuperHeroes();
        Assert.assertEquals(superHeroes, superhero);
    }

    private List<SuperHero> getSuperHeroes() {
        return table.stream().skip(1).map(e -> new SuperHero(Integer.parseInt(e.$("td", 0).text()),
                e.$("td a").text(),
                e.$("td span").text().replaceAll("\n", " ")))
                .collect(Collectors.toList());
    }
}