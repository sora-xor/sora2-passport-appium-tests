package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.codeborne.selenide.appium.ScreenObject.screen;
public class NameYourAccountPage {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.widget.EditText")
    private SelenideElement accountNameField;

    @AndroidFindBy(xpath = "//*[@text='CONTINUE']")
    private SelenideElement nextBtn;


    public PayAttentionPage enterAccountName (String accountName) {
        accountNameField.shouldBe(Condition.visible).sendKeys("Create Account");
        nextBtn.shouldBe(Condition.visible).click();
        return screen(PayAttentionPage.class);
    }

    public PinCodePage enterAccountNameAfterImport (String accountName) {
        accountNameField.shouldBe(Condition.visible).sendKeys("Import Account");
        nextBtn.shouldBe(Condition.visible).click();
        return screen(PinCodePage.class);
    }
}
