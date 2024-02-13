package jp.co.soramitsu.sora.qa.pages.onboarding;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static org.testng.Assert.assertTrue;

public class NameYourAccountPage {

    @iOSXCUITFindBy()
    @AndroidFindBy(xpath = "//*[@text=\"Name your account\"]")
    private SelenideElement nameYourAccountTitle;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Account name\"`]")
    @AndroidFindBy(xpath = "//*[@text=\"Account name\"]/ancestor::android.widget.EditText")
    private SelenideElement accountNameField;

    @iOSXCUITFindBy(accessibility = "Continue")
    @AndroidFindBy(xpath = "//*[@text='Continue']")
    private SelenideElement nextBtn;

    @iOSXCUITFindBy(accessibility = "OK")
    private SelenideElement AlertOkBtn;

    @iOSXCUITFindBy(accessibility = "Done")
    private SelenideElement DoneBtn;


    @Step
    public PayAttentionPage enterAccountNameRegistration() {
        assertTrue(nameYourAccountTitle.isDisplayed(), "Name your account page is not displayed");
        accountNameField.shouldBe(Condition.visible).sendKeys("Create Account");
        nextBtn.shouldBe(Condition.visible).click();
        return screen(PayAttentionPage.class);
    }

    @Step
    public PinCodePage enterAccountNameAfterImport(String accountName) {
        assertTrue(nameYourAccountTitle.isDisplayed(), "Name your account page is not displayed");
        accountNameField.shouldBe(Condition.visible).sendKeys(accountName);
        nextBtn.shouldBe(Condition.enabled).click();
        return screen(PinCodePage.class);
    }
}
