package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import configs.TestConfig;
import infrastructure.Utils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;
import pages.account.*;

import static com.codeborne.selenide.appium.AppiumScrollOptions.down;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static infrastructure.Platform.isAndroid;
import static infrastructure.Platform.isIOS;

@Log4j2
public class WalletPage extends CommonPage {

    Utils utils = new Utils();

    @AndroidFindBy(accessibility = "Wallet")
    @iOSXCUITFindBy(accessibility = "TabBar/wallet")
    private SelenideElement walletTab;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/GetSoraCard")
    @iOSXCUITFindBy(accessibility = "Get SORA Card")
    private SelenideElement getSoraCardBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/title")
    private SelenideElement walletTitlePage;

    @AndroidFindBy(id = "jp.co.soramitsu.develop.sora.develop:id/tvEmptyHistoryTitle")
    private SelenideElement emptyHistoryTitle;

    @AndroidFindBy(id ="jp.co.soramitsu.sora.develop:id/CardInfo")
    private SelenideElement soraCardInfo;

    public static WalletPage importAccountUsePassphrase(String mnemonic) {
        WelcomePage welcomePage = screen(WelcomePage.class);
        ImportAccountPage importAccountPage = welcomePage.goToImportAccountPagePassphrase();
        NameYourAccountPage nameYourAccountPage = importAccountPage.enterMnemonicPhrase(mnemonic);
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

    public static WalletPage createNewAccount() {
        WelcomePage welcomePage = screen(WelcomePage.class);
        NameYourAccountPage nameYourAccountPage = welcomePage.goToCreateAccountPage();
        PayAttentionPage payAttention = nameYourAccountPage.enterAccountName("Account Test");
        PassphrasePage passphrasePage = payAttention.confirmPayAttention();
        PinCodePage pinCodePage = passphrasePage.skipPassPhrase();
        WalletPage walletPage = pinCodePage.enterAndConfirmPinCodeNew();
        walletPage.walletPageIsOpen();
        return screen(WalletPage.class);
    }

    public void walletPageIsOpen() {
        if (isAndroid()) {
            walletTab.shouldBe(Condition.selected);
            log.info("Wallet tab is selected: "+walletTab.shouldBe(Condition.selected).getAttribute("selected"));
        }
        if (isIOS()) {
            walletTab.shouldBe(Condition.visible);
            log.info("Wallet tab is selected: "+walletTab.shouldBe(Condition.visible).getAttribute("visible"));

        }
    }

    public SoraCardPage goToSoraCardPage() {
        log.info("Click Get Sora Card button");
        getSoraCardBtn.shouldBe(Condition.visible).click();
        return screen(SoraCardPage.class);
    }

    public LiquidAssetsPage goToLiquidAssets() {
//        if (isAndroid()) utils.scrollForward(1);
//        if (isIOS()) {
//            SelenideAppium.$x("(//XCUIElementTypeStaticText[@name=\"Expand\"])[2]")
//                    .scroll(down())
//                    .shouldHave(visible);
//        }
        return screen(LiquidAssetsPage.class);
    }

    public SoraCardDetailsPage goToSoraCardInfo ()
    {
        soraCardInfo.shouldBe(Condition.visible).click();
        return screen(SoraCardDetailsPage.class);
    }
}




