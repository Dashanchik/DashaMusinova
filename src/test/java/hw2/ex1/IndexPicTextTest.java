package hw2.ex1;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.util.List;

import static org.testng.Assert.assertEquals;

public class IndexPicTextTest extends SeleniumBase {

    @Test(dataProvider = "picTexts", dataProviderClass = DataProviders.class)
    public void indexPicTextTest(int i, String s) {
        //0 Create new WebDriver instance
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2
        List<WebElement> benefitsTexts = driver.findElements(By.cssSelector("[class='row clerafix benefits'] .benefit-txt"));
        String iconText = benefitsTexts.get(i).getText();
        assertEquals(iconText, s);

        //3 Close WebDriver session
        driver.close();
    }
}
