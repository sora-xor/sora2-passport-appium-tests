package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;
import pages.account.KYCPage;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumScrollOptions.*;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.ScrollDirection.DOWN;
import static com.codeborne.selenide.appium.ScrollDirection.UP;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class SoraCardPage{

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View[2]/android.widget.TextView[3]")
    @iOSXCUITFindBy(accessibility = "enoughXorForAFreeCard")
    private SelenideElement enoughXorForAFreeCard;

    @AndroidFindBy(xpath = "//*[@text='CONTINUE']")
    @iOSXCUITFindBy(accessibility = "CONTINUE")
    private SelenideElement continueBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/AlreadyHaveCard")
    @iOSXCUITFindBy(accessibility = "AlreadyHaveCard")
    private SelenideElement alreadyHaveACardBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/GetMoreXor")
    @iOSXCUITFindBy(accessibility = "GetMoreXor")
    private SelenideElement getMoreXorBtn;

    public SoraCardPage() throws MalformedURLException {
    }
    public void СheckThatUserHaveEnoughXorForAFreeCard() {
        String actualXorBalance = enoughXorForAFreeCard.shouldBe(Condition.visible).getText();
        assertThat(actualXorBalance).isEqualTo("You have enough XOR for a FREE card");
    }

    public void CheckThatUserNeedMoreXor() {
        String actualXorBalance = enoughXorForAFreeCard.shouldBe(Condition.visible).getText();
        assertThat(actualXorBalance).contains("You need");
    }

    public KYCPage StartSoraCardFlow() {
        continueBtn.shouldBe(Condition.visible).click();
        return screen(KYCPage.class);
    }

    public void swipeDown()
    {
        SelenideAppium.$x(".//*[@text='€0 annual service fee']").click();
        SelenideAppium.$x(".//*[@text='See the list']")
                .scroll(with(DOWN, 1));
        SelenideAppium.$x(".//*[@text='I ALREADY HAVE A CARD']")
                .scroll(down())
                .shouldHave(visible);
    }

    public KYCPage AlreadyHaveACardFlow() {
        {
            alreadyHaveACardBtn.shouldBe(Condition.visible).click();
            return screen(KYCPage.class);
        }
    }
}




