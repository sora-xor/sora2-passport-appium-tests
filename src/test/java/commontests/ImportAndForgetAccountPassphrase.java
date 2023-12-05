package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.*;
import pages.account.*;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@Log4j2
public class ImportAndForgetAccountPassphrase extends CoreTestCase {

    @Test
    @Features({@Feature("Import account"), @Feature("Logout")})
    @TmsLinks({@TmsLink("SORA-270"), @TmsLink("SORA-9")})
    public void importAndForgetAccountPassphrase() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase();
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCode();
    }
}
