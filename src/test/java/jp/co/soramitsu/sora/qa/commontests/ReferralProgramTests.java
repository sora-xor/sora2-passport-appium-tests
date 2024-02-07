package jp.co.soramitsu.sora.qa.commontests;

import io.qameta.allure.TmsLinks;
import jp.co.soramitsu.sora.qa.configs.TestConfig;
import jp.co.soramitsu.sora.qa.infrastructure.CoreTestCase;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import jp.co.soramitsu.sora.qa.pages.ActivityPage;
import jp.co.soramitsu.sora.qa.pages.MorePage;
import jp.co.soramitsu.sora.qa.pages.ReferralProgramPage;
import jp.co.soramitsu.sora.qa.pages.WalletPage;

@Feature("Referral program")
@Log4j2
public class ReferralProgramTests extends CoreTestCase {
    @Test
    @TmsLinks({@TmsLink("SORA-379"), @TmsLink("SORA-380")})
    public void startInvitingTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic2());
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        ReferralProgramPage referralProgramPage = morePage.goToReferralProgramPage();
        ActivityPage activityPage = referralProgramPage.startInvitingFlow();
        referralProgramPage = activityPage.checkBoundXorTransaction();
        activityPage = referralProgramPage.unBondXor();
        referralProgramPage = activityPage.checkUnboundXorTransaction();
        referralProgramPage.checkAvailableInvitations();
        referralProgramPage.returnToMorePage();
    }

    @Test
    @TmsLink("SORA-378")
    public void createReferrersLinkTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic1());
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        ReferralProgramPage referralProgramPage = morePage.goToReferralProgramPage();
        ActivityPage activityPage = referralProgramPage.createInviteLink();
        referralProgramPage = activityPage.checkBoundXorTransaction();
        referralProgramPage.checkAvailableInvitations();
        referralProgramPage.returnToMorePage();
    }

    @TmsLink("SORA-377")
    @Test
    public void setReferrerLinkTest() {
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        ReferralProgramPage referralProgramPage = morePage.goToReferralProgramPage();
        ActivityPage activityPage = referralProgramPage.setReferrersLink(TestConfig.config.referrerLink1());
        referralProgramPage = activityPage.checkSetReferrerTransaction();
        referralProgramPage.returnToMorePage();
    }
}
