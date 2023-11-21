package commontests;

import infrastructure.CoreTestCase;
import org.testng.annotations.Test;
import pages.MorePage;
import pages.WalletPage;
import pages.account.AccountsPage;
import pages.account.PinCodePage;

public class ChangeAccountNameTest extends CoreTestCase {

    @Test
    public void changeAccountNameTest(){
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        accountsPage.changeAccountName();
        accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCode();
    }
}
