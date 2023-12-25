package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import lombok.extern.log4j.Log4j2;
import pages.ActivityPage;
import pages.MorePage;
import pages.ReferralProgramPage;
import pages.WalletPage;
import pages.account.AccountsPage;
import pages.account.PinCodePage;
import org.testng.annotations.Test;

@Log4j2
public class CreateReferrersLinkTest extends CoreTestCase {
    @Test
    @Feature("Invite friends")
    @Issue("issue in iOS")
    public void createReferrersLinkTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic1());
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        ReferralProgramPage referralProgramPage = morePage.goToReferralProgramPage();
        ActivityPage activityPage = referralProgramPage.createInviteLink();
        activityPage.checkBoundXorTransaction();
        referralProgramPage.returnToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }
}
