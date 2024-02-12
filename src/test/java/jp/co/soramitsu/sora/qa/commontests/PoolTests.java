package jp.co.soramitsu.sora.qa.commontests;

import jp.co.soramitsu.sora.qa.configs.TestConfig;
import jp.co.soramitsu.sora.qa.infrastructure.CoreTestCase;
import jp.co.soramitsu.sora.qa.infrastructure.Random;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import jp.co.soramitsu.sora.qa.pages.ActivityPage;
import jp.co.soramitsu.sora.qa.pages.ExplorePage;
import jp.co.soramitsu.sora.qa.pages.MorePage;
import jp.co.soramitsu.sora.qa.pages.WalletPage;
import jp.co.soramitsu.sora.qa.pages.account.AccountsPage;
import jp.co.soramitsu.sora.qa.pages.onboarding.PinCodePage;

@Log4j2
@Feature("Pool")
public class PoolTests extends CoreTestCase {

    Random rnd = new Random();
    String randomLiquidity = rnd.RandomValue();

    //random liquidity caused fails when xst had not enough balance
    @Test
    @TmsLink("SORA-255")
    public void addLiquidityTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic1());
        ExplorePage explorePage = walletPage.getNavigationBarSection().goToExplorePage();
        explorePage.clickPoolsButton();
        explorePage.addLiquidity("1");
        ActivityPage activityPage = walletPage.getNavigationBarSection().goToActivityPage();
        activityPage.checkLastTransactionStatusPool("1");
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }
}
