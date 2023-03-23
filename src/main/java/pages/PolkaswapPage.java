package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
@Log4j2
public class PolkaswapPage extends CommonPage {

    @AndroidFindBy(xpath = "//*[@text='Disclaimer']")
    @iOSXCUITFindBy(accessibility = "Disclaimer")
    private SelenideElement disclaimer;

    @AndroidFindBy(xpath = "//*[@text='CLOSE']")
    @iOSXCUITFindBy(accessibility = "CLOSE")
    private SelenideElement disclaimerCloseBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SelectTokenXOR")
    @iOSXCUITFindBy(accessibility = "Select token item")
    private SelenideElement selectTokenXor;


    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SelectToken")
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


    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/InputAmountFieldXOR")
    @iOSXCUITFindBy(accessibility = "inputAmountField")
    private SelenideElement inputAmountFieldXor;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/InputAmountField")
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
        selectTokenXor.shouldBe(Condition.visible).click();
        xorToken.shouldBe(Condition.visible).click();
        selectTokenItem2.shouldBe(Condition.visible).click();
        xstToken.shouldBe(Condition.visible).click();
    }

    public void SimpleSwap(String randomValue)
    {
        inputAmountFieldXor.shouldBe(Condition.visible).sendKeys(randomValue);
        String enteredXorValue = inputAmountFieldXor.shouldBe(Condition.visible).getText();
        swapBtn.shouldBe(Condition.enabled).click();
        confirmBtn.shouldBe(Condition.visible).click();
        swappedItem.shouldBe(Condition.visible);
        closeBtn.shouldBe(Condition.visible).click();

        log.info("Entered Xor (randomValue) : "+randomValue+" XOR");

    }



}
