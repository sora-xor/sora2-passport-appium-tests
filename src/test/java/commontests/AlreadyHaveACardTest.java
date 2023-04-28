package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import org.testng.annotations.Test;
import pages.SoraCardPage;
import pages.WalletPage;
import pages.account.KYCOtpPage;
import pages.account.KYCPage;
import pages.account.TermsAndConditionsPage;
import pages.account.VerificationStatusPage;

public class AlreadyHaveACardTest extends CoreTestCase {

    @Test
    public void alreadyHaveACardTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase();
        SoraCardPage soraCardPage = walletPage.goToSoraCardPage();
        soraCardPage.swipeDown();
        TermsAndConditionsPage termsAndConditionsPage = soraCardPage.alreadyHaveACardFlow();
        KYCPage kycPage = termsAndConditionsPage.acceptTermsAndConditions();
        String phoneNumber = TestConfig.config.phonePending();
        String testOtp = TestConfig.config.testOtp();
        KYCOtpPage kycOtpPage = kycPage.verifyYourPhoneNumber(phoneNumber);
        kycOtpPage.verifyOTP(testOtp);
    //    VerificationStatusPage verificationStatusPage = kycPage.goToVerificationStatusPage();
    //    verificationStatusPage.checkStatus();
    }
}
