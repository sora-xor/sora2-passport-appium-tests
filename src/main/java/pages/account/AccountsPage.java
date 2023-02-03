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

    @AndroidFindBy(id = "OpenAccountMenuItem")
    private SelenideElement openAccountMenuItem;

    @AndroidFindBy(id = "FloatingButton")
    private SelenideElement floatingButton;

    @AndroidFindBy(xpath = "//*[@text='Select account for batch export']")
    private SelenideElement selectAccountForBatchExport;

    @AndroidFindBy(xpath = "//*[@text='Open account options']")
    private SelenideElement openAccountOptios;

    @AndroidFindBy(xpath = "//*[@text='FORGET ACCOUNT']")
    private SelenideElement forgetAccountBtn;

    public AccountOptionsPage goToAccountOptionsPage()
    {
        log.info("Click (i) near the only account");
        currentAccountBtn.click();
        return screen(AccountOptionsPage.class);
    }

    public PinCodePage forgetAccount() {
    //    $(By.id("OpenAccountMenuItem")).shouldBe(Condition.visible).click();
    //    openAccountMenuItem.click();
        $x("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.ScrollView/android.view.View/android.view.View").shouldBe(Condition.visible).click();

        $x("//*[@text='Open account options']").shouldBe(Condition.visible).click();

       forgetAccountBtn.click();
        return screen(PinCodePage.class);
    }

}
