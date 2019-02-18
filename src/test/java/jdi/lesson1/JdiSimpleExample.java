package jdi.lesson1;

import base.jdi.lesson1.JdiSite;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static base.enums.Users.PITER_CHAILOVSKII;

public class JdiSimpleExample {

//    IndexPageJdi indexPageJdi;
//    WebDriver driver;
    @BeforeSuite
    public void beforeSuite(){
//        setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.navigate().to(Links.INDEX_PAGE.toString());
//        indexPageJdi = PageFactory.initElements(driver, IndexPageJdi.class);
        PageFactory.initElements(JdiSite.class);
    }

    @AfterSuite
    public void afterTest(){
//        driver.close();
    }

    @Test
    public void simpleJdiTest(){
        JdiSite.indexPageJdi.open();
        JdiSite.indexPageJdi.login(PITER_CHAILOVSKII);
    }
}
