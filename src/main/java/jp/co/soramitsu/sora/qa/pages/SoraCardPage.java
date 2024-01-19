package jp.co.soramitsu.sora.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import jp.co.soramitsu.sora.qa.pages.account.TermsAndConditionsPage;
import lombok.extern.log4j.Log4j2;
import jp.co.soramitsu.sora.qa.pages.account.VerifyPhoneNumberOtpPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumScrollOptions.*;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.ScrollDirection.DOWN;
import static jp.co.soramitsu.sora.qa.infrastructure.Platform.isAndroid;
import static jp.co.soramitsu.sora.qa.infrastructure.Platform.isIOS;
import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;

@Log4j2
public class SoraCardPage {

    @AndroidFindBy(id = "GetSoraCard")
    private SelenideElement viewSoraCardDetailsBtn;

    @AndroidFindBy(id = "SoraCardLogInOrSignUp")
    @iOSXCUITFindBy(accessibility = "Log in or Sign up")
    private SelenideElement soraCardLogInOrSignUpBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View[2]/android.widget.TextView[3]")
    @iOSXCUITFindBy(accessibility = "enoughXorForAFreeCard")
    private SelenideElement enoughXorForAFreeCard;

    @AndroidFindBy(xpath = "//*[@text='Continue']")
    @iOSXCUITFindBy(accessibility = "Continue")
    private SelenideElement continueBtn;

    @AndroidFindBy(id = "GetMoreXor")
    @iOSXCUITFindBy(accessibility = "GetMoreXor")
    private SelenideElement getMoreXorBtn;

    @iOSXCUITFindBy(accessibility = "€0 annual service fee")
    private SelenideElement annualFeeBtn;


    @Step
    public void checkThatUserHaveEnoughXorForAFreeCard() {
        String actualXorBalance = enoughXorForAFreeCard.shouldBe(Condition.visible).getText();
        assertThat(actualXorBalance).isEqualTo("You have enough XOR for a FREE card");
    }

    @Step
    public void CheckThatUserNeedMoreXor() {
        String actualXorBalance = enoughXorForAFreeCard.shouldBe(Condition.visible).getText();
        assertThat(actualXorBalance).contains("You need");
    }

    @Step
    public VerifyPhoneNumberOtpPage startSoraCardFlow() {
        continueBtn.shouldBe(Condition.visible).click();
        return screen(VerifyPhoneNumberOtpPage.class);
    }

    @Step
    public void swipeDown() {
        if (isAndroid()) {
            SelenideAppium.$x(".//*[@text='€0 annual service fee']").click();
            SelenideAppium.$x(".//*[@text='or €20 application fee']")
                    .scroll(with(DOWN, 1));
            SelenideAppium.$x(".//*[@text='Log in or Sign up']")
                    .scroll(down())
                    .shouldHave(visible);
        }
        if (isIOS()) {
            annualFeeBtn.shouldBe(Condition.visible).click();
            SelenideAppium.$(By.name("Log in or Sign up"))
                    .scroll(down())
                    .shouldHave(visible);
        }
    }

    @Step
    public TermsAndConditionsPage viewSoraCardFlow() {
        {
            soraCardLogInOrSignUpBtn.shouldBe(Condition.visible).click();
            return screen(TermsAndConditionsPage.class);
        }
    }
}




