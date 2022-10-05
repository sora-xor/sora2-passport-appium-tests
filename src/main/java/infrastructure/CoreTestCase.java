package infrastructure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Locale;

public class CoreTestCase {

    public static final Faker FAKER = new Faker(new Locale("en-GB"));
    private AppiumDriver driver;

    @BeforeTest
    static void setupAllureReports() {
        Configuration.screenshots = false;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = Platform.getInstance().getDriver();
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterMethod
    public void screenShotOnFail() throws IOException {
        screenshot();
    }

    @AfterClass
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
        if (driver != null) {
            driver.quit();
        }
    }

    @Attachment(type = "img/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }
}