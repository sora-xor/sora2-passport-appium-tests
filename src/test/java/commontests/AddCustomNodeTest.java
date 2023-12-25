package commontests;

import infrastructure.CoreTestCase;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.MorePage;
import pages.NodesPage;
import pages.WalletPage;
import pages.account.AccountsPage;
import pages.account.PinCodePage;

@Log4j2
public class AddCustomNodeTest extends CoreTestCase {
    @Test
    @Feature("Select node")
    @TmsLink("SORA-332")
    @Issue("an issue with iOS")
    public void addCustomNodeTest() {
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        NodesPage nodesPage = morePage.goToNodesPage();
        nodesPage.addCustomNode();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }
}
