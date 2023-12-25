package commontests;

import infrastructure.CoreTestCase;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.MorePage;
import pages.WalletPage;
import pages.account.AccountsPage;
import pages.account.PinCodePage;

@Log4j2
public class ChangeAccountNameTest extends CoreTestCase {

    @Test
    @Feature("Settings")
    @TmsLink("SORA-263")
    public void changeAccountNameTest(){
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        accountsPage.changeAccountName();
        accountsPage.returnToAccountsPage();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }
}
