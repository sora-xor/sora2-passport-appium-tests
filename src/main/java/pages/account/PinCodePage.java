package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.By;
import pages.WalletPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static org.assertj.core.api.Assertions.assertThat;
import static infrastructure.Platform.isIOS;
import static infrastructure.Platform.isAndroid;

public class PinCodePage {
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/pinCodeTitleTv")
    @iOSXCUITFindBy(accessibility = "Confirm Pin Code")
    private SelenideElement pinCodeTitleTv;

    @iOSXCUITFindBy(accessibility = "0")
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/btn0")
    private SelenideElement pinCodeBtn0;
    public WalletPage enterAndConfirmPinCode () {
    	if (isAndroid()) {
    		$(By.id("jp.co.soramitsu.sora.develop:id/btn"));

    		for (int i =  1; i <= 6; i++)
    		{
    			$(By.id("jp.co.soramitsu.sora.develop:id/btn"+i)).click();
    		}
    		assertThat(pinCodeTitleTv.getText()).isEqualTo("Confirm pin code");

    		for (int i =  1; i <= 6; i++)
    		{
    			$(By.id("jp.co.soramitsu.sora.develop:id/btn"+i)).click();
    		}
    	}
    	if (isIOS()) {
    		for (int i =  1; i <= 6; i++) {
    			$(By.name(""+i)).click();   			
    		}
    		assertThat(pinCodeTitleTv.isDisplayed());
    		for (int i =  1; i <= 6; i++) {
    			$(By.name(""+i)).click();   			
    		}
    	}

        return screen(WalletPage.class);
    }
}
