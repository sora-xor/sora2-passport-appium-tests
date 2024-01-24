package jp.co.soramitsu.sora.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static jp.co.soramitsu.sora.qa.infrastructure.Platform.isAndroid;
import static jp.co.soramitsu.sora.qa.infrastructure.Platform.isIOS;

@Log4j2
public class ExplorePage extends CommonPage{

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Pools\"]")
    @iOSXCUITFindBy(accessibility = "Pools")
    private SelenideElement poolButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Farming\"]")
    @iOSXCUITFindBy(accessibility = "Farming")
    private SelenideElement farmingButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Currencies\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Currencies\"])[1]")
    private SelenideElement currenciesButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Provide liquidity and earn rewards\"]/following-sibling::android.widget.ImageView")
    @iOSXCUITFindBy(accessibility = "Create pool")
    private SelenideElement addLiquidityBtn;

    @AndroidFindBy(id = "PrimaryButton")
    private SelenideElement primaryBtn;

    @AndroidFindBy(xpath = "//*[@text='Supply liquidity']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Supply liquidity\"`]")
    private SelenideElement supplyLiquidityTitle;

    @AndroidFindBy(id = "InputAmountFieldXOR")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[1]")
    private SelenideElement inputAmountFieldXor;

    @AndroidFindBy(id = "InputAmountFieldXST")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[2]")
    private SelenideElement inputAmountFieldXst;

    @AndroidFindBy(id = "SelectToken")
    @iOSXCUITFindBy(accessibility = "Select token")
    private SelenideElement selectTokenItem2;

    @AndroidFindBy(id = "InputAmountField")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[2]")
    private SelenideElement inputAmountField2;

    @AndroidFindBy(id = "SelectTokenXOR")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Select token\"`][1]")
    private SelenideElement selectTokenXor;

    @AndroidFindBy(id = "XORElement")
    @iOSXCUITFindBy(accessibility = "SORA")
    private SelenideElement xorToken;
    @AndroidFindBy(id = "XSTElement")
    @iOSXCUITFindBy(accessibility = "SORA Synthetics")
    private SelenideElement xstToken;

    @AndroidFindBy(xpath = "//*[@text='Supply']")
    @iOSXCUITFindBy(accessibility = "Review")
    private SelenideElement supplyBtn;

    @AndroidFindBy(xpath = "//*[@text='Confirm']")
    @iOSXCUITFindBy(accessibility = "Confirm")
    private SelenideElement confirmBtn;

    @AndroidFindBy(xpath = "//*[@text='Close']")
    @iOSXCUITFindBy(accessibility = "Close")
    private SelenideElement closeBtn;

    @iOSXCUITFindBy(accessibility = "cross")
    private SelenideElement crossBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.view.View[6]/android.widget.Button")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Expand\"])[2]")
    private SelenideElement showMorePools;

    @AndroidFindBy(xpath = "//*[@text='Polkaswap pools']")
    @iOSXCUITFindBy(accessibility = "Polkaswap pools")
    private SelenideElement polkaswapPoolsTitle;

    @Step
    public void clickPoolsButton()
    {
        poolButton.shouldBe(Condition.visible).click();
        polkaswapPoolsTitle.shouldBe(Condition.visible);
    }
    @Step
    public void explorePolkaswapPools()
    {
        showMorePools.scrollTo().shouldBe(Condition.visible).click();
    }

    @Step
    public void addLiquidity(String randomLiquidity)
    {
        log.info("Click Add liquidity button");
        addLiquidityBtn.shouldBe(Condition.visible).click();
        supplyLiquidityTitle.shouldBe(Condition.visible);
        selectTokenXor.shouldBe(Condition.visible).click();
        xorToken.shouldBe(Condition.visible).click();
        selectTokenItem2.shouldBe(Condition.visible).click();
        xstToken.shouldBe(Condition.visible).click();
        inputAmountFieldXor.shouldBe(Condition.visible).sendKeys(randomLiquidity);
        log.info("Supply XOR : "+randomLiquidity+" XOR" );
        if (isAndroid()) log.info("Supply XST : "+inputAmountFieldXst.shouldBe(Condition.visible).getText()+" XST" );
        supplyBtn.shouldBe(Condition.visible).click();
        confirmBtn.shouldBe(Condition.visible).click();
        closeBtn.shouldBe(Condition.visible).click();
        log.info("Click Close button" );
        //if (isIOS()) crossBtn.shouldBe(Condition.visible).click();
    }
}
