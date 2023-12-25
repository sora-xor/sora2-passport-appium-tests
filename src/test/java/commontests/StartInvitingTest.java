package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.*;
import pages.account.AccountsPage;
import pages.account.PinCodePage;

@Log4j2
public class StartInvitingTest extends CoreTestCase {

    @Test
    @Feature("Invite friends")
    @Issue("link for ios to be added")
    public void startInvitingTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic2());
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        ReferralProgramPage referralProgramPage = morePage.goToReferralProgramPage();
        ActivityPage activityPage = referralProgramPage.startInvitingFlow();
        activityPage.checkBoundXorTransaction();
        referralProgramPage.unBondXor();
        activityPage.checkUnboundXorTransaction();
        referralProgramPage.returnToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }
}
