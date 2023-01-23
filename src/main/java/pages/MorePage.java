package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import pages.account.AccountOptionsPage;
import pages.account.AccountsPage;

import static com.codeborne.selenide.appium.ScreenObject.screen;

public class MorePage {

    @AndroidFindBy(xpath = "//*[@text='Crypto Accounts']")
    @iOSXCUITFindBy(accessibility = "Crypto Accounts")
    private SelenideElement cryptoAccountsBtn;

    @AndroidFindBy(xpath = "//*[@text='Nodes']")
    @iOSXCUITFindBy(accessibility = "Nodes")
    private SelenideElement nodesBtn;

    @AndroidFindBy(xpath = "//*[@text='App settings']")
    @iOSXCUITFindBy(accessibility = "App settings")
    private SelenideElement appSettingsBtn;

    @AndroidFindBy(xpath = "//*[@text='Login & Security']")
    @iOSXCUITFindBy(accessibility = "Login & Security")
    private SelenideElement loginAndSecurityBtn;

    @AndroidFindBy(xpath = "//*[@text='Invite Friends & Earn']")
    private SelenideElement inviteFrinedsBtn;

    @AndroidFindBy(xpath = "//*[@text='Information']")
    @iOSXCUITFindBy(accessibility = "Information")
    private SelenideElement informationBtn;


    public AccountsPage goToAccounts ()
    {
        cryptoAccountsBtn.click();
        return screen(AccountsPage.class);
    }
}
