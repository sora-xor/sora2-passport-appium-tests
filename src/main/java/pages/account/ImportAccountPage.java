package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;
import static infrastructure.Platform.isIOS;
import static infrastructure.Platform.isAndroid;


import static com.codeborne.selenide.appium.ScreenObject.screen;
@Log4j2
public class ImportAccountPage {

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SORA Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextView")
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.widget.EditText")
    private SelenideElement mnemonicInput;
	
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SORA Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextView")
    private SelenideElement rawSeedInput;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SORA Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
	@AndroidFindBy(xpath = "//*[@text='CONTINUE']")
    private SelenideElement nextBtn;

    public NameYourAccountPage enterMnemonicPhrase(String mnemonic) {


        log.info("Enter Mnemonic Phrase " + mnemonic );

        	mnemonicInput.shouldBe(Condition.visible).sendKeys(mnemonic);
        	nextBtn.shouldBe(Condition.visible).click();

        
        return screen(NameYourAccountPage.class);
    }
    public NameYourAccountPage enterRawSeed (String rawseed) {

        log.info("Enter Rawseed" + rawseed);
        
        if (isAndroid()) {
            mnemonicInput.shouldBe(Condition.visible).sendKeys(rawseed);
            nextBtn.shouldBe(Condition.visible).click();
        }
        if (isIOS()) {
            rawSeedInput.shouldBe(Condition.enabled).sendKeys(rawseed);
            nextBtn.shouldBe(Condition.visible).click();
        }

        return screen(NameYourAccountPage.class);
    }

}





