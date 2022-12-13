package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.codeborne.selenide.appium.ScreenObject.screen;

public class PassphrasePage {

    @AndroidFindBy(xpath = "//*[@text='SKIP']")
    private SelenideElement skipBtn;

    public PinCodePage skipPassPhrase () {

        skipBtn.shouldBe(Condition.visible).click();
        return screen(PinCodePage.class);
    }
}
