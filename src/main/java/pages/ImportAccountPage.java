package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.appium.ScreenObject.screen;
@Log4j2
public class ImportAccountPage {

    @AndroidFindBy(id = "jp.co.soramitsu.sora:id/mnemonicInput")
    private SelenideElement mnemonicInput;


    @AndroidFindBy(id = "jp.co.soramitsu.sora:id/accountNameEt")
    private SelenideElement accountNameField;

    @AndroidFindBy(id = "jp.co.soramitsu.sora:id/nextBtn")
    private SelenideElement nextBtn;


    public PinCodePage enterMnemonicPhrase(String mnemonic) {

        log.info("Enter Mnemonic Phrase " + mnemonic );

        mnemonicInput.shouldBe(Condition.visible).sendKeys(mnemonic);
        nextBtn.shouldBe(Condition.visible).click();
        return screen(PinCodePage.class);
    }
}





