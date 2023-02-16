package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import org.testng.annotations.Test;
import pages.BuyXorPage;
import pages.MorePage;
import pages.PolkaswapPage;
import pages.WalletPage;
import pages.account.AccountsPage;
import pages.account.NameYourAccountPage;
import pages.account.PinCodePage;

public class BuyXorWithFiatTest extends CoreTestCase {
    @Test
    public void BuyXorWithFiat () {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase();
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        BuyXorPage buyXorPage = morePage.goToBuyXorWithFiat();
        buyXorPage.CompleteFormToBuyXor();
        buyXorPage.enterEmail(TestConfig.config.email());
        buyXorPage.emailVerificationRequired();

    }
}
