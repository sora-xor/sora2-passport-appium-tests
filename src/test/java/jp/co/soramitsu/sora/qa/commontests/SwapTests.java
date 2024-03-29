package jp.co.soramitsu.sora.qa.commontests;

import jp.co.soramitsu.sora.qa.configs.TestConfig;
import jp.co.soramitsu.sora.qa.infrastructure.CoreTestCase;
import jp.co.soramitsu.sora.qa.infrastructure.Random;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import jp.co.soramitsu.sora.qa.pages.ActivityPage;
import jp.co.soramitsu.sora.qa.pages.PolkaswapPage;
import jp.co.soramitsu.sora.qa.pages.WalletPage;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class SwapTests extends CoreTestCase {

    Random rnd = new Random();
    String randomValue = rnd.RandomValue();
    @Test
    @Feature("Swap")
    @TmsLink("SORA-242")
    public void swapTest () {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic1());
        PolkaswapPage polkaswapPage = walletPage.goToPolkaswapPage();
        polkaswapPage.checkAndCloseDisclaimer();
        polkaswapPage.polkaswapSelectToken();
        polkaswapPage.simpleSwap(randomValue);
        ActivityPage activityPage = walletPage.getNavigationBarSection().goToActivityPage();
        activityPage.checkLastTransactionStatusSwap(randomValue);
    }

}
