package lesson1;

import base.SeleniumBase;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class SimpleTest extends SeleniumBase {


    @Test
    public void simpleTest() {
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 1000;

        //1
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        String handle = driver.getWindowHandle();
//        driver.switchTo().window(handle);
        //2
        open("https://epam.github.io/JDI/index.html");
        //3
        assertEquals(getWebDriver().getTitle(), "Home Page");
        //4
        $("[id='user-icon']").click();
        $("[id='name']").sendKeys("epam");
        $("[id='password']").sendKeys("1234");
        $("[id='login-button']").click();

        $("#user-name").shouldHave(text("Piter Chailovskii"));

//        driver.findElement(By.cssSelector("[id='user-icon']")).click();
//        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
//        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
//        driver.findElement(By.cssSelector("[id='login-button']")).click();
        //5
        close();
    }
}
