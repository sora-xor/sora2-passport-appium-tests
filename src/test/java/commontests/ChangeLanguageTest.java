package commontests;

import infrastructure.CoreTestCase;
import org.testng.annotations.Test;
import pages.AppSettingsPage;
import pages.MorePage;
import pages.NodesPage;
import pages.WalletPage;
import pages.account.AccountsPage;
import pages.account.PinCodePage;

public class ChangeLanguageTest extends CoreTestCase {
    @Test
    public void changeLanguageTest() {
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        AppSettingsPage appSettingsPage = morePage.goToAppSettingsPage();
        appSettingsPage.switchToSpanish();
        appSettingsPage.switchToEnglish();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCode();
    }
}
