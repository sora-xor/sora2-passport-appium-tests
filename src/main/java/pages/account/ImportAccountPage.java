package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;
import static com.codeborne.selenide.appium.ScreenObject.screen;


@Log4j2
public class ImportAccountPage {

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SORA Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextView")
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.widget.EditText")
    private SelenideElement mnemonicInput;
	
	@iOSXCUITFindBy(accessibility = "Raw Seed (64 hex symbols)")
	private SelenideElement rawSeedInput;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SORA Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
	@AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/accountNameEt")
    private SelenideElement accountNameField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SORA Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]")
    private SelenideElement topOfScreen;
	
	@iOSXCUITFindBy(accessibility = "Account name")
    private SelenideElement accountNameInput;
	
	@iOSXCUITFindBy(accessibility = "Choose source type")
    private SelenideElement sourceTypeSelector;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Raw seed \"]")
    private SelenideElement rawSeedSelectorElement;
	
	@iOSXCUITFindBy(accessibility = "OK")
    private SelenideElement rawSeedAlertOkBtn;
	
	@iOSXCUITFindBy(accessibility = "Done")
    private SelenideElement DoneBtn;

	@iOSXCUITFindBy(accessibility = "Continue")
	@AndroidFindBy(xpath = "//*[@text='Continue']")
    private SelenideElement nextBtn;

    public NameYourAccountPage enterMnemonicPhrase(String mnemonic) {

        log.info("Enter Mnemonic Phrase" + mnemonic );
        mnemonicInput.shouldBe(Condition.visible).sendKeys(mnemonic);
        nextBtn.shouldBe(Condition.visible).click();
        return screen(NameYourAccountPage.class);
    }
    public NameYourAccountPage enterRawSeed (String rawseed) {

        log.info("Enter Rawseed" + rawseed);
        mnemonicInput.shouldBe(Condition.visible).sendKeys(rawseed);
        nextBtn.shouldBe(Condition.visible).click();
        return screen(NameYourAccountPage.class);
    }

}





