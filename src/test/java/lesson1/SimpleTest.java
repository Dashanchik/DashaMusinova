package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class SimpleTest {


    @Test
    public void simpleTest() {
        //1
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String handle = driver.getWindowHandle();
        driver.switchTo().window(handle);
        //2
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        //3
        assertEquals(driver.getTitle(), "Home Page");
        //4
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();
        //5
        driver.close();
    }
}
