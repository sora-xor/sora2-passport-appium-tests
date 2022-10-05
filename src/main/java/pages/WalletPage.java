package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import static org.assertj.core.api.Assertions.assertThat;

public class WalletPage {

    @AndroidFindBy(id = "jp.co.soramitsu.sora:id/title")
    private SelenideElement walletTitlePage;

    @AndroidFindBy(id = "jp.co.soramitsu.sora:id/tvEmptyHistoryTitle")
    private SelenideElement emptyHistoryTitle;


    public void walletPageIsOpen (){
       String actualTitle=  walletTitlePage.shouldBe(Condition.visible).getText();
       assertThat(actualTitle).as("Wallet Page Tittle").isEqualTo("Wallet");

    }

}
