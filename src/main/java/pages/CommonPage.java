package pages;

import com.codeborne.selenide.ElementsContainer;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CommonPage extends ElementsContainer {

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/bottomNavigationView")
    @iOSXCUITFindBy(accessibility = "Tab Bar")
    private NavigationBarSection navigationBarSection;

    public NavigationBarSection getNavigationBarSection()
    {
        return navigationBarSection;
    }

}
