package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import infrastructure.Random;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.ActivityPage;
import pages.MorePage;
import pages.WalletPage;
import pages.account.AccountsPage;
import pages.account.LiquidAssetsPage;
import pages.account.PinCodePage;

@Log4j2
public class SendTokenTest extends CoreTestCase {

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
