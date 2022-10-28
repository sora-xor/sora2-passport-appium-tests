package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NavigationBarSection {

    @AndroidFindBy(id = "jp.co.soramitsu.sora:id/wallet_nav_graph")
    private SelenideElement walletNavGraph;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/invest_nav_graph")
    private SelenideElement investNavGraph;

    @AndroidFindBy(id = "jp.co.soramitsu.sora:id/polkaswap_nav_graph")
    private SelenideElement polkaswapNavGraph;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/fabMain")
    private SelenideElement fabMainSwap;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/activities_nav_graph")
    private SelenideElement activityNavGraph;

    @AndroidFindBy(id = "jp.co.soramitsu.sora:id/profile_nav_graph")
    private SelenideElement profileNavGraph;

}
