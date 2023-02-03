package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.WebDriverThreadLocalContainer;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import static infrastructure.Platform.isIOS;

import org.openqa.selenium.Keys;

import static infrastructure.Platform.isAndroid;

import static com.codeborne.selenide.appium.ScreenObject.screen;
public class NameYourAccountPage {

	@iOSXCUITFindBy(accessibility = "Account name")
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.widget.EditText")
    private SelenideElement accountNameField;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CONTINUE\"]")
	@AndroidFindBy(xpath = "//*[@text='CONTINUE']")
    private SelenideElement nextBtn;
	
	@iOSXCUITFindBy(accessibility = "OK")
    private SelenideElement AlertOkBtn;
	
	@iOSXCUITFindBy(accessibility = "Done")
    private SelenideElement DoneBtn;
	



    public PayAttentionPage enterAccountName (String accountName) {
    	if (isAndroid()) {
        accountNameField.shouldBe(Condition.visible).sendKeys("Create Account");

        nextBtn.shouldBe(Condition.visible).click();
    	}
    	else if (isIOS()) {
    		accountNameField.sendKeys("Create Account");
    		DoneBtn.click();
            nextBtn.click();
        	AlertOkBtn.shouldBe(Condition.visible).click();
        }
        return screen(PayAttentionPage.class);
    }

    public PinCodePage enterAccountNameAfterImport (String accountName) {
    	if (isAndroid()) {
    		accountNameField.shouldBe(Condition.visible).sendKeys(accountName);
    		nextBtn.shouldBe(Condition.enabled).click();
    	}
        return screen(PinCodePage.class);
    }
}
