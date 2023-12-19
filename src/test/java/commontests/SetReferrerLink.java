package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import pages.*;
import pages.account.AccountsPage;
import pages.account.PinCodePage;

public class SetReferrerLink extends CoreTestCase {

    @Test
    @Issue("link for ios to be added")
    public void setReferrerLink() {
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        ReferralProgramPage referralProgramPage = morePage.goToReferralProgramPage();
        ActivityPage activityPage = referralProgramPage.setRefferrersLink(TestConfig.config.referrerLink1());
        activityPage.checkSetReffererTransaction();
        //ios crush on this step
        referralProgramPage.returnToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCode();
    }
}
