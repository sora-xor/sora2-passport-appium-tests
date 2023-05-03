package infrastructure;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Utils {

    public void scrollForward(int count) {
        AndroidDriver androidDriver = (AndroidDriver) WebDriverRunner.getWebDriver();
        for (int i = 0; i < count; i++) {
            androidDriver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
        }
    }

    public void scrollBackward(int count) {
        AndroidDriver androidDriver = (AndroidDriver) WebDriverRunner.getWebDriver();
        for (int i = 0; i < count; i++) {
            androidDriver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
        }
    }
}