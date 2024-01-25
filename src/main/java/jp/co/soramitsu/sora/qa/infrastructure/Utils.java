package jp.co.soramitsu.sora.qa.infrastructure;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Utils {

    public static void scrollForward(int count) {
        AppiumDriver androidDriver = (AppiumDriver) WebDriverRunner.getWebDriver();
        for (int i = 0; i < count; i++) {
            androidDriver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
        }
    }

    public void scrollBackward(int count) {
        AppiumDriver androidDriver = (AppiumDriver) WebDriverRunner.getWebDriver();
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


//        HashMap<String, String> scrollObject = new HashMap<>();
//        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
//        scrollObject.put("direction", "down");
//        js.executeScript("mobile: swipe", scrollObject);

        AppiumDriver driver = (AppiumDriver) getWebDriver();

        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 15;
        int endX = startX;
        int endY = size.getHeight() / 3;
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    public static void tapElementByCoordinates(SelenideElement element) {
        int x = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int y = element.getLocation().getY() + element.getSize().getHeight() / 2;

        AppiumDriver driver = (AppiumDriver) getWebDriver();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
    }
}