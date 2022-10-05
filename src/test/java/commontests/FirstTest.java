package commontests;

import infrastructure.CoreTestCase;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.digester.annotations.CreationRule;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.WelcomePage;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@Log4j2
public class FirstTest extends CoreTestCase {

    @Test
    public void openLetsGetStartedPage (){
        WelcomePage welcomePage = screen(WelcomePage.class);
        CreateAccountPage createAccountPage = welcomePage.goToCreateAccountPage();
    }
}