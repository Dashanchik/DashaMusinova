package listeners;


import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AllureTestListener extends TestListenerAdapter {


    @Attachment(value = "Attachment: {0}", type = "image/png")
    public byte[] makeScreenshot(){

        byte[] array = {1};
        try {
            return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return array;
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        makeScreenshot();
    }
}