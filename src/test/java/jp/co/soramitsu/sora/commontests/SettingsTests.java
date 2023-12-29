package jp.co.soramitsu.sora.commontests;

import jp.co.soramitsu.sora.infrastructure.CoreTestCase;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import jp.co.soramitsu.sora.pages.AppSettingsPage;
import jp.co.soramitsu.sora.pages.MorePage;
import jp.co.soramitsu.sora.pages.WalletPage;
import jp.co.soramitsu.sora.pages.account.AccountsPage;
import jp.co.soramitsu.sora.pages.account.LoginAndSecurityPage;
import jp.co.soramitsu.sora.pages.account.PinCodePage;

@Feature("Settings")
public class SettingsTests extends CoreTestCase {
    @Test
    @TmsLink("SORA-263")
    public void changeAccountNameTest(){
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        accountsPage.changeAccountName();
        accountsPage.returnToAccountsPage();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }

    @Test
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

    @Test
    @TmsLink("SORA-264")
    public void changePinCodeTest() {
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        LoginAndSecurityPage loginAndSecurityPage = morePage.goToLoginAndSecurity();
        PinCodePage pinCodePage = loginAndSecurityPage.goToChangePin();
        pinCodePage.changeAndConfirmChangePinCode();
        MorePage morePage1 = loginAndSecurityPage.checkToastPinCodeChanged();
        AccountsPage accountsPage = morePage1.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }
}
