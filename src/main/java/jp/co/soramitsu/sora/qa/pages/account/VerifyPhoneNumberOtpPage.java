package jp.co.soramitsu.sora.qa.pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.ScreenObject.screen;

@Log4j2
public class VerifyPhoneNumberOtpPage {
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]")
    private SelenideElement selectCountryField;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]")
    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Phone Number\"")
    private SelenideElement phoneNumberField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText")
    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Phone Number\"")
    private SelenideElement otpField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.widget.Button[2]")
    private SelenideElement searchCountryBtn;

    @AndroidFindBy(className = "android.widget.EditText")
    private SelenideElement searchCountryEditText;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View")
    private SelenideElement searchCountryResult;


    @AndroidFindBy(xpath = "//*[@text='Send SMS code']")
    @iOSXCUITFindBy(accessibility = "Send SMS code")
    private SelenideElement sendSMSCodeBtn;

    @Step
    public VerificationStatusPage verifyYourPhoneNumber(String phonePending, String otpTest) {

        phoneNumberField.shouldBe(Condition.enabled).sendKeys(phonePending);
        log.info("phonePending entered " + phonePending);
        sendSMSCodeBtn.shouldBe(Condition.visible).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        otpField.shouldBe(Condition.visible).sendKeys(otpTest);
        log.info("entered OTP " + otpTest);
        //todo test fails without this block. check and change to selenium wait
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return screen(VerificationStatusPage.class);
    }

    public void setCountry(String countryCode)
    {
        selectCountryField.shouldBe(visible).click();
        searchCountryBtn.shouldBe(visible).click();
        searchCountryEditText.shouldBe(visible).sendKeys(countryCode);
        searchCountryResult.shouldBe(visible).click();
    }
}


