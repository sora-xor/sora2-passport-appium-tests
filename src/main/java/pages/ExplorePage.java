package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ExplorePage {
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/AddLiquidity")
    @iOSXCUITFindBy(accessibility = "")
    private SelenideElement addLiquidityBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/PrimaryButton")
    @iOSXCUITFindBy(accessibility = "")
    private SelenideElement primaryBtn;

    @AndroidFindBy(xpath = "//*[@text='Supply liquidity']")
    @iOSXCUITFindBy(accessibility = "")
    private SelenideElement supplyLiquidityTitle;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/InputAmountFieldXOR")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[1]")
    private SelenideElement inputAmountFieldXor;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SelectToken")
    @iOSXCUITFindBy(accessibility = "Select token")
    private SelenideElement selectTokenItem2;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/InputAmountField")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[2]")
    private SelenideElement inputAmountField2;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SelectTokenXOR")
    @iOSXCUITFindBy(accessibility = "XOR")
    private SelenideElement selectTokenXor;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/XORElement")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"SORA\"`][2]")
    private SelenideElement xorToken;
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/XSTElement")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"SORA Synthetics\"`][2]")
    private SelenideElement xstToken;

    @AndroidFindBy(xpath = "//*[@text='Supply']")
    @iOSXCUITFindBy(accessibility = "")
    private SelenideElement supplyeBtn;

    @AndroidFindBy(xpath = "//*[@text='Confirm']")
    @iOSXCUITFindBy(accessibility = "")
    private SelenideElement confirmBtn;

    @AndroidFindBy(xpath = "//*[@text='Close']")
    @iOSXCUITFindBy(accessibility = "")
    private SelenideElement closeBtn;



    public void addLiquidty(String randomLiquidity)
    {
        addLiquidityBtn.shouldBe(Condition.visible).click();
        supplyLiquidityTitle.shouldBe(Condition.visible).exists();
        selectTokenXor.shouldBe(Condition.visible).click();
        xorToken.shouldBe(Condition.visible).click();
        inputAmountFieldXor.shouldBe(Condition.visible).sendKeys(randomLiquidity);
        selectTokenItem2.shouldBe(Condition.visible).click();
        xstToken.shouldBe(Condition.visible).click();
        supplyeBtn.shouldBe(Condition.visible).click();
        confirmBtn.shouldBe(Condition.visible).click();
        closeBtn.shouldBe(Condition.visible).click();

        log.info("Entered Xor (randomLiquidity) : "+randomLiquidity+" XOR");
    }
}