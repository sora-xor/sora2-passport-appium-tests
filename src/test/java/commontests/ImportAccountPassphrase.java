package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.*;
import pages.account.*;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@Log4j2
public class ImportAccountPassphrase extends CoreTestCase {


    @Test
    public void importAccountPassphrase (){
        WelcomePage welcomePage = screen(WelcomePage.class);
        ImportAccountPage importAccountPage = welcomePage.goToImportAccountPagePassphrase();
        NameYourAccountPage nameYourAccountPage = importAccountPage.enterMnemonicPhrase(TestConfig.config.mnemonic());
        PinCodePage pinCodePage = nameYourAccountPage.enterAccountNameAfterImport("Import Passphrase");
        WalletPage walletPage = pinCodePage.enterAndConfirmPinCode();
        walletPage.walletPageIsOpen();
    }
}
