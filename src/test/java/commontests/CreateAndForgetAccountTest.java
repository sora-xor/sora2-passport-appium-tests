package commontests;

import infrastructure.CoreTestCase;
import io.qameta.allure.Feature;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.*;
import pages.account.*;

@Log4j2
public class CreateAndForgetAccountTest extends CoreTestCase {

    @Test
    @Feature("Create account")
    public void createAndForgetAccountTest() {
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }
}
