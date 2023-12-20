package listener;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;

import static io.qameta.allure.Allure.addAttachment;

public class ScreenShotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        if (WebDriverRunner.hasWebDriverStarted()) {
            try {
                File screenshotAs = ((TakesScreenshot) WebDriverRunner.getWebDriver())
                        .getScreenshotAs(OutputType.FILE);
                addAttachment("Screenshot", FileUtils.openInputStream(screenshotAs));
            } catch (IOException | NoSuchSessionException e) {
                // NO OP
            } finally {
                WebDriverRunner.getWebDriver().quit();
            }
        }
    }
}
