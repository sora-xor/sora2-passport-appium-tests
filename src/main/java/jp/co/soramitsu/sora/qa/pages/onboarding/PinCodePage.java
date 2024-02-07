package jp.co.soramitsu.sora.qa.pages.onboarding;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.ScreenObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import jp.co.soramitsu.sora.qa.infrastructure.Utils;
import jp.co.soramitsu.sora.qa.pages.WalletPage;
import jp.co.soramitsu.sora.qa.pages.account.LoginAndSecurityPage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static jp.co.soramitsu.sora.qa.infrastructure.Platform.isAndroid;
import static jp.co.soramitsu.sora.qa.infrastructure.Platform.isIOS;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class PinCodePage {
    @AndroidFindBy(xpath = "//*[@text='Confirm pin code']")
    @iOSXCUITFindBy(accessibility = "Confirm Pin Code")
    private SelenideElement pinCodeRepeatTitleTv;

    @AndroidFindBy(id = "android:id/button1")
    private SelenideElement logoutBtn;

    @AndroidFindBy(id = "android:id/button2")
    private SelenideElement cancelBtn;

    @AndroidFindBy(xpath = "//*[@text='LOGOUT']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Logout\"]")
    private SelenideElement logoutAlertBnt;

    @AndroidFindBy(xpath = "//*[@text='Setup pin code']")
    @iOSXCUITFindBy(accessibility = "Setup Pin Code")
    private SelenideElement pinCodeTitleTv;

    @AndroidFindBy(xpath = "//*[@text='Enter current pin code']")
    @iOSXCUITFindBy(accessibility = "Enter Pin Code")
    private SelenideElement currentPinCodeTitleTv;

    @AndroidFindBy(xpath = "//*[@text='Enter new pin code']")
    @iOSXCUITFindBy(accessibility = "Enter new pin code")
    private SelenideElement newPinCodeTitleTv;

    @AndroidFindBy(xpath = "//*[@text='Confirm new pin code']")
    @iOSXCUITFindBy(accessibility = "Confirm new pin code")
    private SelenideElement confirmNewPinCodeTitleTv;

    @AndroidFindBy(xpath = "//*[@text='Enter pin code']")
    @iOSXCUITFindBy(accessibility = "Enter Pin Code")
    private SelenideElement enterPinCodeTitleTv;

    @iOSXCUITFindBy(accessibility = "0")
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/btn0")
    private SelenideElement pinCodeBtn0;


    @Step
    public WalletPage enterAndConfirmPinCodeNew() {
        if (isAndroid()) {
            log.info("Set up Pin Code");
            assertThat(pinCodeTitleTv.isDisplayed()).isTrue();
            enterPinCodeAndroid();
            assertThat(pinCodeRepeatTitleTv.isDisplayed()).isTrue();
            log.info("Confirm Pin Code");
            enterPinCodeAndroid();
        }
        if (isIOS()) {
            log.info("Set up Pin Code");
            assertThat(pinCodeTitleTv.isDisplayed()).isTrue();
            enterPinCodeIOs();
            assertThat(pinCodeRepeatTitleTv.isDisplayed()).isTrue();
            log.info("Confirm Pin Code");
            enterPinCodeIOs();
        }
        return screen(WalletPage.class);
    }

    @Step
    public WalletPage enterAndConfirmPinCodeImport() {
        log.info("Set up Pin Code");
        if (isAndroid()) {
            log.info("Set up Pin Code");
            assertThat(pinCodeTitleTv.isDisplayed()).isTrue();
            enterPinCodeAndroid();
            assertThat(pinCodeRepeatTitleTv.isDisplayed()).isTrue();
            log.info("Confirm Pin Code");
            enterPinCodeAndroid();
        }
        if (isIOS()) {
            log.info("Set up Pin Code");
            assertThat(pinCodeTitleTv.isDisplayed()).isTrue();
            enterPinCodeIOs();
            assertThat(pinCodeRepeatTitleTv.isDisplayed()).isTrue();
            log.info("Confirm Pin Code");
            enterPinCodeIOs();
        }
        return screen(WalletPage.class);
    }

    @Step
    public WelcomePage enterPinCodeOnLogout() {
        log.info("Enter Pin Code");
        if (isAndroid()) {
            assertThat(enterPinCodeTitleTv.isDisplayed()).isTrue();
            enterPinCodeAndroid();
        }
        if (isIOS()) {
            assertThat(enterPinCodeTitleTv.isDisplayed()).isTrue();
            enterPinCodeIOs();
        }
        logoutAlertBnt.click();
        return screen(WelcomePage.class);
    }

    @Step
    public LoginAndSecurityPage changeAndConfirmChangePinCode() {
        if (isAndroid()) {
            assertThat(currentPinCodeTitleTv.isDisplayed()).isTrue();
            log.info("Enter Current Pin Code");
            enterPinCodeAndroid();
            assertThat(newPinCodeTitleTv.isDisplayed()).isTrue();
            log.info("Enter new Pin Code");
            enterPinCodeAndroid();
            assertThat(confirmNewPinCodeTitleTv.isDisplayed()).isTrue();
            log.info("Confirm Pin Code");
            enterPinCodeAndroid();
        }
        if (isIOS()) {
            assertThat(currentPinCodeTitleTv.isDisplayed()).isTrue();
            log.info("Enter Current Pin Code");
            enterPinCodeIOs();
            assertThat(pinCodeTitleTv.isDisplayed()).isTrue();
            log.info("Enter new Pin Code");
            enterPinCodeIOs();
            assertThat(pinCodeRepeatTitleTv.isDisplayed()).isTrue();
            log.info("Confirm Pin Code");
            enterPinCodeIOs();
        }
        return ScreenObject.screen(LoginAndSecurityPage.class);
    }

    @Step
    public WalletPage enterPinCode() {
        log.info("Enter Pin Code");
        if (isAndroid()) {
            enterPinCodeAndroid();
        }
        if (isIOS()) {
            assertThat(pinCodeTitleTv.isDisplayed()).isTrue();
            enterPinCodeIOs();
        }
        return ScreenObject.screen(WalletPage.class);
    }

    public void enterPinCodeAndroid(){
        for (int i = 1; i <= 6; i++) {
            $(By.id("jp.co.soramitsu.sora.develop:id/" + i)).click();
        }
    }

    public void enterPinCodeIOs(){
        for (int i = 1; i <= 6; i++) {
            Utils.tapElementByCoordinates($(By.name("" + i)));
        }
    }
}
