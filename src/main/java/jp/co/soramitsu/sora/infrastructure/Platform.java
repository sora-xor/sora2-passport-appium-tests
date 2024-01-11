package jp.co.soramitsu.sora.infrastructure;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import jp.co.soramitsu.sora.configs.TestConfig;
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

    public AppiumDriver getDriver() throws MalformedURLException {
        URL URL = new URL("http://127.0.0.1:4723/wd/hub");
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
        UiAutomator2Options options = new UiAutomator2Options()
        		.setPlatformName("Android")
        		.setDeviceName("emulator-5554")
        		.setPlatformVersion("12.0")
        		.setAutomationName("UIAutomator2")
        		.setAppPackage(TestConfig.config.androidBundleId())
        		.setAppActivity("jp.co.soramitsu.sora.splash.presentation.SplashActivity");
		return options;
    }

    private Capabilities getIOSDesiredCapabilities() {
    	DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOs");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("appium:deviceName", "new_phone");
        capabilities.setCapability("appium:includeSafariInWebviews", true);
        capabilities.setCapability("appium:newCommandTimeout", 3600);
        capabilities.setCapability("appium:connectHardwareKeyboard", true);
        capabilities.setCapability("appium:wdaLaunchTimeout", 40000);
        //capabilities.setCapability("noReset", false);
        capabilities.setCapability("bundleId", TestConfig.config.iOSBundleId());
        capabilities.setCapability("appium:isHeadless", true);
        return capabilities;
    }

    private String resourcePath(String file) {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(file);
        assertThat(resource).as("Test Resource not found in classpath: " + file);
        return resource.getFile();
    }
}
