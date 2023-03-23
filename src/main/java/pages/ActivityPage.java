package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertWith;
@Log4j2
public class ActivityPage {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]")
    @iOSXCUITFindBy(accessibility = "")
    private SelenideElement lastTransaction;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView[2]")
    @iOSXCUITFindBy(accessibility = "")
    private SelenideElement getXorFromLastTransaction;

    @AndroidFindBy(accessibility = "Swapped")
    @iOSXCUITFindBy(accessibility = "Swapped")
    private SelenideElement swappedItem;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView[5]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\'Status']")
    private SelenideElement getTransactionStatus1;

    @AndroidFindBy(xpath = "//*[@text='CLOSE']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\'CLOSE']")
    private SelenideElement closeBtn;
  public void CheckLastTransactionStatus(String randomValue){
//      lastTransaction.shouldBe(Condition.visible).click();
//      swappedItem.shouldBe(Condition.visible);
  //    String actualStatus= getTransactionStatus.shouldBe(Condition.visible).getText();
 //     assertThat(actualStatus).as("Pending").isEqualTo("Pending");

      lastTransaction.shouldBe(Condition.visible).click();
      String getXorAmountValueFromHistory = getXorFromLastTransaction.shouldBe(Condition.visible).getText();
      log.info("Get Xor from last transaction: "+getXorAmountValueFromHistory);
      assertThat(getXorAmountValueFromHistory).isEqualTo(randomValue+" XOR");




  //    String searchText  = randomValue; /*+ " XOR ->"; */
 //     $(By.ByXPath("//*[contains(text(),'+searchText+')]")).shouldBe(Condition.enabled);
//String formatted = String.format("Welcome to %s!", value);

 //       String formatted = String.format("//*[contains(text(),'%s')]", "XOR");

 //     String formatted = String.format("//*[@text='%s')]", searchText);
 //     $x(formatted).shouldBe(Condition.enabled);



  }

}
