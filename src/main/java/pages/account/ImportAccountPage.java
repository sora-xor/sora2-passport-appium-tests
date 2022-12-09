package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.appium.ScreenObject.screen;
@Log4j2
public class ImportAccountPage {


 //   @AndroidFindBy(xpath = "//*[text()='Account name']")
 //   private SelenideElement accountNameField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.widget.EditText")
    private SelenideElement mnemonicInput;



    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/accountNameEt")
    private SelenideElement accountNameField;


    @AndroidFindBy(xpath = "//*[@text='CONTINUE']")
    private SelenideElement nextBtn;


    public NameYourAccountPage enterMnemonicPhrase(String mnemonic) {

        log.info("Enter Mnemonic Phrase " + mnemonic );

        mnemonicInput.shouldBe(Condition.visible).sendKeys(mnemonic);
        nextBtn.shouldBe(Condition.visible).click();
        return screen(NameYourAccountPage.class);
    }
//    public NameYourAccountPage enterRawSeed(String rawseed) {
//
//        log.info("Enter Mnemonic Phrase " + mnemonic );
//
//        mnemonicInput.shouldBe(Condition.visible).sendKeys(mnemonic);
//        nextBtn.shouldBe(Condition.visible).click();
//        return screen(PinCodePage.class);
//    }

}





