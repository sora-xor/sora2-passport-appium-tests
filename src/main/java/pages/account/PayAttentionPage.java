package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.codeborne.selenide.appium.ScreenObject.screen;

public class PayAttentionPage {

    @AndroidFindBy(xpath = "//*[@text='If I lose my passphrase, my funds will be lost forever.']")
    private SelenideElement loseMyPassphraseCheckbox;
    @AndroidFindBy(xpath = "//*[@text='If I expose or share my passphrase to anybody, my funds can get stolen.']")
    private SelenideElement exposeOrShareCheckbox;
    @AndroidFindBy(xpath = "//*[@text='It is my full reponsibility to keep my passphrase secure.']")
    private SelenideElement responsibilityCheckbox;
    @AndroidFindBy(xpath = "//*[@text='CONTINUE']")
    private SelenideElement nextBtn;

    public PassphrasePage confirmPayAttention () {
        loseMyPassphraseCheckbox.shouldBe(Condition.visible).click();
        exposeOrShareCheckbox.shouldBe(Condition.visible).click();
        responsibilityCheckbox.shouldBe(Condition.visible).click();
        nextBtn.shouldBe(Condition.visible).click();
        return screen(PassphrasePage.class);
    }
}
