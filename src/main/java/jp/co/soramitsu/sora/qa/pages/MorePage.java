package jp.co.soramitsu.sora.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.ScreenObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import jp.co.soramitsu.sora.qa.pages.account.AccountsPage;
import jp.co.soramitsu.sora.qa.pages.account.LoginAndSecurityPage;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static jp.co.soramitsu.sora.qa.infrastructure.Platform.isAndroid;

public class MorePage extends CommonPage{


    @AndroidFindBy(id = "CryptoAccountsButton")
    @iOSXCUITFindBy(accessibility = "Crypto Accounts")
    private SelenideElement cryptoAccountsBtn;

    @AndroidFindBy(id = "SoraCard")
    //@iOSXCUITFindBy(accessibility = "Sora Card")
    private SelenideElement soraCardBtn;

    @AndroidFindBy(id = "BuyXor")
    //@iOSXCUITFindBy(accessibility = "Buy Xor with fiat")
    private SelenideElement buyXORbyFiatBtn;

    @AndroidFindBy(id = "Nodes")
    @iOSXCUITFindBy(accessibility = "Nodes")
    private SelenideElement nodesBtn;

    @AndroidFindBy(id = "AppSettings")
    @iOSXCUITFindBy(accessibility = "App settings")
    private SelenideElement appSettingsBtn;

    @AndroidFindBy(id = "LoginAndSecurity")
    @iOSXCUITFindBy(accessibility = "Login & Security")
    private SelenideElement loginAndSecurityBtn;

    @AndroidFindBy(id = "Invite")
    @iOSXCUITFindBy(accessibility = "Invite Friends & Earn")
    private SelenideElement inviteFriendsBtn;

    @AndroidFindBy(id = "Information")
    @iOSXCUITFindBy(accessibility = "Information")
    private SelenideElement informationBtn;


    @Step
    public AccountsPage goToAccounts() {
        cryptoAccountsBtn.shouldBe(Condition.visible).click();
        return screen(AccountsPage.class);
    }

    @Step
    public BuyXorPage goToBuyXorWithFiat() {
        if (isAndroid()) buyXORbyFiatBtn.shouldBe(Condition.visible).click();
        return screen(BuyXorPage.class);
    }

    @Step
    public LoginAndSecurityPage goToLoginAndSecurity() {
        loginAndSecurityBtn.shouldBe(Condition.visible).click();
        return screen(LoginAndSecurityPage.class);
    }

    @Step
    public NodesPage goToNodesPage() {
        nodesBtn.shouldBe(Condition.visible).click();
        return ScreenObject.screen(NodesPage.class);
    }

    @Step
    public AppSettingsPage goToAppSettingsPage() {
        appSettingsBtn.shouldBe(Condition.visible).click();
        return screen(AppSettingsPage.class);
    }

    @Step
    public ReferralProgramPage goToReferralProgramPage()
    {
        inviteFriendsBtn.scrollTo().shouldBe(Condition.visible).click();
        return screen(ReferralProgramPage.class);
    }
}
