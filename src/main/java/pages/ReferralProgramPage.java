package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.conditions.Exist;
import configs.TestConfig;
import infrastructure.CoreTestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@Log4j2
public class ReferralProgramPage extends CoreTestCase {
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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SORA Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeTextField")
    private SelenideElement enterReferrersLinkField;

    @AndroidFindBy(xpath = "//*[@text='Activate']")
    @iOSXCUITFindBy(accessibility = "Activate")
    private SelenideElement activateReferrersBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SORA Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeTextField")
    private SelenideElement enterAmountOfInvitationsInput;

    @AndroidFindBy(xpath = "//*[@text='Bond XOR']")
    @iOSXCUITFindBy(accessibility = "Bond XOR")
    private SelenideElement bondXorBtn;

    @AndroidFindBy(xpath = "//*[@text='Unbond XOR']")
    private SelenideElement unbondXorBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.widget.TextView[2]")
    private SelenideElement availableInvitationsField;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/OnNavigate")
    private SelenideElement backButton;




    public ActivityPage startInvitingFlow() {

        WebDriver driver = WebDriverRunner.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT10S"), Duration.parse("PT1S"));
        if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View[1]"))).isDisplayed())
        //No invitations
        {
            startInvitingBtn.shouldBe(Condition.visible).click();
        }
        //Get More Invitations
        enterAmountOfInvitationsInput.shouldBe(Condition.visible).sendKeys("1");
        bondXorBtn.shouldBe(Condition.visible).click();
        return screen(ActivityPage.class);
    }

    public ActivityPage unBondXor() {
        String availableInvitations = availableInvitationsField.getText();
        log.info("Available invitations: " + availableInvitations);
        unbondXorBtn.shouldBe(Condition.visible).click();
        enterAmountOfInvitationsInput.shouldBe(Condition.visible).sendKeys("1");
        unbondXorBtn.shouldBe(Condition.visible).click();

        return screen(ActivityPage.class);
    }

    public ActivityPage setRefferrersLink(String referrerLink) {

        WebDriver driver = WebDriverRunner.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT10S"), Duration.parse("PT1S"));
        if (wait.until(ExpectedConditions.visibilityOf(enterReferrersLinkBtn)).isDisplayed()) ;
        //if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.view.View[2]/android.widget.Button"))).isDisplayed())
        //No invitations
        {
            enterReferrersLinkBtn.shouldBe(Condition.visible).click();
            enterReferrersLinkField.shouldBe(Condition.visible).sendKeys(referrerLink);
            activateReferrersBtn.shouldBe(Condition.visible).click();
        }
        return screen(ActivityPage.class);
    }

    public ActivityPage createInviteLink() {
        if (startInvitingBtn.isDisplayed()) {
            startInvitingBtn.click();
        } else {
            getMoreInvitationsBtn.shouldBe(Condition.visible).click();
        }
        enterAmountOfInvitationsInput.shouldBe(Condition.visible).sendKeys("1");
        bondXorBtn.shouldBe(Condition.visible).click();
        return screen(ActivityPage.class);
    }

    public MorePage returnToMorePage(){
        backButton.shouldBe(Condition.visible).click();
        return screen(MorePage.class);
    }
}

