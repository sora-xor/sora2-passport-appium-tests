package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import pages.SoraCardPage;
import pages.WalletPage;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;

public class VerificationStatusPage {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "SEND SMS CODE")
    private SelenideElement otpInput;
    @iOSXCUITFindBy(accessibility = "iconMenuInfo")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView")
    private SelenideElement verificationStatus;

    @AndroidFindBy(xpath = "//*[@text='CLOSE']")
    @iOSXCUITFindBy(accessibility = "CLOSE")
    private SelenideElement closeBtn;

    public WalletPage checkStatus ()
    {
        String actualStatus = verificationStatus.shouldBe(Condition.visible).getText();
        assertThat(actualStatus).as("Verification in progress").isEqualTo("Verification in progress");
        closeBtn.shouldBe(Condition.visible);
        closeBtn.click();
        return screen(WalletPage.class);
    }

}


