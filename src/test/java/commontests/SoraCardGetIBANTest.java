package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import org.testng.annotations.Test;
import pages.MorePage;
import pages.SoraCardPage;
import pages.WalletPage;
import pages.account.*;

public class SoraCardGetIBANTest extends CoreTestCase {

    @Test
    public void soraCardGetIBANTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase();
        SoraCardPage soraCardPage = walletPage.goToSoraCardPage();
        soraCardPage.swipeDown();
        TermsAndConditionsPage termsAndConditionsPage = soraCardPage.viewSoraCardFlow();
        VerifyPhoneNumberOtpPage verifyPhoneNumberOTPPage = termsAndConditionsPage.acceptTermsAndConditions();
        String phoneNumber = TestConfig.config.phoneApproved();
        String testOtp = TestConfig.config.testOtp();
        VerificationStatusPage verificationStatusPage = verifyPhoneNumberOTPPage.verifyYourPhoneNumber(phoneNumber, testOtp);
        verificationStatusPage.checkApprovedStatusForCardInfo();
        SoraCardDetailsPage soraCardDetailsPage = walletPage.goToSoraCardInfo();
        soraCardDetailsPage.checkIBAN();
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCode();
    }
}
