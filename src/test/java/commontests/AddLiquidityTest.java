package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import infrastructure.Random;
import org.testng.annotations.Test;
import pages.ActivityPage;
import pages.ExplorePage;
import pages.MorePage;
import pages.WalletPage;
import pages.account.AccountsPage;
import pages.account.PinCodePage;

public class AddLiquidityTest extends CoreTestCase {

    Random rnd = new Random();
    String randomLiquidity = rnd.RandomValue();

    @Test
    public void addLiquidityTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic1());
        ExplorePage explorePage = walletPage.getNavigationBarSection().goToExplorePage();
        explorePage.explorePolkaswapPools();
        explorePage.addLiquidity(randomLiquidity);
        ActivityPage activityPage = walletPage.goToActivityPage();
        activityPage.checkLastTransactionStatusPool(randomLiquidity);
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCode();

    }
}
