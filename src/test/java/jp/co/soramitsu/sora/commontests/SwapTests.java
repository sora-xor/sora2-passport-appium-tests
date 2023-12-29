package jp.co.soramitsu.sora.commontests;

import jp.co.soramitsu.sora.configs.TestConfig;
import jp.co.soramitsu.sora.infrastructure.CoreTestCase;
import jp.co.soramitsu.sora.infrastructure.Random;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import jp.co.soramitsu.sora.pages.ActivityPage;
import jp.co.soramitsu.sora.pages.MorePage;
import jp.co.soramitsu.sora.pages.PolkaswapPage;
import jp.co.soramitsu.sora.pages.WalletPage;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import jp.co.soramitsu.sora.pages.account.AccountsPage;
import jp.co.soramitsu.sora.pages.account.PinCodePage;

@Log4j2
public class SwapTests extends CoreTestCase {

    Random rnd = new Random();
    String randomValue = rnd.RandomValue();
    @Test
    @Feature("Swap")
    @TmsLink("SORA-242")
    public void swapTest () {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic1());
        PolkaswapPage polkaswapPage = walletPage.getNavigationBarSection().goToPolkaswapPage();
        polkaswapPage.checkAndCloseDisclaimer();
        polkaswapPage.polkaswapSelectToken();
        polkaswapPage.simpleSwap(randomValue);
        ActivityPage activityPage = walletPage.getNavigationBarSection().goToActivityPage();
        activityPage.checkLastTransactionStatusSwap(randomValue);
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }

}
