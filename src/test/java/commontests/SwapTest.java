package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import infrastructure.Random;
import org.testng.annotations.Test;
import pages.*;
import pages.account.AccountsPage;
import pages.account.PinCodePage;

public class SwapTest  extends CoreTestCase {

    Random rnd = new Random();
    String randomValue = rnd.RandomValue();
    @Test
    public void swapTest () {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic1());
        PolkaswapPage polkaswapPage = walletPage.getNavigationBarSection().goToPolkaswapPage();
        polkaswapPage.PolkaswapPageIsOpen();
        polkaswapPage.PolkaswapSelectToken();
        polkaswapPage.SimpleSwap(randomValue);
        ActivityPage activityPage = walletPage.getNavigationBarSection().goToActivityPage();
        activityPage.checkLastTransactionStatusSwap(randomValue);
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }

}
