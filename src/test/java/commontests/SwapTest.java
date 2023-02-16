package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import org.testng.annotations.Test;
import pages.MorePage;
import pages.PolkaswapPage;
import pages.WalletPage;
import pages.WelcomePage;
import pages.account.ImportAccountPage;
import pages.account.NameYourAccountPage;
import pages.account.PinCodePage;

import static com.codeborne.selenide.appium.ScreenObject.screen;

public class SwapTest  extends CoreTestCase {

    @Test
    public void importAccountAndSwap() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase();
        PolkaswapPage polkaswapPage =  walletPage.goToPolkaswapPage();
        polkaswapPage.PolkaswapPageIsOpen();
    }
}
