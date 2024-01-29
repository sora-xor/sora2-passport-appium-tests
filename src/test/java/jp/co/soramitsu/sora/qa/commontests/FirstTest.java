package jp.co.soramitsu.sora.qa.commontests;

import jp.co.soramitsu.sora.qa.infrastructure.CoreTestCase;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import jp.co.soramitsu.sora.qa.pages.onboarding.WelcomePage;
import jp.co.soramitsu.sora.qa.pages.onboarding.NameYourAccountPage;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@Log4j2
public class FirstTest extends CoreTestCase {

    @Test
    public void openLetsGetStartedPage () {
        WelcomePage welcomePage = screen(WelcomePage.class);
        NameYourAccountPage nameYourAccountPage = welcomePage.goToCreateAccountPage();
    }
}