package jp.co.soramitsu.sora.infrastructure;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Utils {

    public static void scrollForward(int count) {
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

    public static void swipeDown() {
        TouchAction touchAction = new TouchAction((PerformsTouchActions) getWebDriver());
        Dimension size = getWebDriver().manage().window().getSize();

        int startX = size.width * 2;
        int startY = size.height / 10;
        int endY = size.height / 2;

        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }
}