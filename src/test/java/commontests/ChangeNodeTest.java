package commontests;

import infrastructure.CoreTestCase;
import org.testng.annotations.Test;
import pages.MorePage;
import pages.NodesPage;
import pages.WalletPage;
import pages.account.AccountsPage;
import pages.account.LoginAndSecurityPage;
import pages.account.PinCodePage;

public class ChangeNodeTest extends CoreTestCase {

    @Test
    public void changeDefaultNodeTest() {
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        NodesPage nodesPage = morePage.goToNodesPage();
        nodesPage.switchToDefaultNode();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCode();
    }
}
