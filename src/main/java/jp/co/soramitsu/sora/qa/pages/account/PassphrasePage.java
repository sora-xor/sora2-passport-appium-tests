package jp.co.soramitsu.sora.qa.pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.ScreenObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class PassphrasePage {

    @AndroidFindBy(xpath = "//*[@text='Skip']")
    @iOSXCUITFindBy(accessibility = "Skip")
    private SelenideElement skipBtn;

    @AndroidFindBy(xpath = "//*[@text='I will risk it']")
    @iOSXCUITFindBy(accessibility = "I will risk it")
    private SelenideElement willRiskBtn;

    @Step
    public PinCodePage skipPassPhrase() {
        skipBtn.shouldBe(Condition.visible).click();
        willRiskBtn.shouldBe(Condition.visible).click();
        return ScreenObject.screen(PinCodePage.class);
    }
}
