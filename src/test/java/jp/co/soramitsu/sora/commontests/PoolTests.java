package jp.co.soramitsu.sora.commontests;

import jp.co.soramitsu.sora.configs.TestConfig;
import jp.co.soramitsu.sora.infrastructure.CoreTestCase;
import jp.co.soramitsu.sora.infrastructure.Random;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import jp.co.soramitsu.sora.pages.ActivityPage;
import jp.co.soramitsu.sora.pages.ExplorePage;
import jp.co.soramitsu.sora.pages.MorePage;
import jp.co.soramitsu.sora.pages.WalletPage;
import jp.co.soramitsu.sora.pages.account.AccountsPage;
import jp.co.soramitsu.sora.pages.account.PinCodePage;

@Log4j2
@Feature("Pool")
public class PoolTests extends CoreTestCase {

    Random rnd = new Random();
    String randomLiquidity = rnd.RandomValue();

    //todo:add balance checking/ this test often fails because xst is not enough
    @Test
    @TmsLink("SORA-255")
    public void addLiquidityTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic1());
        //ios crushes here
        ExplorePage explorePage = walletPage.getNavigationBarSection().goToExplorePage();
        explorePage.explorePolkaswapPools();
        explorePage.addLiquidity(randomLiquidity);
        ActivityPage activityPage = walletPage.getNavigationBarSection().goToActivityPage();
        activityPage.checkLastTransactionStatusPool(randomLiquidity);
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }
}
