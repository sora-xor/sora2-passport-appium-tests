package pages;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.appium.ScreenObject.screen;
@Log4j2
public class NavigationBarSection extends ElementsContainer {

    @AndroidFindBy(accessibility ="Assets")
    @iOSXCUITFindBy(accessibility = "Assets")
    private SelenideElement assetsBtn;

    @AndroidFindBy(accessibility ="Invest")
    @iOSXCUITFindBy(accessibility = "Discover")
    private SelenideElement investBtn;

    @AndroidFindBy(accessibility ="Swap")
    @iOSXCUITFindBy(accessibility = "Swap")
    private SelenideElement swapBtn;

    @AndroidFindBy(accessibility ="Activity")
    @iOSXCUITFindBy(accessibility = "Activity")
    private SelenideElement activityBtn;
    
    @AndroidFindBy(accessibility ="More")
    @iOSXCUITFindBy(accessibility = "More")
    private SelenideElement moreBtn;


    public MorePage goToMorePage()
    {
        log.info("Click more button");
        moreBtn.click();
        return screen(MorePage.class);
    }

}
