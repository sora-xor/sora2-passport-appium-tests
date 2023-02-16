package pages.account;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.appium.ScreenObject.screen;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.MorePage;
import pages.WelcomePage;

@Log4j2
public class AccountsPage {

    @iOSXCUITFindBy(accessibility = "iconMenuInfo")
    private SelenideElement currentAccountBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/OpenAccountMenuItem")
    private SelenideElement openAccountMenuItem;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/FloatingButton")
    private SelenideElement floatingButton;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SelectAccountForBatchExport")
    private SelenideElement selectAccountForBatchExport;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/OpenAccountOptions")
    private SelenideElement openAccountOptios;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/ForgetAccount")
    private SelenideElement forgetAccountBtn;

    public AccountOptionsPage goToAccountOptionsPage()
    {
        log.info("Click (i) near the only account");
        currentAccountBtn.click();
        return screen(AccountOptionsPage.class);
    }

    public PinCodePage forgetAccount() {
       openAccountMenuItem.click();
       openAccountOptios.shouldBe(Condition.visible).click();
       forgetAccountBtn.click();
        return screen(PinCodePage.class);
    }
    }

