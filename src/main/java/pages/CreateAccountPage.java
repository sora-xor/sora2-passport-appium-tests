package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CreateAccountPage {

    @AndroidFindBy(id = "jp.co.soramitsu.sora:id/accountNameEt")
    private SelenideElement accountNameField;

    // @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Next\"]")
    @AndroidFindBy(id = "jp.co.soramitsu.sora:id/nextBtn")
    private SelenideElement nextBtn;

    @AndroidFindBy(xpath = "//*[@text='OK']")
    private SelenideElement doNotTakeScreenshotsBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/tvPassphraseWords1")
    private SelenideElement tvPassphraseWords1;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/tvPassphraseWords2")
    private SelenideElement tvPassphraseWords2;

    public void getWords(){
        String passphraseWords1 = tvPassphraseWords1.getText();
        String passphraseWords2 = tvPassphraseWords2.getText();

    }

    public void enterAccountName (String mnemonic) {

        log.info("Enter Account Name " + mnemonic );
        accountNameField.shouldBe(Condition.visible).sendKeys("AccountTest");
        nextBtn.shouldBe(Condition.visible).click();
        doNotTakeScreenshotsBtn.shouldBe(Condition.visible).click();


    }

}
