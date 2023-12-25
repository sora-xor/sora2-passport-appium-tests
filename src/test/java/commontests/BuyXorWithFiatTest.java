package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import org.testng.annotations.Test;
import pages.BuyXorPage;
import pages.MorePage;
import pages.WalletPage;

public class BuyXorWithFiatTest extends CoreTestCase {
    @Test
    public void buyXorWithFiat () {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic1());
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        BuyXorPage buyXorPage = morePage.goToBuyXorWithFiat();
        buyXorPage.CompleteFormToBuyXor();
        buyXorPage.enterEmail(TestConfig.config.email());
        buyXorPage.emailVerificationRequired();
    }
}
