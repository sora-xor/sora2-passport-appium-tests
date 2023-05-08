package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;
import pages.MorePage;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static org.assertj.core.api.Assertions.assertThat;
@Log4j2
public class LoginAndSecurityPage {

    @AndroidFindBy(xpath = "//*[@text='Change PIN']")
    private SelenideElement changePinBtn;

    @AndroidFindBy(xpath = "//*[@text='Biometric Auth']")
    private SelenideElement biometricAuthBtn;

    @AndroidFindBy(xpath = "//*[@text='Pin code changed successfully']")
    private SelenideElement pinCodeСhangedToast;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.widget.Button")
    private SelenideElement backBtn;

    public PinCodePage goToChangePin()
    {
        changePinBtn.shouldBe(Condition.visible).click();
        return screen(PinCodePage.class);
    }

    public MorePage checkToastPinCodeChanged()
    {
        assertThat(pinCodeСhangedToast.isDisplayed());
        log.info("Pin code changed");
        backBtn.shouldBe(Condition.visible).click();
        return screen(MorePage.class);
    }
}

