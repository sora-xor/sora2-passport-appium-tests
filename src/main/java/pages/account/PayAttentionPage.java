package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static infrastructure.Platform.isAndroid;
import static infrastructure.Platform.isIOS;

public class PayAttentionPage {

    @AndroidFindBy(xpath = "//*[@text='If I lose my passphrase, my funds will be lost forever.']")
    private SelenideElement loseMyPassphraseCheckbox;
    
    @AndroidFindBy(xpath = "//*[@text='If I expose or share my passphrase to anybody, my funds can get stolen.']")
    private SelenideElement exposeOrShareCheckbox;
    
    @AndroidFindBy(xpath = "//*[@text='It is my full reponsibility to keep my passphrase secure.']")
    private SelenideElement responsibilityCheckbox;
    
    @iOSXCUITFindBy(xpath = "///XCUIElementTypeButton[@name=\"CONTINUE\"]")
    @AndroidFindBy(xpath = "//*[@text='CONTINUE']")
    private SelenideElement nextBtn;

    public PassphrasePage confirmPayAttention () {
    	if (isAndroid())  {
    		loseMyPassphraseCheckbox.shouldBe(Condition.visible).click();
    		exposeOrShareCheckbox.shouldBe(Condition.visible).click();
    		responsibilityCheckbox.shouldBe(Condition.visible).click();
    	}
    	nextBtn.shouldBe(Condition.visible).click();
        return screen(PassphrasePage.class);
    }
}
