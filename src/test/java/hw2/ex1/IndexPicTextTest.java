package hw2.ex1;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

import static org.testng.Assert.assertEquals;

public class IndexPicTextTest extends SeleniumBase {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod(){
        driver.close();
    }



    @Test(dataProvider = "picTexts",dataProviderClass = DataProviders.class)
    public void indexPicTextTest(int i, String s) {
        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2
        List<WebElement> benefitsTexts = driver.findElements(By.cssSelector("[class='row clerafix benefits'] .benefit-txt"));

        assertEquals(benefitsTexts.get(i).getText(), s);

//        assertEquals(benefitsTexts.get(0).getText(), );
//        assertEquals(benefitsTexts.get(1).getText(), );
//        assertEquals(benefitsTexts.get(2).getText(), "To be multiplatform");
//        assertEquals(benefitsTexts.get(3).getText(), );

    }
}
