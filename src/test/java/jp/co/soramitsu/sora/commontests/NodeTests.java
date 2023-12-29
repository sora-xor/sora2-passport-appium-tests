package jp.co.soramitsu.sora.commontests;

import jp.co.soramitsu.sora.infrastructure.CoreTestCase;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import jp.co.soramitsu.sora.pages.MorePage;
import jp.co.soramitsu.sora.pages.NodesPage;
import jp.co.soramitsu.sora.pages.WalletPage;
import jp.co.soramitsu.sora.pages.account.AccountsPage;
import jp.co.soramitsu.sora.pages.account.PinCodePage;

@Log4j2
@Feature("Select node")
public class NodeTests extends CoreTestCase {
    @Test
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

    @Test
    @TmsLink("SORA-328")
    @Issue("an issue with iOS")
    public void changeDefaultNodeTest() {
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        NodesPage nodesPage = morePage.goToNodesPage();
        nodesPage.switchToDefaultNode();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }
}
