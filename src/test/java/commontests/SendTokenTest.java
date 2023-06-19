package commontests;


import infrastructure.CoreTestCase;
import infrastructure.Random;
import org.testng.annotations.Test;
import pages.ActivityPage;
import pages.MorePage;
import pages.WalletPage;
import pages.account.AccountsPage;
import pages.account.LiquidAssetsPage;
import pages.account.PinCodePage;
public class SendTokenTest extends CoreTestCase {

    Random rnd = new Random();
    String randomValue = rnd.RandomValue();

    @Test
    public void sendTokenTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase();
        LiquidAssetsPage liquidAssetsPage = walletPage.goToLiquidAssets();
        liquidAssetsPage.sendToken(randomValue);
        ActivityPage activityPage = walletPage.goToActivityPage();
        activityPage.checkLastTransactionSendToken(randomValue);
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCode();
    }
}
