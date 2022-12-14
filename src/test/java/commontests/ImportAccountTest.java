package commontests;

import com.codeborne.selenide.Config;
import configs.TestConfig;
import infrastructure.CoreTestCase;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.*;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@Log4j2
public class ImportAccountTest extends CoreTestCase {


    @Test
    public void importAccountTest (){
        WelcomePage welcomePage = screen(WelcomePage.class);
        ImportAccountPage importAccountPage = welcomePage.goToImportAccountPage();

        PinCodePage pinCodePage = importAccountPage.enterMnemonicPhrase(TestConfig.config.mnemonic());
        WalletPage walletPage = pinCodePage.enterAndConfirmPinCode();
        walletPage.walletPageIsOpen();
    }
}
