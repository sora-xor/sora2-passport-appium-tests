package infrastructure;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Capabilities;



import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class Platform {
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";

    private static final Platform instance = new Platform();
    private static String name;

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

    public static boolean isAndroid() {
        return PLATFORM_ANDROID.equals(name);
    }

    public static boolean isIOS() {
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
    	DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOs");
		capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("appium:platformVersion", "16.0");
        capabilities.setCapability("appium:deviceName", "iPhone 14 Pro");
        capabilities.setCapability("appium:includeSafariInWebviews", true);
        capabilities.setCapability("appium:newCommandTimeout", 3600);
        capabilities.setCapability("appium:connectHardwareKeyboard", true);
		capabilities.setCapability("appium:wdaLaunchTimeout", 40000);
		capabilities.setCapability("bundleId", "co.jp.soramitsu.sora.dev");
        return capabilities;
    }

    private String resourcePath(String file) {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(file);
        assertThat(resource).as("Test Resource not found in classpath: " + file);
        return resource.getFile();
    }
}