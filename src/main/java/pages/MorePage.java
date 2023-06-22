package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import pages.account.AccountsPage;
import pages.account.LoginAndSecurityPage;
import pages.account.PinCodePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumScrollOptions.down;
import static com.codeborne.selenide.appium.AppiumScrollOptions.with;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.ScrollDirection.DOWN;

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

    public LoginAndSecurityPage goToLoginAndSecurity ()
    {
        loginAndSecurityBtn.shouldBe(Condition.visible).click();
        return screen(LoginAndSecurityPage.class);
    }

    public NodesPage goToNodesPage ()
    {
        nodesBtn.shouldBe(Condition.visible).click();
        return screen(NodesPage.class);
    }

    public AppSettingsPage goToAppSettingsPage ()
    {
        appSettingsBtn.shouldBe(Condition.visible).click();
        return screen(AppSettingsPage.class);
    }

    public ReferralProgramPage goToReferralProgramPage()
    {
        inviteFrinedsBtn.shouldBe(Condition.visible).click();
        return screen(ReferralProgramPage.class);
    }
}
