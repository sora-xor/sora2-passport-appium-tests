package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;
import pages.account.NameYourAccountPage;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static infrastructure.Platform.isAndroid;
import static infrastructure.Platform.isIOS;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class BuyXorPage {
    @AndroidFindBy(accessibility = "dev.x1ex.com")
    @iOSXCUITFindBy(accessibility = "dev.x1ex.com")
    private SelenideElement devX1;

    @AndroidFindBy(xpath = "//*[@text='Continue']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\'Continue']")
    private SelenideElement continueBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "from-amount")
    private SelenideElement fromAmount;


    @AndroidFindBy(xpath = "    /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View")
    @iOSXCUITFindBy(accessibility = "EUR")
    private SelenideElement fiatAmountValue;


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View")
    @iOSXCUITFindBy(accessibility = "from-method")
    private SelenideElement paymentMethod;

    @AndroidFindBy(id = "to-amount")
    @iOSXCUITFindBy(accessibility = "to-amount")
    private SelenideElement toAmount;

    @AndroidFindBy(id = "destination")
    @iOSXCUITFindBy(accessibility = "destination")
    private SelenideElement receivingDestination;

    @AndroidFindBy(id = "to-method")
    @iOSXCUITFindBy(accessibility = "to-method")
    private SelenideElement blockchainMethod;

    @AndroidFindBy(xpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "email")
    private SelenideElement emailField;

    @AndroidFindBy(accessibility = "back")
    @iOSXCUITFindBy(accessibility = "back")
    private SelenideElement backBtn;

    @AndroidFindBy(accessibility = "Resend verification email")
    @iOSXCUITFindBy(accessibility = "Resend verification email")
    private SelenideElement resendVerificationEmailBtn;

    @AndroidFindBy(xpath = "//*[@text='Email verification required']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\'Email verification required']")
    private SelenideElement emailVerificationRequiredField;

    public void CompleteFormToBuyXor ()
    {
        continueBtn.shouldBe(Condition.visible).click();
        String checkAmount = fromAmount.shouldBe(Condition.visible).getText();
        assertThat(checkAmount).as("100.0").isEqualTo("100.0");

        String checkFiat = fiatAmountValue.shouldBe(Condition.visible).getText();
        assertThat(checkFiat).as("EUR").isEqualTo("EUR");

        String checkPaymentMethod = paymentMethod.shouldBe(Condition.visible).getText();
        assertThat(checkPaymentMethod).as("Credit Card").isEqualTo("Credit Card");
    }


    public void enterEmail (String email) {
        log.info("Enter email" + email);
        emailField.shouldBe(Condition.visible).sendKeys(email);
        continueBtn.shouldBe(Condition.visible).click();
    }

    public void emailVerificationRequired (){
        String actualTitle = emailVerificationRequiredField.shouldBe(Condition.visible).getText();
        log.info("Email verification required");
        assertThat(actualTitle).as("Email verification required").isEqualTo("Email verification required");
    }



}
