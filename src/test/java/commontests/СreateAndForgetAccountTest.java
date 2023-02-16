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

        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage pinCodePage = accountsPage.forgetAccount();
        pinCodePage.enterPinCode();
    }
}
