package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;
import pages.account.ImportAccountPage;
import pages.account.NameYourAccountPage;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@Log4j2
public class WelcomePage {

	@iOSXCUITFindBy(accessibility = "CREATE ACCOUNT")
    @AndroidFindBy(xpath = "//*[@text='CREATE NEW ACCOUNT']")
    private SelenideElement createAccountBtn;

    @AndroidFindBy(xpath = "//*[@text='Passphrase']")
    private SelenideElement importPassphrase;

    @AndroidFindBy(xpath = "//*[@text='Raw seed']")
    private SelenideElement importRawSeed;

    @AndroidFindBy(xpath = "//*[@text='IMPORT ACCOUNT']")
    private SelenideElement importAccountBtn;

    public NameYourAccountPage goToCreateAccountPage() {

        log.info("Create account");
        createAccountBtn.shouldBe(Condition.visible).click();

        return screen(NameYourAccountPage.class);
    }

    public ImportAccountPage goToImportAccountPagePassphrase() {

        log.info("import account");
        importAccountBtn.shouldBe(Condition.visible).click();
        importPassphrase.click();

        return screen(ImportAccountPage.class);
    }

    public ImportAccountPage goToImportAccountPageRawSeed() {

        log.info("import account");
        importAccountBtn.shouldBe(Condition.visible).click();
        importRawSeed.click();

        return screen(ImportAccountPage.class);
    }



    //   @Step("Select language and go to next page")

    // public LetsGetStartedPage goToLetsGetStartedPage() {
 //       log.info("Select language and go to next page");
 //       englishLanguage.shouldBe(Condition.visible)
 //               .click();
 //       nextButton.shouldBe(Condition.visible)
   ///             .click();
   //     return screen(LetsGetStartedPage.class);
    }