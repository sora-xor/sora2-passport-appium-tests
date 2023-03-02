package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class PolkaswapPage extends CommonPage {

    @AndroidFindBy(xpath = "//*[@text='Disclaimer']")
    @iOSXCUITFindBy(accessibility = "Disclaimer")
    private SelenideElement disclaimer;

    @AndroidFindBy(xpath = "//*[@text='CLOSE']")
    @iOSXCUITFindBy(accessibility = "CLOSE")
    private SelenideElement disclaimerCloseBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(accessibility = "Select token item")
    private SelenideElement selectTokenItem1;


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView[4]")
    @iOSXCUITFindBy(accessibility = "Select token item")
    private SelenideElement selectTokenItem2;

    @AndroidFindBy(xpath = "//*[@text='Select token']")
    @iOSXCUITFindBy(accessibility = "Select token")
    private SelenideElement selectTokenBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/XORElement")
    @iOSXCUITFindBy(accessibility = "XORElement")
    private SelenideElement xorToken;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/VALElement")
    @iOSXCUITFindBy(accessibility = "VALElement")
    private SelenideElement valToken;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/PSWAPElement")
    @iOSXCUITFindBy(accessibility = "PSWAPElement")
    private SelenideElement pswapToken;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/XSTElement")
    @iOSXCUITFindBy(accessibility = "XSTElement")
    private SelenideElement xstToken;


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText[1]")
    @iOSXCUITFindBy(accessibility = "inputAmountField")
    private SelenideElement inputAmountField1;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText[2]")
    @iOSXCUITFindBy(accessibility = "inputAmountField")
    private SelenideElement inputAmountField2;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/Market")
    @iOSXCUITFindBy(accessibility = "Market")
    private SelenideElement marketField;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/Slippage")
    @iOSXCUITFindBy(accessibility = "Slippage")
    private SelenideElement slippageField;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SwapButton")
    @iOSXCUITFindBy(accessibility = "Swap")
    private SelenideElement swapBtn;

    @AndroidFindBy(xpath = "//*[@text='CONFIRM']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\'CONFIRM']")
    private SelenideElement confirmBtn;

    @AndroidFindBy(accessibility = "Swapped")
    @iOSXCUITFindBy(accessibility = "Swapped")
    private SelenideElement swappedItem;

    @AndroidFindBy(xpath = "//*[@text='CLOSE']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\'CLOSE']")
    private SelenideElement closeBtn;

    public void PolkaswapPageIsOpen (){
        String actualTitle = disclaimer.shouldBe(Condition.visible).getText();
        assertThat(actualTitle).as("Disclaimer").isEqualTo("Disclaimer");
        disclaimerCloseBtn.shouldBe(Condition.visible).click();
    }

    public void PolkaswapSelectToken() {
        selectTokenItem1.shouldBe(Condition.visible).click();
        xorToken.shouldBe(Condition.visible).click();
        selectTokenItem2.shouldBe(Condition.visible).click();
        xstToken.shouldBe(Condition.visible).click();
    }

    public void SimpleSwap()
    {
        inputAmountField1.shouldBe(Condition.visible).sendKeys("1");
        swapBtn.shouldBe(Condition.enabled).click();
        confirmBtn.shouldBe(Condition.visible).click();
        swappedItem.shouldBe(Condition.visible);
        closeBtn.shouldBe(Condition.visible).click();

    }



}
