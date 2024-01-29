package jp.co.soramitsu.sora.qa.pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.ScreenObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import jp.co.soramitsu.sora.qa.pages.MorePage;
import jp.co.soramitsu.sora.qa.pages.onboarding.PinCodePage;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static jp.co.soramitsu.sora.qa.infrastructure.Platform.isAndroid;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class LoginAndSecurityPage {

    @AndroidFindBy(xpath = "//*[@text='Change PIN']")
    @iOSXCUITFindBy(accessibility = "Change PIN")
    private SelenideElement changePinBtn;

    @AndroidFindBy(xpath = "//*[@text='Biometric Auth']")
    @iOSXCUITFindBy(accessibility = "Biometric Auth")
    private SelenideElement biometricAuthBtn;

    @AndroidFindBy(xpath = "//*[@text='Pin code changed successfully']")
    private SelenideElement pinCodeChangedToast;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.widget.Button")
    @iOSXCUITFindBy(accessibility = "cross")
    private SelenideElement backBtn;

    @Step
    public PinCodePage goToChangePin() {
        changePinBtn.shouldBe(Condition.visible).click();
        return ScreenObject.screen(PinCodePage.class);
    }

    @Step
    public MorePage checkToastPinCodeChanged() {
        if (isAndroid()) {
            assertThat(pinCodeChangedToast.isDisplayed()).isTrue();
            log.info("Pin code changed");
        }
        backBtn.shouldBe(Condition.visible).click();
        return screen(MorePage.class);
    }
}

