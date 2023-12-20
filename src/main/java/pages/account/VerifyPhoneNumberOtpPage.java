package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@Log4j2
public class VerifyPhoneNumberOtpPage {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText")
    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Phone Number\"")
    private SelenideElement phoneNumberOTPField;

    //@AndroidFindBy(xpath = "//*[@text='OK']")
    //private SelenideElement okOtpBtn;

    @AndroidFindBy(xpath = "//*[@text='Send SMS code']")
    @iOSXCUITFindBy(accessibility = "Send SMS code")
    private SelenideElement sendSMSCodeBtn;

    @Step
    public VerificationStatusPage verifyYourPhoneNumber(String phonePending, String otpTest) {

        phoneNumberOTPField.shouldBe(Condition.enabled).sendKeys(phonePending);
        log.info("phonePending entered " + phonePending);
        sendSMSCodeBtn.shouldBe(Condition.visible).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        phoneNumberOTPField.shouldBe(Condition.visible).sendKeys(otpTest);
        log.info("entered OTP " + otpTest);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return screen(VerificationStatusPage.class);
    }
}


