package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import io.qameta.allure.Issue;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.*;
import pages.account.AccountsPage;
import pages.account.PinCodePage;

@Log4j2
public class SetReferrerLinkTest extends CoreTestCase {

    @TmsLink("SORA-377")
    @Test
    @Feature("Invite friends")
    @Issue("link for ios to be added")
    public void setReferrerLinkTest() {
        WalletPage walletPage = WalletPage.createNewAccount();
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        ReferralProgramPage referralProgramPage = morePage.goToReferralProgramPage();
        ActivityPage activityPage = referralProgramPage.setRefferrersLink(TestConfig.config.referrerLink1());
        activityPage.checkSetReffererTransaction();
        //ios crush on this step
        referralProgramPage.returnToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }
}
