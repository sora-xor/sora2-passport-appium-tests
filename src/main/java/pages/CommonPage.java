package pages;

import com.codeborne.selenide.Container;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import pages.elements.NavigationBarSection;


@Log4j2
public class CommonPage implements Container {

    @Getter
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/bottomNavigationView")
    @iOSXCUITFindBy(accessibility = "Tab Bar")
    private NavigationBarSection navigationBarSection;
}
