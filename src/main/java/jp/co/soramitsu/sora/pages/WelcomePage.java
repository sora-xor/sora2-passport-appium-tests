package jp.co.soramitsu.sora.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import jp.co.soramitsu.sora.pages.account.AccountsPage;
import jp.co.soramitsu.sora.pages.account.ImportAccountPage;
import jp.co.soramitsu.sora.pages.account.NameYourAccountPage;
import jp.co.soramitsu.sora.pages.account.PinCodePage;
import lombok.extern.log4j.Log4j2;

import static jp.co.soramitsu.sora.infrastructure.Platform.isIOS;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static jp.co.soramitsu.sora.infrastructure.Platform.isAndroid;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.ScreenObject.screen;

@Log4j2
public class WelcomePage {

    @iOSXCUITFindBy(accessibility = "Create account")
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/CreateNewAccount")
    private SelenideElement createAccountBtn;

    @iOSXCUITFindBy(accessibility = "Passphrase")
    @AndroidFindBy(xpath = "//*[@text=\"Passphrase\"]")
    private SelenideElement importPassphrase;

    @iOSXCUITFindBy(accessibility = "Raw seed")
    @AndroidFindBy(xpath = "//*[@text=\"Raw seed\"]")
    private SelenideElement importRawSeed;

    @iOSXCUITFindBy(accessibility = "Import account")
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/ImportAccount")
    private SelenideElement importAccountBtn;

    @AndroidFindBy(xpath = "//*[@text='Enter Pin Code']")
    @iOSXCUITFindBy(accessibility = "Enter Pin Code")
    private SelenideElement pinCodeTitleTv;

    @Step
    public NameYourAccountPage goToCreateAccountPage() {

        log.info("Waiting for first screen load");
        WebDriver driver = WebDriverRunner.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT5S"), Duration.parse("PT1S"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(createAccountBtn),
                ExpectedConditions.visibilityOf(pinCodeTitleTv)));
        if (pinCodeTitleTv.is(Condition.visible)) {
            log.info("Already logged in. Logout needed.");
            WalletPage walletPage = enterPinCode();
            MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
            AccountsPage accountsPage = morePage.goToAccounts();
            PinCodePage enterCodePage = accountsPage.forgetAccount();
            enterCodePage.enterPinCodeOnLogout();
            WebDriverWait wait_again = new WebDriverWait(driver, Duration.parse("PT5S"), Duration.parse("PT1S"));
            wait_again.until(ExpectedConditions.visibilityOf(createAccountBtn));

        }

        log.info("Create account");
        createAccountBtn.shouldBe(Condition.visible).click();

        return screen(NameYourAccountPage.class);
    }

    @Step
    public ImportAccountPage goToImportAccountPagePassphrase() {

        log.info("Waiting for first screen load");
        WebDriver driver = WebDriverRunner.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT5S"), Duration.parse("PT1S"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(importAccountBtn),
                ExpectedConditions.visibilityOf(pinCodeTitleTv)));

        if (pinCodeTitleTv.is(Condition.visible)) {
            log.info("Already logged in. Logout needed.");
            WalletPage walletPage = enterPinCode();
            MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
            AccountsPage accountsPage = morePage.goToAccounts();
            PinCodePage enterCodePage = accountsPage.forgetAccount();
            enterCodePage.enterPinCodeOnLogout();
            WebDriverWait wait_again = new WebDriverWait(driver, Duration.parse("PT5S"), Duration.parse("PT1S"));
            wait_again.until(ExpectedConditions.visibilityOf(importAccountBtn));

        }
        log.info("import account");
        importAccountBtn.shouldBe(Condition.visible).click();
        importPassphrase.click();


        return screen(ImportAccountPage.class);
    }

    @Step
    public ImportAccountPage goToImportAccountPageRawSeed() {

        log.info("Waiting for first screen load");
        WebDriver driver = WebDriverRunner.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT5S"), Duration.parse("PT1S"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(importAccountBtn),
                ExpectedConditions.visibilityOf(pinCodeTitleTv)));

        if (pinCodeTitleTv.is(Condition.visible)) {
            log.info("Already logged in. Logout needed.");
            WalletPage walletPage = enterPinCode();
            MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
            AccountsPage accountsPage = morePage.goToAccounts();
            PinCodePage enterCodePage = accountsPage.forgetAccount();
            enterCodePage.enterPinCodeOnLogout();
            WebDriverWait wait_again = new WebDriverWait(driver, Duration.parse("PT5S"), Duration.parse("PT1S"));
            wait_again.until(ExpectedConditions.visibilityOf(importAccountBtn));

        }
        log.info("import account");
        importAccountBtn.shouldBe(Condition.visible).click();
        importRawSeed.click();

        return screen(ImportAccountPage.class);
    }

    @Step
    public void welcomePageIsOpen() {

        log.info("Waiting for first screen load");
        WebDriver driver = WebDriverRunner.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT5S"), Duration.parse("PT1S"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(importAccountBtn),
                ExpectedConditions.visibilityOf(pinCodeTitleTv)));

        if (pinCodeTitleTv.is(Condition.visible)) {
            log.info("Already logged in. Logout needed.");
            WalletPage walletPage = enterPinCode();
            MorePage morePage = walletPage.getNavigationBarSection().goToMorePage();
            AccountsPage accountsPage = morePage.goToAccounts();
            PinCodePage enterCodePage = accountsPage.forgetAccount();
            enterCodePage.enterPinCodeOnLogout();
            WebDriverWait wait_again = new WebDriverWait(driver, Duration.parse("PT5S"), Duration.parse("PT1S"));
            wait_again.until(ExpectedConditions.visibilityOf(importAccountBtn));
        }
    }

    @Step
    public WalletPage enterPinCode() {
        log.info("Enter Pin Code");
        if (isAndroid()) {
            for (int i = 1; i <= 6; i++) {
                $(By.id("jp.co.soramitsu.sora.develop:id/" + i)).click();
            }
        }
        if (isIOS()) {
            assertThat(pinCodeTitleTv.isDisplayed()).isTrue();
            for (int i = 1; i <= 6; i++) {
                $(By.name("" + i)).click();
            }
        }
        return screen(WalletPage.class);
    }
}