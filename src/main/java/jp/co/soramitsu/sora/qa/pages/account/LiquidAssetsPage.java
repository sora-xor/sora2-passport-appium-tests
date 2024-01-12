package jp.co.soramitsu.sora.qa.pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import jp.co.soramitsu.sora.qa.configs.TestConfig;
import jp.co.soramitsu.sora.qa.infrastructure.Utils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import jp.co.soramitsu.sora.qa.pages.WalletPage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static jp.co.soramitsu.sora.qa.infrastructure.Platform.isAndroid;
import static jp.co.soramitsu.sora.qa.infrastructure.Platform.isIOS;


@Log4j2
public class LiquidAssetsPage {

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SendButton")
    @iOSXCUITFindBy(accessibility = "Send")
    private SelenideElement sendTokenBtn;
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/TokenN0")
    @iOSXCUITFindBy(accessibility = "SORA")
    private SelenideElement xorTokenDetails;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SearchInput")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Select recipient address\"]/following-sibling::*//XCUIElementTypeTextField")
    private SelenideElement accountToSendInput;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SearchItemN0")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEARCH RESULTS\"]/parent::*/following-sibling::*//XCUIElementTypeStaticText")
    private SelenideElement searchResultToSend;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SelectTokenXOR")
    @iOSXCUITFindBy(accessibility = "Wallet/arrow")
    private SelenideElement selectTokenXor;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/XORElement")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"SORA\"])[3]")
    private SelenideElement xorElement;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/InputAmountFieldXOR")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SORA Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField")
    private SelenideElement inputAmountFieldXor;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/InputAmountField")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private SelenideElement inputAmountField;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/ReviewButton")
    @iOSXCUITFindBy(accessibility = "Review")
    private SelenideElement reviewBtn;

    @AndroidFindBy(xpath = "//*[@text='Confirm']")
    @iOSXCUITFindBy(accessibility = "Confirm")
    private SelenideElement confirmBtn;

    @AndroidFindBy(xpath = "//*[@text='Network fee']")
    @iOSXCUITFindBy(accessibility = "info")
    private SelenideElement networkFeeBtn;

    @AndroidFindBy(xpath = "//*[@text='OK']")
    @iOSXCUITFindBy(accessibility = "OK")
    private SelenideElement okBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/CloseButton")
    @iOSXCUITFindBy(accessibility = "Close")
    private SelenideElement closeBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.Button")
    private SelenideElement backBtn;

    @iOSXCUITFindBy(accessibility = "Liquid balance")
    private SelenideElement liquidBalance;

    @iOSXCUITFindBy(accessibility = "qrScan")
    private SelenideElement qrScan;

    @Step
    public WalletPage sendToken(String randomValue) {
        log.info("Open XOR token details");
        xorTokenDetails.shouldBe(Condition.visible).click();
        log.info("Tap Send  button");
        sendTokenBtn.shouldBe(Condition.visible).click();
        log.info("Enter address " + TestConfig.config.assetId());
        accountToSendInput.shouldBe(Condition.visible).sendKeys(TestConfig.config.assetId());
        searchResultToSend.shouldBe(Condition.visible).click();
        inputAmountField.shouldBe(Condition.visible).sendKeys(randomValue);
        if (isAndroid()) {
            log.info("Check Network Fee button");
            networkFeeBtn.shouldBe(Condition.visible).click();
            okBtn.shouldBe(Condition.visible).click();
        }

        log.info("Wait for Review button to be active...");
        WebDriver driver = WebDriverRunner.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT300S"), Duration.parse("PT1S"));
        wait.until(ExpectedConditions.visibilityOf(reviewBtn));
        log.info("Click Review button");
        reviewBtn.click();

        log.info("Wait for Confirm button to be active...");
        WebDriver driver1 = WebDriverRunner.getWebDriver();
        WebDriverWait wait1 = new WebDriverWait(driver1, Duration.parse("PT300S"), Duration.parse("PT1S"));
        wait1.until(ExpectedConditions.visibilityOf(confirmBtn));
        if (isIOS()) {
            log.info("Check Network Fee button");
            networkFeeBtn.shouldBe(Condition.visible).click();
            okBtn.shouldBe(Condition.visible).click();
        }
        log.info("Click Confirm button");
        confirmBtn.click();
        log.info("Click Close button");
        closeBtn.shouldBe(Condition.visible).click();


        if (isIOS()) {
            log.info("Close Asset details by swipe down");
            Utils.swipeDown();
            qrScan.shouldBe(Condition.visible);
        }
        return screen(WalletPage.class);
    }
}


