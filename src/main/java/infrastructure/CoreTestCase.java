package infrastructure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Locale;

public class CoreTestCase {

    public static final Faker FAKER = new Faker(new Locale("en-GB"));
    private String bundlId = "co.jp.soramitsu.sora.dev";
    private AppiumDriver driver;
 //   public IOSDriver ios_driver;
    private static AppiumDriverLocalService service;
    
    @BeforeSuite
    public void globalSetup () throws IOException {
    	service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
    			.withIPAddress("127.0.0.1")
    			.withArgument(()-> "--base-path", "/wd/hub"));

    	
    	service.start();
    }

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
//    	else if (Platform.isIOS()) {
//    		driver = Platform.getInstance().getIosDriver();
//    		driver.activateApp(bundlId);
//    		WebDriverRunner.setWebDriver(ios_driver);
//    	}
//    	else {
//            throw new IllegalArgumentException("Cannot detect type of the Driver.");
//        }
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
    
    @AfterSuite
    public void globalTearDown () {
        if (service != null) {
            service.stop();
        }
    }

    public URL getServiceUrl () {
        return service.getUrl();
    }

    @Attachment(type = "img/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }
}