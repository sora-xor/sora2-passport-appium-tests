package commontests;

import infrastructure.CoreTestCase;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.*;
import pages.account.*;

import static com.codeborne.selenide.appium.ScreenObject.screen;


@Log4j2
public class СreateAndForgetAccountTest extends CoreTestCase {

    @Test
    public void СreateAndForgetAccountTest() {

        WelcomePage welcomePage = screen(WelcomePage.class);
        NameYourAccountPage nameYourAccountPage = welcomePage.goToCreateAccountPage();
        PayAttentionPage payAttention = nameYourAccountPage.enterAccountName("Account Test");
        PassphrasePage passphrasePage = payAttention.confirmPayAttention();
        PinCodePage pinCodePage = passphrasePage.skipPassPhrase();
        WalletPage walletPage = pinCodePage.enterAndConfirmPinCode();
        walletPage.walletPageIsOpen();
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage pinCodePage1 = accountsPage.forgetAccount();
        pinCodePage1.enterPinCode();
    }
}
