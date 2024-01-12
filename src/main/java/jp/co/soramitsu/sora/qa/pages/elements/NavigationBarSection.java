package jp.co.soramitsu.sora.qa.pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Container;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import jp.co.soramitsu.sora.qa.pages.ActivityPage;
import jp.co.soramitsu.sora.qa.pages.ExplorePage;
import jp.co.soramitsu.sora.qa.pages.MorePage;
import jp.co.soramitsu.sora.qa.pages.WalletPage;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static jp.co.soramitsu.sora.qa.infrastructure.Platform.isAndroid;
import static jp.co.soramitsu.sora.qa.infrastructure.Platform.isIOS;

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
        isMoreTabSelected();
        return screen(MorePage.class);
    }

    @Step
    public ExplorePage goToExplorePage() {
        log.info("Click Explore button");
        exploreBtn.shouldBe(Condition.visible).click();
        isExploreTabSelected();
        return screen(ExplorePage.class);
    }

    @Step
    public WalletPage goToWalletPage() {
        log.info("Click Wallet button");
        walletBtn.shouldBe(Condition.visible).click();
        isWalletTabSelected();
        return screen(WalletPage.class);
    }

    @Step
    public ActivityPage goToActivityPage() {
        log.info("Click Activity button");
        activityBtn.shouldBe(Condition.visible).click();
        isActivityTabSelected();
        return screen(ActivityPage.class);
    }

    //todo: add exception handling in methods below
    public boolean isWalletTabSelected(){
        if (isAndroid()) {
            return walletBtn.is(Condition.selected);
        }
        if (isIOS()) {
            return walletBtn.getValue().equals("1");
        }
        return false;
    }

    public boolean isActivityTabSelected(){
        if (isAndroid()) {
            return activityBtn.is(Condition.selected);
        }
        if (isIOS()) {
            return activityBtn.getValue().equals("1");
        }
        return false;
    }

    public boolean isExploreTabSelected(){
        if (isAndroid()) {
            return exploreBtn.is(Condition.selected);
        }
        if (isIOS()) {
            return exploreBtn.getValue().equals("1");
        }
        return false;
    }

    public boolean isMoreTabSelected(){
        if (isAndroid()) {
            return moreBtn.is(Condition.selected);
        }
        if (isIOS()) {
            return moreBtn.getValue().equals("1");
        }
        return false;
    }
}
