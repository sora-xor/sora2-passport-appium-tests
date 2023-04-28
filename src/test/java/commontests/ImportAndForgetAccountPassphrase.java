package commontests;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.*;
import pages.account.*;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@Log4j2
public class ImportAndForgetAccountPassphrase extends CoreTestCase {


    @Test
    public void importAndForgetAccountPassphrase (){
        WalletPage walletPage = WalletPage.importAccountUsePassphrase();
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        PinCodePage enterCodePage = accountsPage.forgetAccount();
        enterCodePage.enterPinCode();

    }
}
