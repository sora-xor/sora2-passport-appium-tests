package jp.co.soramitsu.sora.qa.commontests;

import jp.co.soramitsu.sora.qa.infrastructure.CoreTestCase;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import jp.co.soramitsu.sora.qa.pages.MorePage;
import jp.co.soramitsu.sora.qa.pages.NodesPage;
import jp.co.soramitsu.sora.qa.pages.WalletPage;
import jp.co.soramitsu.sora.qa.pages.account.AccountsPage;
import jp.co.soramitsu.sora.qa.pages.account.PinCodePage;

@Log4j2
@Feature("Select node")
public class NodeTests extends CoreTestCase {
    @Test
    @TmsLink("SORA-334")
    public void addExistingCustomNodeTest() {
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        NodesPage nodesPage = morePage.goToNodesPage();
        nodesPage.addExistingCustomNode();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }

    @Test
    @TmsLink("SORA-328")
    @Issue("wrong flow on ios")
    public void changeDefaultNodeTest() {
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        NodesPage nodesPage = morePage.goToNodesPage();
        morePage = nodesPage.switchToDefaultNode();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }
}
