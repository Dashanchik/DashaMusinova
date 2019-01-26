package lesson2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SimpleTestWithDataProvider {

    @DataProvider
    private Object[][] simpleDataProvider(){
        return new Object[][] {
                {0,"Ivan"},
                {1, "Roman"},
                {2, "Dima"}
        };
    }
    private WebDriver driver;


      @Test(dataProvider = "simpleDataProvider")
    public void simpleTest(int i, String s) {

          System.out.println("int = " + i + "\n" + "String = " + s);
    }
}
