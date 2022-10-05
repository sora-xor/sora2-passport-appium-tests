package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.codeborne.selenide.appium.ScreenObject.screen;

public class PinCodePage {

    @AndroidFindBy(id = "jp.co.soramitsu.sora:id/pinCodeTitleTv")
    private SelenideElement pinCodeTitleTv;

    @AndroidFindBy(id = "jp.co.soramitsu.sora:id/btn0")
    private SelenideElement pinCodeBtn0;

    @AndroidFindBy(id = "jp.co.soramitsu.sora:id/btn1")
    private SelenideElement pinCodeBtn1;

    @AndroidFindBy(id = "jp.co.soramitsu.sora:id/btn2")
    private SelenideElement pinCodeBtn2;

    @AndroidFindBy(id = "jp.co.soramitsu.sora:id/btn3")
    private SelenideElement pinCodeBtn3;

    @AndroidFindBy(id = "jp.co.soramitsu.sora:id/btn3")
    private SelenideElement pinCodeBtn4;

    @AndroidFindBy(id = "jp.co.soramitsu.sora:id/btn3")
    private SelenideElement pinCodeBtn5;

    public WalletPage enterAndConfirmPinCode() {

        //Enter Pin Code
        pinCodeBtn0.shouldBe(Condition.visible).click();
        pinCodeBtn1.shouldBe(Condition.visible).click();
        pinCodeBtn2.shouldBe(Condition.visible).click();
        pinCodeBtn3.shouldBe(Condition.visible).click();
        pinCodeBtn4.shouldBe(Condition.visible).click();
        pinCodeBtn5.shouldBe(Condition.visible).click();

        //Confirm Pin Code

        pinCodeBtn0.shouldBe(Condition.visible).click();
        pinCodeBtn1.shouldBe(Condition.visible).click();
        pinCodeBtn2.shouldBe(Condition.visible).click();
        pinCodeBtn3.shouldBe(Condition.visible).click();
        pinCodeBtn4.shouldBe(Condition.visible).click();
        pinCodeBtn5.shouldBe(Condition.visible).click();

        return screen(WalletPage.class);
    }
}
