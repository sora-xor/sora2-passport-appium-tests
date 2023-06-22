package commontests;

import infrastructure.CoreTestCase;
import org.testng.annotations.Test;
import pages.*;
import pages.account.AccountsPage;
import pages.account.PinCodePage;

public class StartInvitingTest extends CoreTestCase {

    @Test
    public void startInvitingTest() {
        WalletPage walletPage = WalletPage.importAccount2UsePassphrase();
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        ReferralProgramPage referralProgramPage = morePage.goToReferralProgramPage();
        ActivityPage activityPage = referralProgramPage.startInvitingFlow();
        activityPage.checkBoundXorTransaction();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCode();
    }
}
