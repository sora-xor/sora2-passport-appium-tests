package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import org.testng.annotations.Test;
import pages.SoraCardPage;
import pages.WalletPage;
import pages.account.KYCPage;

public class GetSoraCardTest extends CoreTestCase {
    @Test
    public void getSoraCardTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase();
        SoraCardPage soraCardPage = walletPage.goToSoraCardPage();
        soraCardPage.checkThatUserHaveEnoughXorForAFreeCard();
        KYCPage kycPage = soraCardPage.startSoraCardFlow();
        kycPage.verifyYourPhoneNumber(TestConfig.config.phoneFailed());
    }
}
