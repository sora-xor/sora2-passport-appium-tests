package jp.co.soramitsu.sora.qa.commontests;

import jp.co.soramitsu.sora.qa.configs.TestConfig;
import jp.co.soramitsu.sora.qa.infrastructure.CoreTestCase;
import jp.co.soramitsu.sora.qa.infrastructure.Random;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import jp.co.soramitsu.sora.qa.pages.ActivityPage;
import jp.co.soramitsu.sora.qa.pages.MorePage;
import jp.co.soramitsu.sora.qa.pages.WalletPage;
import jp.co.soramitsu.sora.qa.pages.account.LiquidAssetsPage;

@Log4j2
public class SendTokenTests extends CoreTestCase {

    Random rnd = new Random();
    String randomValue = rnd.RandomValue();

    @Test
    public void sendTokenTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic1());
        LiquidAssetsPage liquidAssetsPage = walletPage.goToLiquidAssets();
        ActivityPage activityPage = liquidAssetsPage.sendToken(randomValue);
        walletPage = activityPage.checkSendTransaction();
        activityPage = walletPage.getNavigationBarSection().goToActivityPage();
        activityPage.checkLastTransactionSendToken(randomValue);
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
    }
}
