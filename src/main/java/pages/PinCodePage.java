package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static org.assertj.core.api.Assertions.assertThat;

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

    public WalletPage enterAndConfirmPinCode () {
        $(By.id("jp.co.soramitsu.sora:id/btn"));

        for (int i =  1; i <= 6; i++)
        {
            $(By.id("jp.co.soramitsu.sora:id/btn"+i)).click();
        }
        assertThat(pinCodeTitleTv.getText()).isEqualTo("Confirm pin code");

        for (int i =  1; i <= 6; i++)
        {
            $(By.id("jp.co.soramitsu.sora:id/btn"+i)).click();
        }

        return screen(WalletPage.class);
    }
}
