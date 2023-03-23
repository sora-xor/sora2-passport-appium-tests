package commontests;

import infrastructure.CoreTestCase;
import org.testng.annotations.Test;
import pages.WalletPage;

public class GetSoraCardTest extends CoreTestCase {
    @Test
    public void GetSoraCard() {
        WalletPage walletPage = WalletPage.importAccountUsePassphrase();
        walletPage.goToSoraCardPage();
    }
}
