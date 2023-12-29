package jp.co.soramitsu.sora.pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Container;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import jp.co.soramitsu.sora.pages.*;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static jp.co.soramitsu.sora.infrastructure.Platform.isAndroid;
import static jp.co.soramitsu.sora.infrastructure.Platform.isIOS;

@Log4j2
public class NavigationBarSection implements Container {

    @AndroidFindBy(accessibility = "Wallet")
    @iOSXCUITFindBy(accessibility = "Assets")
    private SelenideElement walletBtn;

    @AndroidFindBy(accessibility = "Explore")
    @iOSXCUITFindBy(accessibility = "Explore")
    private SelenideElement exploreBtn;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Polkaswap\"]")
    @iOSXCUITFindBy(accessibility = "polkaswap")
    private SelenideElement polkaswapBtn;

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
        return screen(MorePage.class);
    }

    @Step
    public PolkaswapPage goToPolkaswapPage() {
        log.info("Click Polkaswap button");
        polkaswapBtn.shouldBe(Condition.visible).click();
        return screen(PolkaswapPage.class);
    }

    @Step
    public ExplorePage goToExplorePage() {
        log.info("Click Explore button");
        exploreBtn.shouldBe(Condition.visible).click();
        return screen(ExplorePage.class);
    }

    @Step
    public WalletPage goToWalletPage() {
        log.info("Click Wallet button");
        walletBtn.shouldBe(Condition.visible).click();
        return screen(WalletPage.class);
    }

    @Step
    public ActivityPage goToActivityPage() {
        log.info("Click Activity button");
        activityBtn.shouldBe(Condition.visible).click();
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
