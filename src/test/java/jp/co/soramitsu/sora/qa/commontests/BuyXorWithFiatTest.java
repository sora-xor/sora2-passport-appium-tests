package jp.co.soramitsu.sora.qa.commontests;

import jp.co.soramitsu.sora.qa.configs.TestConfig;
import jp.co.soramitsu.sora.qa.infrastructure.CoreTestCase;
import org.testng.annotations.Test;
import jp.co.soramitsu.sora.qa.pages.BuyXorPage;
import jp.co.soramitsu.sora.qa.pages.MorePage;
import jp.co.soramitsu.sora.qa.pages.WalletPage;

public class BuyXorWithFiatTest extends CoreTestCase {
    //is this test still actual?
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
