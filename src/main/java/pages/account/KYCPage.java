package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import static com.codeborne.selenide.appium.ScreenObject.screen;

public class KYCPage {

    @AndroidFindBy(xpath = "//*[@text='ACCEPT & CONTINUE']")
    @iOSXCUITFindBy(accessibility = "ACCEPT & CONTINUE")
    private SelenideElement acceptAndContinueBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "PhoneNumberField")
    private SelenideElement phoneNumberField;

    @AndroidFindBy(xpath = "//*[@text='SEND SMS CODE']")
    @iOSXCUITFindBy(accessibility = "SEND SMS CODE")
    private SelenideElement sendSMSCodeBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "")
    private SelenideElement otpInput;

    public void VerifyYourPhoneNumber(String phonePending){
        acceptAndContinueBtn.shouldBe(Condition.visible).click();
        phoneNumberField.shouldBe(Condition.visible).sendKeys(phonePending);
        sendSMSCodeBtn.shouldBe(Condition.enabled);
        sendSMSCodeBtn.click();
        otpInput.shouldBe(Condition.enabled);
        otpInput.sendKeys("123456");

    }

    public VerificationStatusPage goToVerificationStatusPage() {

   //     sendSMSCodeBtn.shouldBe(Condition.visible).click();
  //      otpInput.shouldBe(Condition.enabled).sendKeys("123456");

        return screen(VerificationStatusPage.class);
    }

}


