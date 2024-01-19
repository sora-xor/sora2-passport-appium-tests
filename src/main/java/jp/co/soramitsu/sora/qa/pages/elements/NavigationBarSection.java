package jp.co.soramitsu.sora.qa.pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Container;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import jp.co.soramitsu.sora.qa.pages.ActivityPage;
import jp.co.soramitsu.sora.qa.pages.ExplorePage;
import jp.co.soramitsu.sora.qa.pages.MorePage;
import jp.co.soramitsu.sora.qa.pages.WalletPage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.appium.ScreenObject.screen;


@Log4j2
public class NavigationBarSection implements Container {

    @AndroidFindBy(accessibility = "Wallet")
    @iOSXCUITFindBy(accessibility = "Wallet")
    private SelenideElement walletBtn;

    @AndroidFindBy(accessibility = "Explore")
    @iOSXCUITFindBy(accessibility = "Explore")
    private SelenideElement exploreBtn;

    @AndroidFindBy(accessibility = "Activity")
    @iOSXCUITFindBy(accessibility = "Activity")
    private SelenideElement activityBtn;

    @AndroidFindBy(accessibility = "More")
    @iOSXCUITFindBy(accessibility = "More")
    private SelenideElement moreBtn;

    @Step
    public MorePage goToMorePage() {
        log.info("Click More button");
        moreBtn.shouldBe(Condition.visible).click();
        checkTabToBeSelected(moreBtn);
        return screen(MorePage.class);
    }

    @Step
    public ExplorePage goToExplorePage() {
        log.info("Click Explore button");
        exploreBtn.shouldBe(Condition.visible).click();
        checkTabToBeSelected(exploreBtn);
        return screen(ExplorePage.class);
    }

    @Step
    public WalletPage goToWalletPage() {
        log.info("Click Wallet button");
        walletBtn.shouldBe(Condition.visible).click();
        checkTabToBeSelected(walletBtn);
        return screen(WalletPage.class);
    }

    @Step
    public ActivityPage goToActivityPage() {
        log.info("Click Activity button");
        activityBtn.shouldBe(Condition.visible).click();
        checkTabToBeSelected(activityBtn);
        return screen(ActivityPage.class);
    }

    private void checkTabToBeSelected(SelenideElement tabButton)
    {
        new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.parse("PT5S"))
                .pollingEvery(Duration.parse("PT1S"))
                .until(ExpectedConditions.elementToBeSelected(tabButton));
    }

    @Step
    public void checkWalletTabToBeSelected()
    {
        checkTabToBeSelected(walletBtn);
    }

}
