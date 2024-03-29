package jp.co.soramitsu.sora.qa.pages.account;

import static jp.co.soramitsu.sora.qa.infrastructure.Platform.isAndroid;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.ScreenObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import jp.co.soramitsu.sora.qa.pages.onboarding.PinCodePage;
import lombok.extern.log4j.Log4j2;
import static org.assertj.core.api.Assertions.*;

@Log4j2
public class AccountsPage {

    @iOSXCUITFindBy(accessibility = "iconMenuInfo")
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/OpenAccountMenuItem")
    private SelenideElement openAccountMenuItem;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/FloatingButton")
    @iOSXCUITFindBy(accessibility = "Add account")
    private SelenideElement addAccountButton;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SelectAccountForBatchExport")
    private SelenideElement selectAccountForBatchExport;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/OpenAccountOptions")
    @iOSXCUITFindBy(accessibility = "iconMenuInfo")
    private SelenideElement openAccountOptions;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/ForgetAccount")
    @iOSXCUITFindBy(accessibility = "Forget account")
    private SelenideElement forgetAccountBtn;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    private SelenideElement accountName;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/OnNavigate")
    @iOSXCUITFindBy(accessibility = "Account")
    private SelenideElement backButton;

    @Step
    public PinCodePage forgetAccount() {
        log.info("Open Account menu");
        openAccountMenuItem.click();
        if (isAndroid()) {
            openAccountOptions.shouldBe(Condition.visible).click();
        }
        log.info("Tap Forget account");
        forgetAccountBtn.click();
        return ScreenObject.screen(PinCodePage.class);
    }

    @Step
    public void changeAccountName() {
        log.info("Open Account menu");
        openAccountMenuItem.click();
        if (isAndroid()) {
            openAccountOptions.shouldBe(Condition.visible).click();
        }
        log.info("Change account name to: Changed Name");
        accountName.clear();
        accountName.sendKeys("ChangedName");
        assertThat(accountName.getText()).isEqualTo("ChangedName");
    }

    @Step
    public void returnToAccountsPage() {
        log.info("Click Back button");
        backButton.click();
    }
}

