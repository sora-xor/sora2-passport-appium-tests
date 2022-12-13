package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.*;
import pages.account.AccountOptionsPage;
import pages.account.PinCodePage;

import static com.codeborne.selenide.appium.ScreenObject.screen;


@Log4j2
public class ForgetAccountTest extends CoreTestCase {
//    WalletPage walletPage;
//    @BeforeClass
//    public void createAccount() {
//        WelcomePage welcomePage = screen(WelcomePage.class);
//        CreateAccountPage createAccountPage = welcomePage.goToCreateAccountPage();
//        PinCodePage pinCodePage = createAccountPage.enterAccountName((TestConfig.config.mnemonic()));
//        WalletPage walletPage = pinCodePage.enterAndConfirmPinCode();
//        walletPage.walletPageIsOpen();
//    }

//    @Test
//    public void ForgetAccountTest() {
//
//        WelcomePage welcomePage = screen(WelcomePage.class);
//        CreateAccountPage createAccountPage = welcomePage.goToCreateAccountPage();
//    //    PinCodePage pinCodePage = createAccountPage.enterAccountName((TestConfig.config.mnemonic()));
//        WalletPage walletPage = pinCodePage.enterAndConfirmPinCode();
//        walletPage.walletPageIsOpen();
//        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
//        AccountOptionsPage forgetAccountTest = morePage.goToAccounts();
//    //    forgetAccountTest
//    }
}
