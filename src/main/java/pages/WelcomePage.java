package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@Log4j2
public class WelcomePage {

	@iOSXCUITFindBy(accessibility = "CREATE ACCOUNT")
    @AndroidFindBy(xpath = "//*[@text='CREATE ACCOUNT']")
    private SelenideElement createAccountBtn;

 // @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Next\"]")
    @AndroidFindBy(xpath = "//*[@text='IMPORT ACCOUNT']")
    private SelenideElement importAccountBtn;

    public CreateAccountPage goToCreateAccountPage() {

        log.info("Create account");
        createAccountBtn.shouldBe(Condition.visible).click();

        return screen(CreateAccountPage.class);
    }

    public ImportAccountPage goToImportAccountPage() {

        log.info("import account");
        importAccountBtn.shouldBe(Condition.visible).click();

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