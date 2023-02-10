package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.By;
import pages.WalletPage;
import pages.WelcomePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static org.assertj.core.api.Assertions.assertThat;
import static infrastructure.Platform.isIOS;
import static infrastructure.Platform.isAndroid;


public class PinCodePage {
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/pinCodeTitleTv")
    @iOSXCUITFindBy(accessibility = "Confirm Pin Code")
    private SelenideElement pinCodeRepeatTitleTv;
    
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/pinCodeTitleTv")
    @iOSXCUITFindBy(accessibility = "Setup Pin Code")
    private SelenideElement pinCodeTitleTv;
    
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Logout\"]")
    private SelenideElement logoutAlertBnt;

    public WalletPage enterAndConfirmPinCode () {
    	if (isAndroid()) {
    		$(By.id("jp.co.soramitsu.sora.develop:id/btn"));

    		for (int i =  1; i <= 6; i++)
    		{
    			$(By.id("jp.co.soramitsu.sora.develop:id/btn"+i)).click();
    		}
    		assertThat(pinCodeRepeatTitleTv.getText()).isEqualTo("Confirm pin code");

    		for (int i =  1; i <= 6; i++)
    		{
    			$(By.id("jp.co.soramitsu.sora.develop:id/btn"+i)).click();
    		}
    	}
    	if (isIOS()) {
    		assertThat(pinCodeTitleTv.isDisplayed());
    		for (int i =  1; i <= 6; i++) {
    			$(By.name(""+i)).click();   			
    		}
    		assertThat(pinCodeRepeatTitleTv.isDisplayed());
    		for (int i =  1; i <= 6; i++) {
    			$(By.name(""+i)).click();   			
    		}
    	}
         return screen(WalletPage.class);
    }
    public WelcomePage enterPinCode() {
    	if (isAndroid()) {
    		$(By.id("jp.co.soramitsu.sora.develop:id/btn"));

    		for (int i =  1; i <= 6; i++)
    		{
    			$(By.id("jp.co.soramitsu.sora.develop:id/btn"+i)).click();
    		}	
    	}
    	if (isIOS()) {
    		assertThat(pinCodeTitleTv.isDisplayed());
    		for (int i =  1; i <= 6; i++) {
    			$(By.name(""+i)).click();   			
    		}	
    	}
    	logoutAlertBnt.click();
    	return screen(WelcomePage.class);
    	}
}
