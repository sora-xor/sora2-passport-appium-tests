package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import infrastructure.Random;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.*;
import pages.account.AccountsPage;
import pages.account.PinCodePage;

@Log4j2
public class SwapTest  extends CoreTestCase {

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
