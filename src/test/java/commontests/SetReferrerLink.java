package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import org.testng.annotations.Test;
import pages.*;
import pages.account.AccountsPage;
import pages.account.PinCodePage;

public class SetReferrerLink extends CoreTestCase {

    @Test
    public void setReffererLink() {
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        ReferralProgramPage referralProgramPage = morePage.goToReferralProgramPage();
        ActivityPage activityPage = referralProgramPage.setRefferrersLink(TestConfig.config.referrerLink1());
        activityPage.checkSetReffererTransaction();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCode();
    }
}
