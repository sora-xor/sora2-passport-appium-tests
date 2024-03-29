package jp.co.soramitsu.sora.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Container;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.ScreenObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import jp.co.soramitsu.sora.qa.pages.elements.NavigationBarSection;

@Getter
@Log4j2
public class CommonPage implements Container {

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/bottomNavigationView")
    @iOSXCUITFindBy(accessibility = "Tab Bar")
    private NavigationBarSection navigationBarSection;

    //pswap button is not inside navigationBarSection
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/fabMain")
    @iOSXCUITFindBy(accessibility = "polkaswap")
    private SelenideElement polkaswapBtn;

    @Step
    public PolkaswapPage goToPolkaswapPage() {
        log.info("Click Polkaswap button");
        polkaswapBtn.shouldBe(Condition.visible).click();
        return ScreenObject.screen(PolkaswapPage.class);
    }
}
