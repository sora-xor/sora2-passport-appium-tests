package jp.co.soramitsu.sora.qa.pages.onboarding;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.ScreenObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import jp.co.soramitsu.sora.qa.pages.onboarding.NameYourAccountPage;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ImportAccountPage {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.widget.EditText")
    private SelenideElement mnemonicInput;

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

    @AndroidFindBy(xpath = "//*[@text='Enter your secret Raw Seed']")
    @iOSXCUITFindBy(accessibility = "Enter your secret Raw Seed")
    private SelenideElement enterRawSeedTitle;

    @AndroidFindBy(xpath = "//*[@text='Enter your secret Passphrase']")
    @iOSXCUITFindBy(accessibility = "Enter your secret Passphrase")
    private SelenideElement enterPassphraseTitle;


    @Step
    public NameYourAccountPage enterMnemonicPhrase(String mnemonic) {

        enterPassphraseTitle.shouldBe(Condition.visible);
        log.info("Enter Mnemonic Phrase: " + mnemonic);
        mnemonicInput.shouldBe(Condition.visible).sendKeys(mnemonic);
        nextBtn.shouldBe(Condition.visible).click();
        return ScreenObject.screen(NameYourAccountPage.class);
    }

    @Step
    public NameYourAccountPage enterRawSeed(String rawseed) {

        enterRawSeedTitle.shouldBe(Condition.visible);
        log.info("Enter Rawseed" + rawseed);
        mnemonicInput.shouldBe(Condition.visible).sendKeys(rawseed);
        nextBtn.shouldBe(Condition.visible).click();
        return ScreenObject.screen(NameYourAccountPage.class);
    }
}





