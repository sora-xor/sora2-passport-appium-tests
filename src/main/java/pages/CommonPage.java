package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Container;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@Log4j2
public class CommonPage implements Container {

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/bottomNavigationView")
    @iOSXCUITFindBy(accessibility = "Tab Bar")
    private NavigationBarSection navigationBarSection;

    @AndroidFindBy(accessibility = "Activity")
    @iOSXCUITFindBy(accessibility = "Activity")
    private SelenideElement activityBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/fabMain")
    @iOSXCUITFindBy(accessibility = "polkaswap")
    private SelenideElement polkaswapBarBtn;


    public NavigationBarSection getNavigationBarSection() {
        return navigationBarSection;
    }

    @Step
    public PolkaswapPage goToPolkaswapPage() {
        polkaswapBarBtn.shouldBe(Condition.visible).click();
        return screen(PolkaswapPage.class);
    }

    @Step
    public ActivityPage goToActivityPage() {
        log.info("Click Activity button");
        activityBtn.shouldBe(Condition.visible).click();
        return screen(ActivityPage.class);
    }
}
