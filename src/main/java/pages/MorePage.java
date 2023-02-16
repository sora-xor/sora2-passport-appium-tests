package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import pages.account.AccountOptionsPage;
import pages.account.AccountsPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.appium.ScreenObject.screen;

public class MorePage {

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/CryptoAccountsButton")
    @iOSXCUITFindBy(accessibility = "Crypto Accounts")
    private SelenideElement cryptoAccountsBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SoraCard")
    //@iOSXCUITFindBy(accessibility = "Sora Card")
    private SelenideElement soraCardBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/BuyXor")
    //@iOSXCUITFindBy(accessibility = "Buy Xor with fiat")
    private SelenideElement buyXORbyFiatBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/Nodes")
    @iOSXCUITFindBy(accessibility = "Nodes")
    private SelenideElement nodesBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/AppSettings")
    @iOSXCUITFindBy(accessibility = "App settings")
    private SelenideElement appSettingsBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/LoginAndSecurity")
    @iOSXCUITFindBy(accessibility = "Login & Security")
    private SelenideElement loginAndSecurityBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/Invite")
    private SelenideElement inviteFrinedsBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/Information")
    @iOSXCUITFindBy(accessibility = "Information")
    private SelenideElement informationBtn;


    public AccountsPage goToAccounts ()
    {
        cryptoAccountsBtn.shouldBe(Condition.visible).click();
        return screen(AccountsPage.class);
    }

    public BuyXorPage goToBuyXorWithFiat ()
    {
        buyXORbyFiatBtn.shouldBe(Condition.visible).click();
        return screen(BuyXorPage.class);
    }
}
