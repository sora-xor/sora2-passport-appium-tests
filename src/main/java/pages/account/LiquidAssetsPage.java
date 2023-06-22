package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LiquidAssetsPage {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.widget.Button[1]")
    private SelenideElement sendTokenBtn;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.view.View[1]")
    private SelenideElement xorTokenDetails;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.EditText")
    private SelenideElement accountToSendInput;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.ScrollView")
    private SelenideElement searchResultToSend;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SelectTokenXOR")
    private SelenideElement selectTokenXor;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/XORElement")
    private SelenideElement xorElement;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/InputAmountFieldXOR")
    private SelenideElement inputAmountFieldXor;


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[4]/android.widget.Button")
    private SelenideElement reviewBtn;

    @AndroidFindBy(xpath = "//*[@text='Confirm']")
    private SelenideElement confirmBtn;


    @AndroidFindBy(xpath = "//*[@text='Close']")
    private SelenideElement closeBtn;


    public void sendToken(String randomValue) {
        xorTokenDetails.shouldBe(Condition.visible).click();
        sendTokenBtn.shouldBe(Condition.visible).click();
        accountToSendInput.shouldBe(Condition.visible).sendKeys("cnSmEct9rp2kRUcpkRpKUfZpZxzg8cYFybQ98CBHX2nG49GVY");
        searchResultToSend.shouldBe(Condition.visible).click();
        selectTokenXor.shouldBe(Condition.visible).click();
        xorElement.shouldBe(Condition.visible).click();
        inputAmountFieldXor.shouldBe(Condition.visible).sendKeys(randomValue);

        WebDriver driver = WebDriverRunner.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT300S"), Duration.parse("PT1S"));
        wait.until(ExpectedConditions.visibilityOf(reviewBtn));
        reviewBtn.click();

        WebDriver driver1 = WebDriverRunner.getWebDriver();
        WebDriverWait wait1 = new WebDriverWait(driver1, Duration.parse("PT300S"), Duration.parse("PT1S"));
        wait1.until(ExpectedConditions.visibilityOf(confirmBtn));
        confirmBtn.click();

        closeBtn.shouldBe(Condition.visible).click();
    }
}


