package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppium;

import infrastructure.Utils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;

import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumScrollOptions.down;
import static com.codeborne.selenide.appium.AppiumScrollOptions.with;
import static com.codeborne.selenide.appium.ScrollDirection.DOWN;
import static infrastructure.Platform.isAndroid;
import static infrastructure.Platform.isIOS;
import static org.assertj.core.api.Assertions.assertThat;
@Log4j2
public class PolkaswapPage extends CommonPage {

    Utils utils = new Utils();

    @AndroidFindBy(xpath = "//*[@text='Disclaimer']")
    @iOSXCUITFindBy(accessibility = "Disclaimer")
    private SelenideElement disclaimer;

    @AndroidFindBy(xpath = "//*[@text='Close']")
    @iOSXCUITFindBy(accessibility = "Close")
    private SelenideElement disclaimerCloseBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SelectTokenXOR")
    @iOSXCUITFindBy(accessibility = "XOR")
    private SelenideElement selectTokenXor;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SelectToken")
    @iOSXCUITFindBy(accessibility = "Select token")
    private SelenideElement selectTokenItem2;

    @AndroidFindBy(xpath = "//*[@text='Select token']")
    @iOSXCUITFindBy(accessibility = "Select token")
    private SelenideElement selectTokenBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/XORElement")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"SORA\"`][2]")
    private SelenideElement xorToken;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/VALElement")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"SORA Validator Token\"`][2]")
    private SelenideElement valToken;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/PSWAPElement")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Polkaswap\"`][2]")
    private SelenideElement pswapToken;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/XSTElement")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"SORA Synthetics\"`][2]")
    private SelenideElement xstToken;


    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/InputAmountFieldXOR")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[1]")
    private SelenideElement inputAmountFieldXor;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/InputAmountField")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[2]")
    private SelenideElement inputAmountField2;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/Market")
    @iOSXCUITFindBy(accessibility = "Market")
    private SelenideElement marketField;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/Slippage")
    @iOSXCUITFindBy(accessibility = "Slippage")
    private SelenideElement slippageField;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SwapButton")
    @iOSXCUITFindBy(accessibility = "Review")
    private SelenideElement swapBtn;

    @AndroidFindBy(xpath = "//*[@text='Confirm']")
    @iOSXCUITFindBy(accessibility = "Confirm")
    private SelenideElement confirmBtn;

    @AndroidFindBy(accessibility = "Swapped")
    @iOSXCUITFindBy(accessibility = "Extrinsic hash")
    private SelenideElement swappedItem;

    @AndroidFindBy(xpath = "//*[@text='Close']")
    @iOSXCUITFindBy(accessibility = "Close")
    private SelenideElement closeBtn;

    public void PolkaswapPageIsOpen (){
    	if (isAndroid()) {
    		String actualTitle = disclaimer.shouldBe(Condition.visible).getText();
    		assertThat(actualTitle).as("Disclaimer").isEqualTo("Disclaimer");
    	}
    	if (isIOS()) {
    		disclaimer.shouldBe(Condition.visible).click();
    		SelenideAppium.$x("//XCUIElementTypeStaticText[@name=\"Close\"]")
    		.scroll(down())
    		.shouldHave(visible);
    	}
        utils.scrollForward(1);
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
        swapBtn.shouldBe(Condition.enabled).click();
        confirmBtn.shouldBe(Condition.visible).click();
        swappedItem.shouldBe(Condition.visible);
        closeBtn.shouldBe(Condition.visible).click();

        log.info("Entered Xor (randomValue) : "+randomValue+" XOR");

    }



}
