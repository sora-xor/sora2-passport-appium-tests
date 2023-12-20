package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import infrastructure.Utils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@Log4j2
public class KYCPage{

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView")
    private SelenideElement getPreparedTitle;

    @AndroidFindBy(xpath = "//*[@text='OK, I am ready']")
    private SelenideElement readyToAttemptBtn;
    @AndroidFindBy(xpath = "//*[@text='Log out']")
    private SelenideElement soraCardLogOutBtn;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.TextView[1]")
    private SelenideElement attention2Attemps;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/sns_country_title")
    private SelenideElement selectCountryTitle;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/sns_country_selector")
    private SelenideElement selectCountrySelector;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/sns_documents_title")
    private SelenideElement selectDocumentsTitle;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/sns_button_close")
    private SelenideElement closeKYCBtn;


    @Step
    public VerificationStatusPage getPrepared() {
        String getPreparedText = "";
        getPreparedText = getPreparedTitle.getText();
        getPreparedTitle.shouldBe(Condition.visible);
        log.info(getPreparedText);
        Utils.scrollForward(1);
        readyToAttemptBtn.shouldBe(Condition.visible).click();

        WebDriver driver = WebDriverRunner.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT30S"), Duration.parse("PT5S"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("jp.co.soramitsu.sora.develop:id/sns_country_title")));

        String selectCountry = "";
        selectCountry = selectCountryTitle.shouldBe(Condition.visible).getText();
        selectCountryTitle.shouldBe(Condition.visible);
        log.info(selectCountry);
        selectDocumentsTitle.shouldBe(Condition.visible);
        closeKYCBtn.shouldBe(Condition.visible).click();
        log.info("Close KYC process (x)");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Log out']")));

        return screen(VerificationStatusPage.class);
    }
}
