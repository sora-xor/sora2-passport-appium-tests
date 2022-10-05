package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NavigationBarSection {

    @AndroidFindBy(id = "jp.co.soramitsu.sora:id/wallet_nav_graph")
    private SelenideElement walletNavGraph;
}
