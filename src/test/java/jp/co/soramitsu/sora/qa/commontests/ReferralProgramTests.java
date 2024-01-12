package jp.co.soramitsu.sora.qa.commontests;

import io.qameta.allure.TmsLinks;
import jp.co.soramitsu.sora.qa.configs.TestConfig;
import jp.co.soramitsu.sora.qa.infrastructure.CoreTestCase;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import jp.co.soramitsu.sora.qa.pages.ActivityPage;
import jp.co.soramitsu.sora.qa.pages.MorePage;
import jp.co.soramitsu.sora.qa.pages.ReferralProgramPage;
import jp.co.soramitsu.sora.qa.pages.WalletPage;
import jp.co.soramitsu.sora.qa.pages.account.AccountsPage;
import jp.co.soramitsu.sora.qa.pages.account.PinCodePage;

@Feature("Referral program")
@Log4j2
public class ReferralProgramTests extends CoreTestCase {
    @Test
    @TmsLinks({@TmsLink("SORA-379"), @TmsLink("SORA-380")})
    @Issue("link for ios to be added")
    public void startInvitingTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic2());
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        ReferralProgramPage referralProgramPage = morePage.goToReferralProgramPage();
        ActivityPage activityPage = referralProgramPage.startInvitingFlow();
        referralProgramPage = activityPage.checkBoundXorTransaction();
        activityPage = referralProgramPage.unBondXor();
        referralProgramPage = activityPage.checkUnboundXorTransaction();
        morePage = referralProgramPage.returnToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }

    @TmsLink("SORA-377")
    @Test
    @Issue("link for ios to be added")
    public void setReferrerLinkTest() {
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        ReferralProgramPage referralProgramPage = morePage.goToReferralProgramPage();
        ActivityPage activityPage = referralProgramPage.setRefferrersLink(TestConfig.config.referrerLink1());
        referralProgramPage = activityPage.checkSetReffererTransaction();
        //ios crush on this step
        morePage = referralProgramPage.returnToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }

    @Test
    @TmsLink("SORA-378")
    @Issue("issue in iOS")
    public void createReferrersLinkTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic1());
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        ReferralProgramPage referralProgramPage = morePage.goToReferralProgramPage();
        ActivityPage activityPage = referralProgramPage.createInviteLink();
        referralProgramPage = activityPage.checkBoundXorTransaction();
        morePage = referralProgramPage.returnToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }
}
