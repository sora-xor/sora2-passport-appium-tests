package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppium;
import infrastructure.Utils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.account.AccountsPage;
import pages.account.LoginAndSecurityPage;
import pages.account.PinCodePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.AppiumScrollOptions.down;
import static com.codeborne.selenide.appium.AppiumScrollOptions.with;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.ScrollDirection.DOWN;
import static infrastructure.Platform.isAndroid;

public class MorePage extends Utils {

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
    @iOSXCUITFindBy(accessibility = "Invite Friends & Earn")
    private SelenideElement inviteFriendsBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/Information")
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
        return screen(NodesPage.class);
    }

    @Step
    public AppSettingsPage goToAppSettingsPage() {
        appSettingsBtn.shouldBe(Condition.visible).click();
        return screen(AppSettingsPage.class);
    }

    @Step
    public ReferralProgramPage goToReferralProgramPage() {
        if (isAndroid()) scrollForward(1);

        inviteFriendsBtn.shouldBe(Condition.visible).click();
        return screen(ReferralProgramPage.class);
    }
}
