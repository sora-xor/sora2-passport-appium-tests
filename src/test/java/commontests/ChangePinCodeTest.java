package commontests;

import infrastructure.CoreTestCase;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.*;
import pages.account.*;

import static com.codeborne.selenide.appium.ScreenObject.screen;


@Log4j2
public class ChangePinCodeTest extends CoreTestCase {

    @Test
    public void changePinCodeTest() {
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        LoginAndSecurityPage loginAndSecurityPage = morePage.goToLoginAndSecurity();
        PinCodePage pinCodePage = loginAndSecurityPage.goToChangePin();
        pinCodePage.changeAndConfirmChangePinCode();
        MorePage morePage1 = loginAndSecurityPage.checkToastPinCodeChanged();
        AccountsPage accountsPage = morePage1.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCode();
    }
}
