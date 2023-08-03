package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import configs.TestConfig;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.WalletPage;

import java.time.Duration;

import static com.codeborne.selenide.appium.ScreenObject.screen;

public class LiquidAssetsPage {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.widget.Button[1]")
    private SelenideElement sendTokenBtn;
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/TokenN0")
    @iOSXCUITFindBy(accessibility = "SORA")
    private SelenideElement xorTokenDetails;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SearchInput")
    private SelenideElement accountToSendInput;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SearchItemN0")
    private SelenideElement searchResultToSend;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SelectTokenXOR")
    private SelenideElement selectTokenXor;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/XORElement")
    private SelenideElement xorElement;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/InputAmountFieldXOR")
    private SelenideElement inputAmountFieldXor;


    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/ReviewButton")
    private SelenideElement reviewBtn;

    @AndroidFindBy(xpath = "//*[@text='Confirm']")
    private SelenideElement confirmBtn;

    @AndroidFindBy(xpath = "//*[@text='Network fee']")
    private SelenideElement networkFeeBtn;

    @AndroidFindBy(xpath = "//*[@text='OK']")
    private SelenideElement okBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/CloseButton")
    private SelenideElement closeBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.Button")
    private SelenideElement backBtn;

    public WalletPage sendToken(String randomValue) {
        xorTokenDetails.shouldBe(Condition.visible).click();
        sendTokenBtn.shouldBe(Condition.visible).click();
        accountToSendInput.shouldBe(Condition.visible).sendKeys(TestConfig.config.assetId());
        searchResultToSend.shouldBe(Condition.visible).click();
        selectTokenXor.shouldBe(Condition.visible).click();
        xorElement.shouldBe(Condition.visible).click();
        inputAmountFieldXor.shouldBe(Condition.visible).sendKeys(randomValue);
        networkFeeBtn.shouldBe(Condition.visible).click();
        okBtn.shouldBe(Condition.visible).click();

        WebDriver driver = WebDriverRunner.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT300S"), Duration.parse("PT1S"));
        wait.until(ExpectedConditions.visibilityOf(reviewBtn));
        reviewBtn.click();

        WebDriver driver1 = WebDriverRunner.getWebDriver();
        WebDriverWait wait1 = new WebDriverWait(driver1, Duration.parse("PT300S"), Duration.parse("PT1S"));
        wait1.until(ExpectedConditions.visibilityOf(confirmBtn));
        confirmBtn.click();
        closeBtn.shouldBe(Condition.visible).click();

        return screen(WalletPage.class);
    }
}


