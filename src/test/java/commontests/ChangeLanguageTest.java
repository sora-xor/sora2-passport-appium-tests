package commontests;

import infrastructure.CoreTestCase;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.AppSettingsPage;
import pages.MorePage;
import pages.WalletPage;
import pages.account.AccountsPage;
import pages.account.PinCodePage;

@Log4j2
public class ChangeLanguageTest extends CoreTestCase {
    @Test
    @Feature("Settings")
    @TmsLink("SORA-381")
    public void changeLanguageTest() {
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        AppSettingsPage appSettingsPage = morePage.goToAppSettingsPage();
        appSettingsPage.switchToSpanish();
        appSettingsPage.switchToEnglish();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }
}
