package jp.co.soramitsu.sora.pages;

import com.codeborne.selenide.Container;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import jp.co.soramitsu.sora.pages.elements.NavigationBarSection;


@Getter
@Log4j2
public class CommonPage implements Container {

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/bottomNavigationView")
    @iOSXCUITFindBy(accessibility = "Tab Bar")
    private NavigationBarSection navigationBarSection;
}
