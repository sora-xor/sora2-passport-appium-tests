package pages;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.appium.ScreenObject.screen;
@Log4j2
public class NavigationBarSection extends ElementsContainer {

    @AndroidFindBy(accessibility ="Assets")
    private SelenideElement assetsBtn;

    @AndroidFindBy(accessibility ="Invest")
    private SelenideElement investBtn;

    @AndroidFindBy(accessibility ="Swap")
    private SelenideElement swapBtn;

    @AndroidFindBy(accessibility ="Activity")
    private SelenideElement activityBtn;
    @AndroidFindBy(accessibility ="More")
    private SelenideElement moreBtn;


    public MorePage goToMorePage()
    {
        log.info("Click more button");
        moreBtn.click();
        return screen(MorePage.class);
    }

}
