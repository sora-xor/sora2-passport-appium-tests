package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import infrastructure.Utils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static infrastructure.Platform.isAndroid;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class ExplorePage extends CommonPage{

    @AndroidFindBy(accessibility = "Explore")
    private SelenideElement exploreBottomNavBtn;

    infrastructure.Utils utils = new Utils();
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/OnMenuItem")
    @iOSXCUITFindBy(accessibility = "Add Liquidity")
    private SelenideElement addLiquidityBtn;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/PrimaryButton")
    private SelenideElement primaryBtn;

    @AndroidFindBy(xpath = "//*[@text='Supply liquidity']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Supply liquidity\"`]")
    private SelenideElement supplyLiquidityTitle;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/InputAmountFieldXOR")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[1]")
    private SelenideElement inputAmountFieldXor;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/InputAmountFieldXST")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[2]")
    private SelenideElement inputAmountFieldXst;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SelectToken")
    @iOSXCUITFindBy(accessibility = "Select token")
    private SelenideElement selectTokenItem2;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/InputAmountField")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[2]")
    private SelenideElement inputAmountField2;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/SelectTokenXOR")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Select token\"`][1]")
    private SelenideElement selectTokenXor;

    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/XORElement")
    @iOSXCUITFindBy(accessibility = "SORA")
    private SelenideElement xorToken;
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/XSTElement")
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

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.view.View[6]/android.widget.Button")
    private SelenideElement showMorePools;

    @AndroidFindBy(xpath = "//*[@text='Polkaswap pools']")
    private SelenideElement polkaswapPoolsTitle;

    @Step
    public void explorePolkaswapPools()
    {
        exploreBottomNavBtn.shouldBe(Condition.selected);
        //todo: find out WHY is it here...
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (isAndroid()) {
            utils.scrollForward(1);
        }
        showMorePools.shouldBe(Condition.visible).click();
    }
    @Step
    public void addLiquidity(String randomLiquidity)
    {
        polkaswapPoolsTitle.shouldBe(Condition.visible);
        addLiquidityBtn.shouldBe(Condition.visible).click();
        supplyLiquidityTitle.shouldBe(Condition.visible).exists();
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
    }
}
