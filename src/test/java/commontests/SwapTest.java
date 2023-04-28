package commontests;

import com.codeborne.selenide.Condition;
import configs.TestConfig;
import infrastructure.CoreTestCase;
import infrastructure.Random;
import org.testng.annotations.Test;
import pages.*;
import pages.account.AccountsPage;
import pages.account.ImportAccountPage;
import pages.account.NameYourAccountPage;
import pages.account.PinCodePage;


import static com.codeborne.selenide.appium.ScreenObject.screen;

public class SwapTest  extends CoreTestCase {

    Random rnd = new Random();
    String randomValue = rnd.RandomValue();
    @Test
    public void swapTest () {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase();
        PolkaswapPage polkaswapPage =  walletPage.goToPolkaswapPage();
        polkaswapPage.PolkaswapPageIsOpen();
        polkaswapPage.PolkaswapSelectToken();
        polkaswapPage.SimpleSwap(randomValue);
        ActivityPage activityPage = walletPage.goToActivityPage();
        activityPage.CheckLastTransactionStatus(randomValue);
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCode();
    }

}
