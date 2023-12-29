package jp.co.soramitsu.sora.commontests;

import jp.co.soramitsu.sora.configs.TestConfig;
import jp.co.soramitsu.sora.infrastructure.CoreTestCase;
import jp.co.soramitsu.sora.infrastructure.Random;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import jp.co.soramitsu.sora.pages.ActivityPage;
import jp.co.soramitsu.sora.pages.MorePage;
import jp.co.soramitsu.sora.pages.WalletPage;
import jp.co.soramitsu.sora.pages.account.AccountsPage;
import jp.co.soramitsu.sora.pages.account.LiquidAssetsPage;
import jp.co.soramitsu.sora.pages.account.PinCodePage;

@Log4j2
public class SendTokenTests extends CoreTestCase {

    Random rnd = new Random();
    String randomValue = rnd.RandomValue();

    @Test
    public void sendTokenTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic1());
        LiquidAssetsPage liquidAssetsPage = walletPage.goToLiquidAssets();
        liquidAssetsPage.sendToken(randomValue);
        ActivityPage activityPage = walletPage.getNavigationBarSection().goToActivityPage();
        activityPage.checkLastTransactionSendToken(randomValue);
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }
}
