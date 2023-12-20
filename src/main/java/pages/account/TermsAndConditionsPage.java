package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.appium.ScreenObject.screen;

public class TermsAndConditionsPage {

    @AndroidFindBy(xpath = "//*[@text='Accept & Continue']")
    @iOSXCUITFindBy(accessibility = "Accept & Continue")
    private SelenideElement acceptAndContinueBtn;

    @Step
    public VerifyPhoneNumberOtpPage acceptTermsAndConditions() {
        acceptAndContinueBtn.shouldBe(Condition.visible).click();
        return screen(VerifyPhoneNumberOtpPage.class);
    }
}
