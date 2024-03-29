package jp.co.soramitsu.sora.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import jp.co.soramitsu.sora.qa.infrastructure.Utils;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static jp.co.soramitsu.sora.qa.infrastructure.Platform.isAndroid;
import static jp.co.soramitsu.sora.qa.infrastructure.Platform.isIOS;
import static org.assertj.core.api.Assertions.*;

@Log4j2
public class ActivityPage extends CommonPage {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Swapped\"])[1]")
    private SelenideElement lastTransaction;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Pool\"])[1]")
    private SelenideElement lastPooledTransaction;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Swapped\"])[1]")
    private SelenideElement lastSwappedTransaction;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Sent\"])[1]")
    private SelenideElement lastSentTransaction;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SORA Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")
    private SelenideElement getXorFromLastTransaction;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView[3]")
    private SelenideElement getXstFromLastTransaction;

    @AndroidFindBy(accessibility = "Swapped")
    @iOSXCUITFindBy(accessibility = "Swapped")
    private SelenideElement swappedItem;

    @AndroidFindBy(accessibility = "Sent")
    @iOSXCUITFindBy(accessibility = "Sent")
    private SelenideElement sentItem;

    @AndroidFindBy(accessibility = "Referrer set")
    @iOSXCUITFindBy(accessibility = "Referrer set")
    private SelenideElement referrerSetItem;

    @AndroidFindBy(accessibility = "Bonded")
    @iOSXCUITFindBy(accessibility = "Bonded")
    private SelenideElement boundedItem;

    @AndroidFindBy(accessibility = "Unbonded")
    @iOSXCUITFindBy(accessibility = "Unbonded")
    private SelenideElement unboundedItem;


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.widget.TextView[2]")
    private SelenideElement availableInvitations;

    @AndroidFindBy(accessibility = "Sent to pool")
    @iOSXCUITFindBy(accessibility = "Extrinsic hash")
    private SelenideElement sentToPoolItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Status\"]/following-sibling::*[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Status\"]/following-sibling::*[1]")
    private SelenideElement getTransactionStatus;

    @AndroidFindBy(xpath = "//*[@text='Close']")
    @iOSXCUITFindBy(accessibility = "Close")
    private SelenideElement closeBtn;
    @iOSXCUITFindBy(accessibility = "TODAY")
    private SelenideElement TodayTxt;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.Button")
    @iOSXCUITFindBy(accessibility = "Close")
    private SelenideElement backBtn;


    @Step
    public void checkLastTransactionStatusSwap(String randomValue) {
        if (isIOS()) {
            log.info("Waiting for the transaction item to be displayed");
            WebDriver driver = WebDriverRunner.getWebDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT30S"), Duration.parse("PT1S"));
            wait.until(ExpectedConditions.visibilityOf(TodayTxt));
            log.info("Open the last Swap transaction details");
            lastSwappedTransaction.shouldBe(Condition.visible).click();
        }
        if (isAndroid()) {
            log.info("Open the last Swap transaction details");
            lastTransaction.shouldBe(Condition.visible).click();
        }
        swappedItem.shouldBe(Condition.visible);
        String getXorAmountValueFromHistory = "";
        if (isAndroid()) {
            log.info("Last transaction type: " + swappedItem.getAttribute("content-desc"));
            getXorAmountValueFromHistory = $(By.xpath(String.format("//*[@text=\"%s XOR\"]", randomValue))).shouldBe(Condition.visible).getText();
        } else if (isIOS()) {
            getXorAmountValueFromHistory = $(By.name(randomValue + " XOR")).shouldBe(Condition.visible).getValue();
        }
        log.info("Get Xor from last transaction: " + getXorAmountValueFromHistory);
        closeBtn.shouldBe(Condition.visible).click();
    }


    @Step
    public void checkLastTransactionStatusPool(String randomValue) {
        if (isIOS()) {
            log.info("Waiting for the transaction item to be displayed");
            WebDriver driver = WebDriverRunner.getWebDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT30S"), Duration.parse("PT1S"));
            wait.until(ExpectedConditions.visibilityOf(TodayTxt));
            log.info("Open the last Pool transaction details");
            lastPooledTransaction.shouldBe(Condition.visible).click();
        }
        if (isAndroid()) {
            log.info("Open the last Pool transaction details");
            lastTransaction.shouldBe(Condition.visible).click();
        }
        sentToPoolItem.shouldBe(Condition.visible);
        String getXorAmountValueFromHistory = "";
        if (isAndroid()) {
            log.info("Last transaction type: " + sentToPoolItem.getAttribute("content-desc"));
            getXorAmountValueFromHistory = $(By.xpath(String.format("//*[@text=\"%s XOR\"]", randomValue))).shouldBe(Condition.visible).getText();
        } else if (isIOS()) {
            getXorAmountValueFromHistory = $(By.name(randomValue + " XOR")).shouldBe(Condition.visible).getValue();
        }
        log.info("Get Xor from last transaction: " + getXorAmountValueFromHistory);
        closeBtn.shouldBe(Condition.visible).click();
    }

    @Step public WalletPage checkSendTransaction(){
        checkTrxStatus("Successful");
        closeBtn.shouldBe(Condition.visible).click();
        if (isIOS()) {
            log.info("Close Asset details by swipe down");
            Utils.swipeDown();
        }
        return screen(WalletPage.class);
    }
    @Step
    public void checkLastTransactionSendToken(String randomValue) {
        if (isIOS()) {
            log.info("Waiting for the transaction item to be displayed");
            WebDriver driver = WebDriverRunner.getWebDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT30S"), Duration.parse("PT1S"));
            wait.until(ExpectedConditions.visibilityOf(TodayTxt));
            log.info("Open the last Sent transaction details");
            lastSentTransaction.shouldBe(Condition.visible).click();
        }
        if (isAndroid()) {
            log.info("Open the last Sent transaction details");
            lastTransaction.shouldBe(Condition.visible).click();
        }
        sentItem.shouldBe(Condition.visible);
        String getXorAmountValueFromHistory = "";
        if (isAndroid()) {
            log.info("Last transaction type: " + sentItem.getAttribute("content-desc"));
            getXorAmountValueFromHistory = $(By.xpath(String.format("//*[@text=\"%s XOR\"]", randomValue))).shouldBe(Condition.visible).getText();
        } else if (isIOS()) {
            getXorAmountValueFromHistory = $(By.name(randomValue + " XOR")).shouldBe(Condition.visible).getValue();
        }
        log.info("Get Xor from last transaction: " + getXorAmountValueFromHistory);
        closeBtn.shouldBe(Condition.visible).click();
    }

    @Step
    public ReferralProgramPage checkSetReferrerTransaction() {
        //todo add trx type check
        checkTrxStatus("Successful");
        closeBtn.shouldBe(Condition.visible).click();
        return screen(ReferralProgramPage.class);
    }

    @Step
    public ReferralProgramPage checkBoundXorTransaction() {
        log.info("Check bond trx");
        assertThat(boundedItem.isDisplayed()).isTrue();
        checkTrxStatus("Successful");
        log.info("trx is successful");
        closeBtn.shouldBe(Condition.visible).click();
        return screen(ReferralProgramPage.class);
    }

    @Step
    public ReferralProgramPage checkUnboundXorTransaction() {
        log.info("Check unbond trx");
        assertThat(unboundedItem.isDisplayed()).isTrue();
        checkTrxStatus("Successful");
        closeBtn.shouldBe(Condition.visible).click();
        return screen(ReferralProgramPage.class);
    }

    private void checkTrxStatus(String status){
        WebDriver driver = WebDriverRunner.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT30S"), Duration.parse("PT1S"));
        if(isAndroid()) {
            wait.until(ExpectedConditions.attributeToBe(getTransactionStatus, "text", status));
        }
        else {
            wait.until(ExpectedConditions.attributeToBe(getTransactionStatus, "value", status));
        }
    }
}

