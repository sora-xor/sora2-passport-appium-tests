package jp.co.soramitsu.sora.qa.commontests;

import jp.co.soramitsu.sora.qa.infrastructure.CoreTestCase;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import jp.co.soramitsu.sora.qa.pages.AppSettingsPage;
import jp.co.soramitsu.sora.qa.pages.MorePage;
import jp.co.soramitsu.sora.qa.pages.WalletPage;
import jp.co.soramitsu.sora.qa.pages.account.LoginAndSecurityPage;
import jp.co.soramitsu.sora.qa.pages.onboarding.PinCodePage;

@Feature("Settings")
public class SettingsTests extends CoreTestCase {
    @Test
    @TmsLink("SORA-263")
    public void changeAccountNameTest(){
        WalletPage walletPage = WalletPage.createNewAccount();
    }

    @Test
    @TmsLink("SORA-381")
    public void changeLanguageTest() {
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        AppSettingsPage appSettingsPage = morePage.goToAppSettingsPage();
        appSettingsPage.switchToSpanish();
        appSettingsPage.switchToEnglish();
    }

    @Test
    @TmsLink("SORA-264")
    public void changePinCodeTest() {
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        LoginAndSecurityPage loginAndSecurityPage = morePage.goToLoginAndSecurity();
        PinCodePage pinCodePage = loginAndSecurityPage.goToChangePin();
        loginAndSecurityPage = pinCodePage.changeAndConfirmChangePinCode();
        morePage = loginAndSecurityPage.checkToastPinCodeChanged();
    }
}
