package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import infrastructure.Utils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;
import pages.WalletPage;

import static com.codeborne.selenide.appium.ScreenObject.screen;

@Log4j2
public class SoraCardDetailsPage {
    @AndroidFindBy(id ="jp.co.soramitsu.sora.develop:id/TOP_UP")
    private SelenideElement soraCardTopUpBtn;

    @AndroidFindBy(id ="jp.co.soramitsu.sora.develop:id/TRANSFER")
    private SelenideElement soraCardTransferBtn;

    @AndroidFindBy(id ="jp.co.soramitsu.sora.develop:id/EXCHANGE")
    private SelenideElement soraCardExchangeBtn;

    @AndroidFindBy(id ="jp.co.soramitsu.sora.develop:id/FREEZE")
    private SelenideElement soraCardFreezeBtn;

    @AndroidFindBy(xpath = "//*[@text='IBAN account details']")
    private SelenideElement IBANlabel;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.TextView[2]")
    private SelenideElement IBANdetails;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/LOG_OUT")
    private SelenideElement logOutSoraCardBtn;
    @AndroidFindBy(xpath = "//*[@text='Logout']")
    private SelenideElement logOutConfirmBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/IbanCardShareClick")
    private SelenideElement shareIBANCard;


    public WalletPage checkIBAN ()
    {
        IBANlabel.shouldBe(Condition.visible);
        String getIBANdetails  = "";
        getIBANdetails =  IBANdetails.shouldBe(Condition.visible).getText();
        log.info("IBAN account details: " + getIBANdetails);
        shareIBANCard.shouldBe(Condition.visible);
        Utils.scrollForward(1);
        logOutSoraCardBtn.shouldBe(Condition.visible).click();
        logOutConfirmBtn.shouldBe(Condition.visible).click();
        return screen(WalletPage.class);
    }
}
