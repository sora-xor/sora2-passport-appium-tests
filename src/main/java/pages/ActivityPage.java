package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.*;

@Log4j2
public class ActivityPage {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]")
    @iOSXCUITFindBy(accessibility = "")
    private SelenideElement lastTransaction;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView[2]")
    @iOSXCUITFindBy(accessibility = "")
    private SelenideElement getXorFromLastTransaction;

    @AndroidFindBy(accessibility = "Swapped")
    @iOSXCUITFindBy(accessibility = "")
    private SelenideElement swappedItem;

    @AndroidFindBy(accessibility = "Sent to pool")
    @iOSXCUITFindBy(accessibility = "")
    private SelenideElement sentToPoolItem;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView[5]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\'Status']")
    private SelenideElement getTransactionStatus;

    @AndroidFindBy(xpath = "//*[@text='Close']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\'CLOSE']")
    private SelenideElement closeBtn;
  public void checkLastTransactionStatusSwap(String randomValue){

      lastTransaction.shouldBe(Condition.visible).click();
      swappedItem.shouldBe(Condition.visible);
      log.info("Last transaction type: "+swappedItem.getAttribute("content-desc"));
      String getXorAmountValueFromHistory = getXorFromLastTransaction.shouldBe(Condition.visible).getText();
      log.info("Get Xor from last transaction: "+getXorAmountValueFromHistory);
      assertThat(getXorAmountValueFromHistory).isEqualTo(randomValue+" XOR");
      closeBtn.shouldBe(Condition.visible).click();

  }

    public void checkLastTransactionStatusPool(String randomLiquidity){

        lastTransaction.shouldBe(Condition.visible).click();
        sentToPoolItem.shouldBe(Condition.visible);
        log.info("Last transaction type: "+sentToPoolItem.getAttribute("content-desc"));
        String getXorAmountValueFromHistory = getXorFromLastTransaction.shouldBe(Condition.visible).getText();
        log.info("Get Xor from last transaction: "+getXorAmountValueFromHistory);
        assertThat(getXorAmountValueFromHistory).isEqualTo(randomLiquidity+" XOR");
        closeBtn.shouldBe(Condition.visible).click();

    }

}
