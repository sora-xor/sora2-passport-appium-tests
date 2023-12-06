package pages.account;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static infrastructure.Platform.isAndroid;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
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
    @iOSXCUITFindBy(accessibility = "XCUIElementTypeTextField")
    private SelenideElement accountName;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/OnNavigate")
    @iOSXCUITFindBy(accessibility = "Account")
    private SelenideElement backButton;

    public PinCodePage forgetAccount() {
        log.info("Open Account menu");
        openAccountMenuItem.click();
        if (isAndroid()) {
            openAccountOptions.shouldBe(Condition.visible).click();
        }
        log.info("Tap Forget account");
        forgetAccountBtn.click();
        return screen(PinCodePage.class);
    }

    public void changeAccountName() {
        log.info("Open Account menu");
        openAccountMenuItem.click();
        if (isAndroid()) {
            openAccountOptions.shouldBe(Condition.visible).click();
        }
        log.info("Change account name");
        accountName.sendKeys("ChangedName");
        assertThat(accountName.getText()).isEqualTo("ChangedName");
    }

    public void returnToAccountsPage() {
        log.info("Click Back button");
        backButton.click();
    }
}

