package commontests;

import infrastructure.CoreTestCase;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.WelcomePage;
import pages.account.NameYourAccountPage;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@Log4j2
public class FirstTest extends CoreTestCase {

    @Test
    public void openLetsGetStartedPage (){
        WelcomePage welcomePage = screen(WelcomePage.class);
        NameYourAccountPage nameYourAccountPage = welcomePage.goToCreateAccountPage();
    }
}