package jp.co.soramitsu.sora.qa.pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.ScreenObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import jp.co.soramitsu.sora.qa.pages.WalletPage;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class VerificationStatusPage {
    @iOSXCUITFindBy(accessibility = "iconMenuInfo")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView")
    private SelenideElement verificationStatus;

    @AndroidFindBy(xpath = "//*[@text='Telegram support']")
    private SelenideElement telegramSupportBtn;

    @AndroidFindBy(xpath = "//*[@text='Close']")
    private SelenideElement closeBtn;
    @AndroidFindBy(xpath = "//*[@text='Log out']")
    private SelenideElement logOutCardBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.Button")
    private SelenideElement backBtn;

    @Step
    public KYCPage goToKYCProcess()
    {
        return ScreenObject.screen(KYCPage.class);
    }

    @Step
    public WalletPage checkRejectedStatus ()
    {
        String actualStatus = verificationStatus.shouldBe(Condition.visible).getText();
        assertThat(actualStatus).as("Verification rejected").isEqualTo("Verification rejected");
        log.info("KYC Status: " + actualStatus);
        logOutCardBtn.shouldBe(Condition.visible).click();
        return screen(WalletPage.class);
    }
    public WalletPage checkApprovedStatus ()
    {
        String actualStatus = verificationStatus.shouldBe(Condition.visible).getText();
        assertThat(actualStatus).as("Application approved").isEqualTo("Application approved");
        log.info("KYC Status: " + actualStatus);
        logOutCardBtn.shouldBe(Condition.visible).click();
        log.info("SoraCard Log out");
        return screen(WalletPage.class);
    }

    public WalletPage checkPendingStatus ()
    {
        String actualStatus = verificationStatus.shouldBe(Condition.visible).getText();
        assertThat(actualStatus).as("Verification in progress").isEqualTo("Verification in progress");
        log.info("KYC Status: " + actualStatus);
        logOutCardBtn.shouldBe(Condition.visible).click();
        log.info("SoraCard Log out");
        return screen(WalletPage.class);
    }

    public WalletPage checkFailedStatus ()
    {
        String actualStatus = verificationStatus.shouldBe(Condition.visible).getText();
        assertThat(actualStatus).as("Verification failed").isEqualTo("Verification failed");
        log.info("KYC Status: " + actualStatus);
        logOutCardBtn.shouldBe(Condition.visible).click();
        log.info("SoraCard Log out");
        return screen(WalletPage.class);
    }

    public WalletPage checkApprovedStatusWithoutLogOut ()
    {
        String actualStatus = verificationStatus.shouldBe(Condition.visible).getText();
        assertThat(actualStatus).as("Application approved").isEqualTo("Application approved");
        log.info("KYC Status: " + actualStatus);
        closeBtn.shouldBe(Condition.visible).click();
        return screen(WalletPage.class);
    }


}


