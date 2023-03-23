package commontests;

import infrastructure.CoreTestCase;
import org.testng.annotations.Test;
import pages.SoraCardPage;
import pages.WalletPage;
import pages.account.KYCPage;

public class GetSoraCardTest extends CoreTestCase {
    @Test
    public void GetSoraCardTest() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase();
        SoraCardPage soraCardPage = walletPage.goToSoraCardPage();
        soraCardPage.СheckThatUserHaveEnoughXorForAFreeCard();
        KYCPage kycPage = soraCardPage.StartSoraCardFlow();
        kycPage.VerifyYourPhoneNumber();
    }
}
