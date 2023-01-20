package pages;

import com.codeborne.selenide.ElementsContainer;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CommonPage extends ElementsContainer {

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/bottomNavigationView")
    private NavigationBarSection navigationBarSection;

    public NavigationBarSection getNavigationBarSection()
    {
        return navigationBarSection;
    }

}
