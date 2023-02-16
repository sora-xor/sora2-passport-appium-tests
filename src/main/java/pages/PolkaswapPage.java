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

    @AndroidFindBy(xpath = "//*[@text='Select token']")
    @iOSXCUITFindBy(accessibility = "Select token")
    private SelenideElement selectTokenBtn;

    public void PolkaswapPageIsOpen (){
        String actualTitle = disclaimer.shouldBe(Condition.visible).getText();
        assertThat(actualTitle).as("Disclaimer").isEqualTo("Disclaimer");
        disclaimerCloseBtn.shouldBe(Condition.visible).click();
    }
}
