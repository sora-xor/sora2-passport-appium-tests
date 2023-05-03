package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import configs.TestConfig;
import infrastructure.Utils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import pages.account.*;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static org.assertj.core.api.Assertions.*;

@Log4j2
public class WalletPage extends CommonPage {

    Utils utils = new Utils();

    @AndroidFindBy(xpath = "//*[@text='Liquid assets']")
    @iOSXCUITFindBy(accessibility = "Liquid assets")
    private SelenideElement liquidAssets;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/GetSoraCard")
    @iOSXCUITFindBy(accessibility = "GetSoraCardBtn")
    private SelenideElement getSoraCardBtn;
    
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/title")
    private SelenideElement walletTitlePage;

    @AndroidFindBy(id = "jp.co.soramitsu.develop.sora.develop:id/tvEmptyHistoryTitle")
    private SelenideElement emptyHistoryTitle;

    public static WalletPage importAccountUsePassphrase() {
        WelcomePage welcomePage = screen(WelcomePage.class);
        ImportAccountPage importAccountPage = welcomePage.goToImportAccountPagePassphrase();
        NameYourAccountPage nameYourAccountPage = importAccountPage.enterMnemonicPhrase(TestConfig.config.mnemonic1());
        PinCodePage pinCodePage = nameYourAccountPage.enterAccountNameAfterImport("Import Passphrase");
        WalletPage walletPage = pinCodePage.enterAndConfirmPinCode();
        walletPage.walletPageIsOpen();
        return screen(WalletPage.class);
    }
    
    public static WalletPage importAccountUseRawSeed() {
        WelcomePage welcomePage = screen(WelcomePage.class);
        ImportAccountPage importAccountPage = welcomePage.goToImportAccountPageRawSeed();
        NameYourAccountPage nameYourAccountPage = importAccountPage.enterRawSeed(TestConfig.config.rawseed());
        PinCodePage pinCodePage = nameYourAccountPage.enterAccountNameAfterImport("Import RawSeed");
        WalletPage walletPage = pinCodePage.enterAndConfirmPinCode();
        walletPage.walletPageIsOpen();
        return screen(WalletPage.class);
    }

    public static WalletPage createNewAccount(){
        WelcomePage welcomePage = screen(WelcomePage.class);
        NameYourAccountPage nameYourAccountPage = welcomePage.goToCreateAccountPage();
        PayAttentionPage payAttention = nameYourAccountPage.enterAccountName("Account Test");
        PassphrasePage passphrasePage = payAttention.confirmPayAttention();
        PinCodePage pinCodePage = passphrasePage.skipPassPhrase();
        WalletPage walletPage = pinCodePage.enterAndConfirmPinCodeNew();
        walletPage.walletPageIsOpen();
        return screen(WalletPage.class);
    }

    public void walletPageIsOpen (){
       String actualTitle = liquidAssets.shouldBe(Condition.visible).getText();
       assertThat(actualTitle).as("Liquid assets title").isEqualTo("Liquid assets");
    }

    public SoraCardPage goToSoraCardPage()
    {
        log.info("Click Get Sora Card button");
        getSoraCardBtn.shouldBe(Condition.visible).click();
        return screen(SoraCardPage.class);
    }

    public void goToPooledAssets()
    {
       utils.scrollForward(1);
    }

}
