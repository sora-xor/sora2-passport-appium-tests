package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.account.AccountOptionsPage;

import static com.codeborne.selenide.appium.ScreenObject.screen;

public class MorePage {

    @AndroidFindBy(xpath = "//*[@text='Crypto Accounts']")
    private SelenideElement cryptoAccountsBtn;

    @AndroidFindBy(xpath = "//*[@text='Nodes']")
    private SelenideElement nodesBtn;

    @AndroidFindBy(xpath = "//*[@text='App settings']")
    private SelenideElement appSettingsBtn;

    @AndroidFindBy(xpath = "//*[@text='Login & Security']")
    private SelenideElement loginAndSecurityBtn;

    @AndroidFindBy(xpath = "//*[@text='Invite Friends & Earn']")
    private SelenideElement inviteFrinedsBtn;

    @AndroidFindBy(xpath = "//*[@text='Information']")
    private SelenideElement informationBtn;


    public AccountOptionsPage goToAccounts ()
    {
        cryptoAccountsBtn.click();
        return screen(AccountOptionsPage.class);
    }
}
