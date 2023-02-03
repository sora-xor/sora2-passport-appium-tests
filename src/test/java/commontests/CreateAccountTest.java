package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.*;
import pages.account.NameYourAccountPage;
import pages.account.PassphrasePage;
import pages.account.PayAttentionPage;
import pages.account.PinCodePage;

import java.net.PasswordAuthentication;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@Log4j2
public class CreateAccountTest extends CoreTestCase {

    @Test
    public void enterAccountName (){
        WelcomePage welcomePage = screen(WelcomePage.class);
        NameYourAccountPage nameYourAccountPage = welcomePage.goToCreateAccountPage();
        PayAttentionPage payAttention = nameYourAccountPage.enterAccountName("Account Test");
        PassphrasePage passphrasePage = payAttention.confirmPayAttention();
        PinCodePage pinCodePage = passphrasePage.skipPassPhrase();
        WalletPage walletPage = pinCodePage.enterAndConfirmPinCode();
        walletPage.walletPageIsOpen();

    }
}
