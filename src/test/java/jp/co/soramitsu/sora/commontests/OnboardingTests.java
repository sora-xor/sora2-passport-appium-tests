package jp.co.soramitsu.sora.commontests;

import jp.co.soramitsu.sora.configs.TestConfig;
import jp.co.soramitsu.sora.infrastructure.CoreTestCase;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import org.testng.annotations.Test;
import jp.co.soramitsu.sora.pages.MorePage;
import jp.co.soramitsu.sora.pages.WalletPage;
import jp.co.soramitsu.sora.pages.account.AccountsPage;
import jp.co.soramitsu.sora.pages.account.PinCodePage;


public class OnboardingTests extends CoreTestCase {
    @Test
    @TmsLinks({@TmsLink("SORA-270"), @TmsLink("SORA-373")})
    @Features({@Feature("Create account"), @Feature("Logout")})
    public void createAndForgetAccountTest() {
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }

    @Test
    @Features({@Feature("Import account"), @Feature("Logout")})
    @TmsLinks({@TmsLink("SORA-270"), @TmsLink("SORA-9")})
    public void importAndForgetAccountPassphraseTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic1());
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }

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
