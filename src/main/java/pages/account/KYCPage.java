package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;
import pages.WalletPage;

import static com.codeborne.selenide.appium.ScreenObject.screen;
@Log4j2
public class KYCPage {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "")
    private SelenideElement phoneNumberField;

    @AndroidFindBy(xpath = "//*[@text='Send SMS code']")
    @iOSXCUITFindBy(accessibility = "")
    private SelenideElement sendSMSCodeBtn;

 /*   @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "")
    private SelenideElement otpInput; */

    public KYCOtpPage verifyYourPhoneNumber(String phonePending){
        log.info("Start debug");

        phoneNumberField.shouldBe(Condition.enabled).sendKeys(phonePending);
        log.info("phonePending entered "+ phonePending);
        sendSMSCodeBtn.shouldBe(Condition.enabled);
        sendSMSCodeBtn.click();
        log.info("Send SMS button clicked");
        return screen(KYCOtpPage.class);
 //       SelenideAppium.$x("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText").shouldBe(Condition.enabled).sendKeys(otpTest);
 //       log.info("entered OTP " +otpTest);
    }

 /*   public VerificationStatusPage goToVerificationStatusPage() {

   //     sendSMSCodeBtn.shouldBe(Condition.visible).click();
  //      otpInput.shouldBe(Condition.enabled).sendKeys("123456");

        return screen(VerificationStatusPage.class);
    } */

}


