package jp.co.soramitsu.sora.commontests;

import jp.co.soramitsu.sora.configs.TestConfig;
import jp.co.soramitsu.sora.infrastructure.CoreTestCase;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import jp.co.soramitsu.sora.pages.account.*;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import jp.co.soramitsu.sora.pages.MorePage;
import jp.co.soramitsu.sora.pages.SoraCardPage;
import jp.co.soramitsu.sora.pages.WalletPage;

@Log4j2
@Feature("Sora Card")
public class SoraCardTests extends CoreTestCase {
    //todo: all tests need to be fixed
    @Test
    public void soraCardGetIBANTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic1());
        SoraCardPage soraCardPage = walletPage.goToSoraCardPage();
        soraCardPage.swipeDown();
        TermsAndConditionsPage termsAndConditionsPage = soraCardPage.viewSoraCardFlow();
        VerifyPhoneNumberOtpPage verifyPhoneNumberOTPPage = termsAndConditionsPage.acceptTermsAndConditions();
        String phoneNumber = TestConfig.config.phoneApproved();
        String testOtp = TestConfig.config.testOtp();
        VerificationStatusPage verificationStatusPage = verifyPhoneNumberOTPPage.verifyYourPhoneNumber(phoneNumber, testOtp);
        verificationStatusPage.checkApprovedStatusWithoutLogOut();
        SoraCardDetailsPage soraCardDetailsPage = walletPage.goToSoraCardInfo();
        soraCardDetailsPage.checkIBAN();
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }

    @Test
    @TmsLink("SORA-360")
    public void soraCardPhoneApprovedTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic1());
        SoraCardPage soraCardPage = walletPage.goToSoraCardPage();
        soraCardPage.swipeDown();
        TermsAndConditionsPage termsAndConditionsPage = soraCardPage.viewSoraCardFlow();
        VerifyPhoneNumberOtpPage verifyPhoneNumberOTPPage = termsAndConditionsPage.acceptTermsAndConditions();
        String phoneNumber = TestConfig.config.phoneApproved();
        String testOtp = TestConfig.config.testOtp();
        VerificationStatusPage verificationStatusPage = verifyPhoneNumberOTPPage.verifyYourPhoneNumber(phoneNumber, testOtp);
        verificationStatusPage.checkApprovedStatus();
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }

    @Test
    @TmsLink("SORA-351")
    public void soraCardPhonePendingTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic1());
        SoraCardPage soraCardPage = walletPage.goToSoraCardPage();
        soraCardPage.swipeDown();
        TermsAndConditionsPage termsAndConditionsPage = soraCardPage.viewSoraCardFlow();
        VerifyPhoneNumberOtpPage verifyPhoneNumberOTPPage = termsAndConditionsPage.acceptTermsAndConditions();
        String phoneNumber = TestConfig.config.phonePending();
        String testOtp = TestConfig.config.testOtp();
        VerificationStatusPage verificationStatusPage = verifyPhoneNumberOTPPage.verifyYourPhoneNumber(phoneNumber, testOtp);
        verificationStatusPage.checkPendingStatus();
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }

    @Test
    @TmsLink("SORA-359")
    public void soraCardPhoneRejectedX2Test() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase(TestConfig.config.mnemonic1());
        SoraCardPage soraCardPage = walletPage.goToSoraCardPage();
        soraCardPage.swipeDown();
        TermsAndConditionsPage termsAndConditionsPage = soraCardPage.viewSoraCardFlow();
        VerifyPhoneNumberOtpPage verifyPhoneNumberOTPPage = termsAndConditionsPage.acceptTermsAndConditions();
        String phoneNumber = TestConfig.config.phoneRejected();
        String testOtp = TestConfig.config.testOtp();
        VerificationStatusPage verificationStatusPage = verifyPhoneNumberOTPPage.verifyYourPhoneNumber(phoneNumber, testOtp);
        verificationStatusPage.checkRejectedStatus();
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }

    @Test
    @TmsLink("SORA-352")
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
        MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCodeOnLogout();
    }

    /*
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
 */

    /*
    @Test
    public void getSoraCardTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase();
        SoraCardPage soraCardPage = walletPage.goToSoraCardPage();
        soraCardPage.checkThatUserHaveEnoughXorForAFreeCard();
        VerifyPhoneNumberPage kycPage = soraCardPage.startSoraCardFlow();
        kycPage.verifyYourPhoneNumber(TestConfig.config.phoneFailed());
    }
     */

}
