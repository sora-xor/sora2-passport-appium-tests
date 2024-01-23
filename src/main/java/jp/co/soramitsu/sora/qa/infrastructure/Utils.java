package jp.co.soramitsu.sora.qa.infrastructure;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.$;
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
//        TouchAction touchAction = new TouchAction((PerformsTouchActions) getWebDriver());
//        Dimension size = getWebDriver().manage().window().getSize();
//
//        int startX = size.width * 2;
//        int startY = size.height / 10;
//        int endY = size.height / 2;
//
//        touchAction.press(PointOption.point(startX, startY))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//                .moveTo(PointOption.point(startX, endY))
//                .release()
//                .perform();


        HashMap<String, String> scrollObject = new HashMap<>();
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: swipe", scrollObject);
    }

    public static void tapElementByCoordinates(SelenideElement element) {
        int x = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int y = element.getLocation().getY() + element.getSize().getHeight() / 2;

        TouchAction touchAction = new TouchAction((PerformsTouchActions) getWebDriver());
        touchAction.tap(PointOption.point(x, y)).perform();
    }
}