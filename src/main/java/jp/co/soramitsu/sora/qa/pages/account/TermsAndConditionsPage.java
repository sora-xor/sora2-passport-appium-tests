package jp.co.soramitsu.sora.qa.pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.ScreenObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class TermsAndConditionsPage {

    @AndroidFindBy(xpath = "//*[@text='Accept & Continue']")
    @iOSXCUITFindBy(accessibility = "Accept & Continue")
    private SelenideElement acceptAndContinueBtn;

    @Step
    public VerifyPhoneNumberOtpPage acceptTermsAndConditions() {
        acceptAndContinueBtn.shouldBe(Condition.visible).click();
        return ScreenObject.screen(VerifyPhoneNumberOtpPage.class);
    }
}
