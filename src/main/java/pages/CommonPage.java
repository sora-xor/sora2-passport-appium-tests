package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import static com.codeborne.selenide.appium.ScreenObject.screen;

public class CommonPage extends ElementsContainer {

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/bottomNavigationView")
    @iOSXCUITFindBy(accessibility = "Tab Bar")
    private NavigationBarSection navigationBarSection;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/fabMain")
    @iOSXCUITFindBy(accessibility = "polkaswap")
    private SelenideElement polkaswapBarBtn;


    public NavigationBarSection getNavigationBarSection()
    {
        return navigationBarSection;
    }

    public PolkaswapPage goToPolkaswapPage ()
    {
        polkaswapBarBtn.shouldBe(Condition.visible).click();
        return screen(PolkaswapPage.class);
    }

}
