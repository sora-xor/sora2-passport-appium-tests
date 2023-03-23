package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

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

    public void VerifyYourPhoneNumber(){
        acceptAndContinueBtn.shouldBe(Condition.visible).click();
        phoneNumberField.shouldBe(Condition.visible).sendKeys("12345678");
        sendSMSCodeBtn.shouldBe(Condition.enabled).click();
    }

}


