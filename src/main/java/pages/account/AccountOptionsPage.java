package pages.account;

import static com.codeborne.selenide.appium.ScreenObject.screen;

import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;
import pages.MorePage;
import pages.WelcomePage;

@Log4j2
public class AccountOptionsPage {
	
    @iOSXCUITFindBy(accessibility = "Forget account")
    private SelenideElement forgetAccountBtn;
    
    public PinCodePage forgetAccount()
    {
        log.info("Click forget account");
        forgetAccountBtn.click();
        return screen(PinCodePage.class);
    } 

}
