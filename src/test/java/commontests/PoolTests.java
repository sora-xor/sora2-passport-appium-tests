package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import infrastructure.Random;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.ActivityPage;
import pages.ExplorePage;
import pages.MorePage;
import pages.WalletPage;
import pages.account.AccountsPage;
import pages.account.PinCodePage;

@Log4j2
@Feature("Pool")
public class PoolTests extends CoreTestCase {

    Random rnd = new Random();
    String randomLiquidity = rnd.RandomValue();

    @Test
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