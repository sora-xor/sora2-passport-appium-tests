package infrastructure;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Capabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class Platform {
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";

    private static final Platform instance = new Platform();
    private final String name;

    public static Platform getInstance() {
        return instance;
    }

    private Platform() {
        name = System.getProperty("PLATFORM");
    }

    AppiumDriver getDriver() throws MalformedURLException {
        URL URL = new URL("http://localhost:4723/wd/hub");
        if (isAndroid()) {
            return new AndroidDriver(URL, getAndroidDesiredCapabilities());
        } else if (isIOS()) {
            return new IOSDriver(URL, getIOSDesiredCapabilities());
        } else {
            throw new IllegalArgumentException("Cannot detect type of the Driver. settings.Platform value: " + name);
        }
    }

    public boolean isAndroid() {
        return PLATFORM_ANDROID.equals(name);
    }

    public boolean isIOS() {
        return PLATFORM_IOS.equals(name);
    }

    private Capabilities getAndroidDesiredCapabilities() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        options.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        options.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        options.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        options.setCapability(MobileCapabilityType.APP, resourcePath("apps/SORA2.5.3.apk"));
        return options;
    }

    private Capabilities getIOSDesiredCapabilities() {
        XCUITestOptions options = new XCUITestOptions();
        options.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        // Hint: run `xcodebuild -showsdks` to see the list of available SDKs
        options.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12");
        // Hint: run `xcrun simctl list runtimes` to get available runtimes
        options.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.5");
        options.setCapability(MobileCapabilityType.APP, resourcePath("apps/Bakong.zip"));
        options.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        options.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
//        options.setCapability("autoAcceptAlerts", true);
//        options.setFullReset(true);
        return options;
    }

    private String resourcePath(String file) {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(file);
        assertThat(resource).as("Test Resource not found in classpath: " + file);
        return resource.getFile();
    }
}