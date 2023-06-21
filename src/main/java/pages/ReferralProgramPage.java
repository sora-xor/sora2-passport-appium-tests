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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.appium.ScreenObject.screen;
@Log4j2
public class ReferralProgramPage extends CoreTestCase{
    @AndroidFindBy(xpath = "//*[@text='Start inviting']")
    private SelenideElement starttInvitingBtn;

    @AndroidFindBy(xpath = "//*[@text='Get more invitations']")
    private SelenideElement getMoreInvitationsBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.view.View/android.widget.Button")
    private SelenideElement enterReferrersLinkBtn;

    @AndroidFindBy(className = "android.widget.EditText")
    private SelenideElement enterReferrersLinkField;

    @AndroidFindBy(xpath = "//*[@text='Activate']")
    private SelenideElement activateReferrersBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.widget.EditText")
    private SelenideElement enterAmountOfInvitationsInput;


    @AndroidFindBy(xpath = "//*[@text='Bond XOR']")
    private SelenideElement bondXorBtn;


    public ActivityPage startInvitingFlow() {
        //No invitations
        if (starttInvitingBtn.isDisplayed())
        {
            starttInvitingBtn.click();
        }
        //Get More Invitations
        else getMoreInvitationsBtn.shouldBe(Condition.visible).click();
        enterAmountOfInvitationsInput.shouldBe(Condition.visible).sendKeys("1");
        bondXorBtn.shouldBe(Condition.visible).click();
        return screen (ActivityPage.class);
    }

    public ActivityPage setRefferrersLink(String referrerLink)
    {
        //No referrer's link
        if (enterReferrersLinkBtn.isDisplayed())
        {
            enterReferrersLinkBtn.shouldBe(Condition.visible).click();
            enterReferrersLinkField.shouldBe(Condition.visible).sendKeys(referrerLink);
            activateReferrersBtn.shouldBe(Condition.visible).click();
        }
        //Referrer is already set
        else
        log.info("Referrer's link is already set");
        return screen (ActivityPage.class);
    }
}

