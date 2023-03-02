package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class ActivityPage {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]")
    @iOSXCUITFindBy(accessibility = "")
    private SelenideElement lastTransaction;

    @AndroidFindBy(accessibility = "Swapped")
    @iOSXCUITFindBy(accessibility = "Swapped")
    private SelenideElement swappedItem;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView[5]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\'Status']")
    private SelenideElement getTransactionStatus;

    @AndroidFindBy(xpath = "//*[@text='CLOSE']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\'CLOSE']")
    private SelenideElement closeBtn;

  public void CheckLastTransactionStatus(){
      lastTransaction.shouldBe(Condition.visible).click();
      swappedItem.shouldBe(Condition.visible);
      String actualStatus= getTransactionStatus.shouldBe(Condition.visible).getText();
      assertThat(actualStatus).as("Pending").isEqualTo("Pending");
  }

}
