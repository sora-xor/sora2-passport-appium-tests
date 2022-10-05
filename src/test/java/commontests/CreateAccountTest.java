package commontests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Config;
import configs.TestConfig;
import infrastructure.CoreTestCase;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.ImportAccountPage;
import pages.WelcomePage;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@Log4j2
public class CreateAccountTest extends CoreTestCase {

    @Test
    public void enterAccountName (){
        WelcomePage welcomePage = screen(WelcomePage.class);
        CreateAccountPage createAccountPage = welcomePage.goToCreateAccountPage();
        createAccountPage.enterAccountName((TestConfig.config.mnemonic()));
    }
}
