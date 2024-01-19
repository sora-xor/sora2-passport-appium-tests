package jp.co.soramitsu.sora.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static jp.co.soramitsu.sora.qa.infrastructure.Platform.isAndroid;
import static jp.co.soramitsu.sora.qa.infrastructure.Platform.isIOS;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class PolkaswapPage {

    @AndroidFindBy(xpath = "//*[@text='Disclaimer']")
    @iOSXCUITFindBy(accessibility = "Disclaimer")
    private SelenideElement disclaimer;

    @AndroidFindBy(xpath = "//*[@text='Close']")
    @iOSXCUITFindBy(accessibility = "Close")
    private SelenideElement disclaimerCloseBtn;

    @AndroidFindBy(id = "SelectTokenXOR")
    @iOSXCUITFindBy(accessibility = "XOR")
    private SelenideElement selectTokenXor;

    @AndroidFindBy(id = "SelectToken")
    @iOSXCUITFindBy(accessibility = "Select token")
    private SelenideElement selectTokenItem2;

    @AndroidFindBy(xpath = "//*[@text='Select token']")
    @iOSXCUITFindBy(accessibility = "Select token")
    private SelenideElement selectTokenBtn;

    @AndroidFindBy(id = "XORElement")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"SORA\"])[2]")
    private SelenideElement xorToken;

    @AndroidFindBy(id = "VALElement")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"SORA Validator Token\"])[2]")
    private SelenideElement valToken;

    @AndroidFindBy(id = "PSWAPElement")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Polkaswap\"])[2]")
    private SelenideElement pswapToken;

    @AndroidFindBy(id = "XSTElement")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"SORA Synthetics\"])[2]")
    private SelenideElement xstToken;

    @AndroidFindBy(id = "InputAmountFieldXOR")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[1]")
    private SelenideElement inputAmountFieldXor;

    @AndroidFindBy(id = "InputAmountField")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[2]")
    private SelenideElement inputAmountField2;

    @AndroidFindBy(id = "Market")
    @iOSXCUITFindBy(accessibility = "Market")
    private SelenideElement marketField;

    @AndroidFindBy(id = "Slippage")
    @iOSXCUITFindBy(accessibility = "Slippage")
    private SelenideElement slippageField;

    @AndroidFindBy(id = "SwapButton")
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

    @Step
    public void checkAndCloseDisclaimer() {
        if (isAndroid()) {
            String actualTitle = disclaimer.shouldBe(Condition.visible).getText();
            assertThat(actualTitle).as("Disclaimer").isEqualTo("Disclaimer");
            //	Utils.scrollForward(1);
        }
        if (isIOS()) {
            disclaimer.shouldBe(Condition.visible).click();
    	/*	SelenideAppium.$x("//XCUIElementTypeStaticText[@name=\"Close\"]")
    		.scroll(down())
    		.shouldHave(visible);*/
        }
        disclaimerCloseBtn.scrollTo().shouldBe(Condition.visible).click();
    }

    @Step
    public void polkaswapSelectToken() {
        selectTokenXor.shouldBe(Condition.visible).click();
        xorToken.shouldBe(Condition.visible).click();
        selectTokenItem2.shouldBe(Condition.visible).click();
        xstToken.shouldBe(Condition.visible).click();
    }

    @Step
    public void simpleSwap(String randomValue) {
        inputAmountFieldXor.shouldBe(Condition.visible).sendKeys(randomValue);
        swapBtn.shouldBe(Condition.enabled).click();
        confirmBtn.shouldBe(Condition.visible).click();
        swappedItem.shouldBe(Condition.visible);
        closeBtn.shouldBe(Condition.visible).click();

        log.info("Entered Xor (randomValue) : " + randomValue + " XOR");
    }
}
