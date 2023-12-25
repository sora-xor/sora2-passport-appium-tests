package commontests;

import static com.codeborne.selenide.appium.ScreenObject.screen;

import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import org.testng.annotations.Test;

import infrastructure.CoreTestCase;
import lombok.extern.log4j.Log4j2;
import pages.MorePage;
import pages.WalletPage;
import pages.account.AccountsPage;
import pages.account.PinCodePage;

@Log4j2
public class ImportAndForgetAccountRawSeedTest extends CoreTestCase {

    @Test
    @Features({@Feature("Import account"), @Feature("Logout")})
    @TmsLinks({@TmsLink("SORA-270"), @TmsLink("SORA-376")})
    public void importAndForgetAccountRawSeedTest() {
        WalletPage walletPage = WalletPage.importAccountUseRawSeed();
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }
}
