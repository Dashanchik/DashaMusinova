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

    @Test(dataProvider = "benefitIconsText", dataProviderClass = DataProviders.class)
    /* TODO - fixed
        1. what does i parameter mean? changed for iconIndex
        2. what does s parameter mean? changed for iconText
        This is not convenient parameter name
     */
    public void benefitIconsTextTest(int iconIndex, String iconText) {
        //0 Create new WebDriver instance
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2
        List<WebElement> benefitsTexts = driver.findElements(By.cssSelector("[class='row clerafix benefits'] .benefit-txt"));
        assertEquals(benefitsTexts.get(iconIndex).getText(), iconText);

        //3 Close WebDriver session
        driver.close();
    }
}
