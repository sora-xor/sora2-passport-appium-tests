package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import org.testng.annotations.Test;
import pages.SoraCardPage;
import pages.WalletPage;
import pages.account.KYCPage;

public class AlreadyHaveACardTest extends CoreTestCase {

    @Test
    public void AlreadyHaveACardTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase();
        SoraCardPage soraCardPage = walletPage.goToSoraCardPage();
        soraCardPage.swipeDown();
        KYCPage kycPage = soraCardPage.AlreadyHaveACardFlow();
        kycPage.VerifyYourPhoneNumber(TestConfig.config.email());
    }
}
