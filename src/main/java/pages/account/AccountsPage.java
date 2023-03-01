package pages.account;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static infrastructure.Platform.isAndroid;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class AccountsPage {

    @iOSXCUITFindBy(accessibility = "iconMenuInfo")
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/OpenAccountMenuItem")
    private SelenideElement openAccountMenuItem;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/FloatingButton")
    private SelenideElement floatingButton;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SelectAccountForBatchExport")
    private SelenideElement selectAccountForBatchExport;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/OpenAccountOptions")
    private SelenideElement openAccountOptios;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/ForgetAccount")
    @iOSXCUITFindBy(accessibility = "Forget account")
    private SelenideElement forgetAccountBtn;

    public PinCodePage forgetAccount() {
       openAccountMenuItem.click();
       if (isAndroid()) {
    	   openAccountOptios.shouldBe(Condition.visible).click();
       }
       forgetAccountBtn.click();
        return screen(PinCodePage.class);
    }
    }

