package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static org.assertj.core.api.Assertions.assertThat;

public class WalletPage extends CommonPage {

    @AndroidFindBy(xpath = "//*[@text='Liquid assets']")
    private SelenideElement liquidAssets;
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/title")
    private SelenideElement walletTitlePage;

    @AndroidFindBy(id = "jp.co.soramitsu.develop.sora.develop:id/tvEmptyHistoryTitle")
    private SelenideElement emptyHistoryTitle;


    public void walletPageIsOpen (){
       String actualTitle = liquidAssets.shouldBe(Condition.visible).getText();
       assertThat(actualTitle).as("Liquid assets title").isEqualTo("Liquid assets");
    }
//    public NavigationBarSection getNavigationBarSection()
//    {
//        return navigationBarSection;
//
//    }

}
