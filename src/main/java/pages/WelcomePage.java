package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;
import pages.account.ImportAccountPage;
import pages.account.NameYourAccountPage;
import static infrastructure.Platform.isIOS;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static infrastructure.Platform.isAndroid;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@Log4j2
public class WelcomePage {

	@iOSXCUITFindBy(accessibility = "CREATE NEW ACCOUNT")
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/CreateNewAccount")
    private SelenideElement createAccountBtn;

	@iOSXCUITFindBy(accessibility = "Passphrase")
	@AndroidFindBy(xpath = "//*[@text=\"Passphrase\"]")
    private SelenideElement importPassphrase;

	@iOSXCUITFindBy(accessibility = "Raw seed")
	@AndroidFindBy(xpath = "//*[@text=\"Raw seed\"]")
    private SelenideElement importRawSeed;

    @iOSXCUITFindBy(accessibility = "IMPORT ACCOUNT")
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/ImportAccount")
    private SelenideElement importAccountBtn;

    public NameYourAccountPage goToCreateAccountPage() {

    	log.info("Waiting for first screen load");
    	WebDriver driver = WebDriverRunner.getWebDriver();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT5S"), Duration.parse("PT1S"));
    	wait.until(ExpectedConditions.visibilityOf(importAccountBtn));
    	log.info("Create account");
        createAccountBtn.shouldBe(Condition.visible).click();

        return screen(NameYourAccountPage.class);
    }

    public ImportAccountPage goToImportAccountPagePassphrase() {

    	log.info("Waiting for first screen load");
    	WebDriver driver = WebDriverRunner.getWebDriver();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT5S"), Duration.parse("PT1S"));
    	wait.until(ExpectedConditions.visibilityOf(importAccountBtn));
    	log.info("import account");
        importAccountBtn.shouldBe(Condition.visible).click();
        importPassphrase.click();
        

        return screen(ImportAccountPage.class);
    }

    public ImportAccountPage goToImportAccountPageRawSeed() {

    	log.info("Waiting for first screen load");
    	WebDriver driver = WebDriverRunner.getWebDriver();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT5S"), Duration.parse("PT1S"));
    	wait.until(ExpectedConditions.visibilityOf(importAccountBtn));
    	log.info("import account");
        importAccountBtn.shouldBe(Condition.visible).click();
        importRawSeed.click();

        return screen(ImportAccountPage.class);
    }
    public void welcomePageIsOpen (){
    	
    	log.info("Waiting for first screen load");
    	WebDriver driver = WebDriverRunner.getWebDriver();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.parse("PT5S"), Duration.parse("PT1S"));
    	wait.until(ExpectedConditions.visibilityOf(importAccountBtn));
        assertThat(createAccountBtn).isIn(Condition.visible);
    }
    }