package jp.co.soramitsu.sora.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.appium.ScreenObject;
import jp.co.soramitsu.sora.qa.infrastructure.CoreTestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import jp.co.soramitsu.sora.qa.infrastructure.Utils;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static jp.co.soramitsu.sora.qa.infrastructure.Platform.isAndroid;

@Log4j2
public class ReferralProgramPage extends CoreTestCase {
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View/android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Sora Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    private SelenideElement startInvitingView;

    @AndroidFindBy(xpath = "//*[@text='Start inviting']")
    @iOSXCUITFindBy(accessibility = "Start inviting")
    private SelenideElement startInvitingBtn;

    @AndroidFindBy(xpath = "//*[@text='Get more invitations']")
    @iOSXCUITFindBy(accessibility = "Get more invitations")
    private SelenideElement getMoreInvitationsBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.view.View[2]/android.widget.Button")
    @iOSXCUITFindBy(accessibility = "Enter referrer's link")
    private SelenideElement enterReferrersLinkBtn;

    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    private SelenideElement enterReferrersLinkField;

    @AndroidFindBy(xpath = "//*[@text='Activate']")
    @iOSXCUITFindBy(accessibility = "Activate")
    private SelenideElement activateReferrersBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.widget.EditText")
    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    private SelenideElement enterAmountOfInvitationsInput;

    @AndroidFindBy(xpath = "//*[@text='Bond XOR']")
    @iOSXCUITFindBy(accessibility = "Bond XOR")
    private SelenideElement bondXorBtn;

    @AndroidFindBy(xpath = "//*[@text='Unbond XOR']")
    @iOSXCUITFindBy(accessibility = "Unbond XOR")
    private SelenideElement unbondXorBtn;

    @AndroidFindBy(xpath = "//*[@text='Unbond XOR']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Unbond XOR\"])[2]")
    private SelenideElement unbondXorConfirmBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.widget.TextView[2]")
    private SelenideElement availableInvitationsField;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/OnNavigate")
    @iOSXCUITFindBy(accessibility = "cross")
    private SelenideElement backButton;

    @Step
    public ActivityPage startInvitingFlow() {
        log.info("Start inviting flow");
        WebDriver driver = WebDriverRunner.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT10S"), Duration.parse("PT1S"));
        wait.until(ExpectedConditions.visibilityOf(startInvitingView));
        if (isAndroid()) {
            startInvitingBtn.shouldBe(Condition.visible).click();
        } else {
            Utils.tapElementByCoordinates(startInvitingBtn);
        }
        enterAmountOfInvitationsInput.shouldBe(Condition.visible).sendKeys("1");
        log.info("Bond 1 XOR");
        if (isAndroid()) {
            bondXorBtn.shouldBe(Condition.visible).click();
        } else {
            Utils.tapElementByCoordinates(bondXorBtn);
        }
        return ScreenObject.screen(ActivityPage.class);
    }

    @Step
    public ActivityPage unBondXor() {
        checkAvailableInvitations();
        unbondXorBtn.shouldBe(Condition.visible).click();
        log.info("Unbond 1 XOR");
        unbondXorConfirmBtn.shouldBe(Condition.visible).click();
        return ScreenObject.screen(ActivityPage.class);
    }

    @Step
    public void checkAvailableInvitations() {
        //todo add an actual checking not logging
        //todo: find a way to get available invitations on ios too (it might bring flakiness)
        String getAvailableInvitations;
        if (isAndroid()) {
            getAvailableInvitations = availableInvitationsField.shouldBe(Condition.visible).getText();
            log.info("Available invitations " + getAvailableInvitations);
        }
    }

    @Step
    public ActivityPage setReferrersLink(String referrerLink) {
        WebDriver driver = WebDriverRunner.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT10S"), Duration.parse("PT1S"));
        wait.until(ExpectedConditions.visibilityOf(enterReferrersLinkBtn));
        enterReferrersLinkBtn.click();
        enterReferrersLinkField.shouldBe(Condition.visible).sendKeys(referrerLink);
        activateReferrersBtn.shouldBe(Condition.visible).click();
        return ScreenObject.screen(ActivityPage.class);
    }

    @Step
    public ActivityPage createInviteLink() {
        if (startInvitingBtn.isDisplayed()) {
            startInvitingBtn.click();
        } else {
            getMoreInvitationsBtn.shouldBe(Condition.visible).click();
        }
        enterAmountOfInvitationsInput.shouldBe(Condition.visible).sendKeys("1");
        bondXorBtn.shouldBe(Condition.visible).click();
        return ScreenObject.screen(ActivityPage.class);
    }

    @Step
    public MorePage returnToMorePage() {
        backButton.shouldBe(Condition.visible).click();
        return ScreenObject.screen(MorePage.class);
    }
}

