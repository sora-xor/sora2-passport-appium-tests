package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import org.testng.annotations.Test;
import pages.MorePage;
import pages.SoraCardPage;
import pages.WalletPage;
import pages.account.*;

public class SoraCardVerificationFailedTest extends CoreTestCase {

    @Test
    public void soraCardVerificationFailedTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic1());
        SoraCardPage soraCardPage = walletPage.goToSoraCardPage();
        soraCardPage.swipeDown();
        TermsAndConditionsPage termsAndConditionsPage = soraCardPage.viewSoraCardFlow();
        VerifyPhoneNumberOtpPage verifyPhoneNumberOTPPage = termsAndConditionsPage.acceptTermsAndConditions();
        String phoneNumber = TestConfig.config.phoneFailed();
        String testOtp = TestConfig.config.testOtp();
        VerificationStatusPage verificationStatusPage = verifyPhoneNumberOTPPage.verifyYourPhoneNumber(phoneNumber, testOtp);
        KYCPage kycPage = verificationStatusPage.goToKYCProcess();
        kycPage.getPrepared();
        verificationStatusPage.checkFailedStatus();
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCode();
    }
}
