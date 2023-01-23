package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;
import static infrastructure.Platform.isIOS;
import static infrastructure.Platform.isAndroid;


import static com.codeborne.selenide.appium.ScreenObject.screen;
@Log4j2
public class ImportAccountPage {

	@iOSXCUITFindBy(accessibility = "Mnemonic passphrase")
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.widget.EditText")
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

	@iOSXCUITFindBy(accessibility = "CONTINUE") // //XCUIElementTypeButton[@name="CONTINUE"]
	@AndroidFindBy(xpath = "//*[@text='CONTINUE']")
    private SelenideElement nextBtn;

    public NameYourAccountPage enterMnemonicPhrase(String mnemonic) {

        log.info("Enter Mnemonic Phrase " + mnemonic );
        if (isAndroid()) {
        	mnemonicInput.shouldBe(Condition.visible).sendKeys(mnemonic);
        	nextBtn.shouldBe(Condition.visible).click();
        }
        else if (isIOS()) { //in IOS the input is invisible
        	mnemonicInput.sendKeys(mnemonic);
        	accountNameField.click();
        	accountNameField.sendKeys("Import Account");
        	topOfScreen.click();
        	nextBtn.should(Condition.attribute("accessible", "true")).click();

        }
        
        return screen(NameYourAccountPage.class);
    }
    public NameYourAccountPage enterRawSeed (String rawseed) {

        log.info("Enter Rawseed" + rawseed);
        
        if (isAndroid()) {
            mnemonicInput.shouldBe(Condition.visible).sendKeys(rawseed);
            nextBtn.shouldBe(Condition.visible).click();
        }
        if (isIOS()) {
        
        	sourceTypeSelector.shouldBe(Condition.visible).click();
        	rawSeedSelectorElement.shouldBe(Condition.visible).click();
        	rawSeedAlertOkBtn.shouldBe(Condition.visible).click();
        	rawSeedInput.shouldBe(Condition.enabled).sendKeys(rawseed);
        	accountNameField.click();
        	accountNameField.sendKeys("Import Account");
        	topOfScreen.click();
        	nextBtn.should(Condition.attribute("accessible", "true")).click();
        }

        return screen(NameYourAccountPage.class);
    }

}





