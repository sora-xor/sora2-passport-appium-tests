package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import infrastructure.Random;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
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
    @Feature("Pool")
    @TmsLink("SORA-255")
    public void addLiquidityTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic1());
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
