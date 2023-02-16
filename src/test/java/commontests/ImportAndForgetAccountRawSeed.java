package commontests;

import static com.codeborne.selenide.appium.ScreenObject.screen;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import configs.TestConfig;
import infrastructure.CoreTestCase;
import lombok.extern.log4j.Log4j2;
import pages.MorePage;
import pages.WalletPage;
import pages.WelcomePage;
import pages.account.AccountOptionsPage;
import pages.account.AccountsPage;
import pages.account.ImportAccountPage;
import pages.account.NameYourAccountPage;
import pages.account.PinCodePage;


@Log4j2
public class ImportAndForgetAccountRawSeed extends CoreTestCase {

	@Test
	@Parameters({ "accountNameParam" })
	public void importAccountRawSeed (String param){
        WelcomePage welcomePage = screen(WelcomePage.class);
        ImportAccountPage importAccountPage = welcomePage.goToImportAccountPageRawSeed();
        NameYourAccountPage nameYourAccountPage = importAccountPage.enterRawSeed(TestConfig.config.rawseed());
        PinCodePage pinCodePage = nameYourAccountPage.enterAccountNameAfterImport(param);
        WalletPage walletPage = pinCodePage.enterAndConfirmPinCode();
        walletPage.walletPageIsOpen();
        MorePage morePage =  walletPage.getNavigationBarSection().goToMorePage();
        AccountsPage accountsPage = morePage.goToAccounts();
        AccountOptionsPage accountOptionsPage = accountsPage.goToAccountOptionsPage();
        PinCodePage enterCodePage = accountOptionsPage.forgetAccount();
        enterCodePage.enterPinCode();
        
        		
        
        
    }
}
