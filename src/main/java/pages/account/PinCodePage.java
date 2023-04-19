package pages.account;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
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
    @AndroidFindBy(xpath = "//*[@text='Confirm pin code']")
    @iOSXCUITFindBy(accessibility = "Confirm Pin Code")
    private SelenideElement pinCodeRepeatTitleTv;

	@AndroidFindBy(id = "android:id/button1")
	private SelenideElement logoutBtn;

	@AndroidFindBy(id = "android:id/button2")
	private SelenideElement cancelBtn;

	@AndroidFindBy(xpath = "//*[@text='LOGOUT']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Logout\"]")
	private SelenideElement logoutAlertBnt;

    @AndroidFindBy(xpath = "//*[@text='Setup pin code']")
    @iOSXCUITFindBy(accessibility = "Setup Pin Code")
    private SelenideElement pinCodeTitleTv;

    @iOSXCUITFindBy(accessibility = "0")
    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/btn0")
    private SelenideElement pinCodeBtn0;
    public WalletPage enterAndConfirmPinCodeNew() {
    	if (isAndroid()) {
    		$(By.id("jp.co.soramitsu.sora.develop:id/"));

    		for (int i =  1; i <= 6; i++)
    		{
    			$(By.id("jp.co.soramitsu.sora.develop:id/"+i)).click();
    		}
    		assertThat(pinCodeRepeatTitleTv.getText()).isEqualTo("Confirm pin code");

    		for (int i =  1; i <= 6; i++)
    		{
    			$(By.id("jp.co.soramitsu.sora.develop:id/"+i)).click();
    		}
    	}
    	if (isIOS()) {
    		assertThat(pinCodeTitleTv.isDisplayed());
    		for (int i =  1; i <= 6; i++) {
    			//$(By.name(""+i)).click(); 
    			$(By.xpath("(//XCUIElementTypeStaticText[@name=\""+i+"\"])[2]")).click();
    		}
    		assertThat(pinCodeRepeatTitleTv.isDisplayed());
    		for (int i =  1; i <= 6; i++) {
    			//$(By.name(""+i)).click();
    			$(By.xpath("(//XCUIElementTypeStaticText[@name=\""+i+"\"])[2]")).click();
    		}
    	}
        return screen(WalletPage.class);
    }
    
    public WalletPage enterAndConfirmPinCode() {
    	if (isAndroid()) {
    		$(By.id("jp.co.soramitsu.sora.develop:id/"));

    		for (int i =  1; i <= 6; i++)
    		{
    			$(By.id("jp.co.soramitsu.sora.develop:id/"+i)).click();
    		}
    		assertThat(pinCodeRepeatTitleTv.getText()).isEqualTo("Confirm pin code");

    		for (int i =  1; i <= 6; i++)
    		{
    			$(By.id("jp.co.soramitsu.sora.develop:id/"+i)).click();
    		}
    	}
    	if (isIOS()) {
    		assertThat(pinCodeTitleTv.isDisplayed());
    		for (int i =  1; i <= 6; i++) {
    			//$(By.name(""+i)).click(); 
    			$(By.xpath("//XCUIElementTypeStaticText[@name=\""+i+"\"]")).click();
    		}
    		assertThat(pinCodeRepeatTitleTv.isDisplayed());
    		for (int i =  1; i <= 6; i++) {
    			//$(By.name(""+i)).click();
    			$(By.xpath("//XCUIElementTypeStaticText[@name=\""+i+"\"]")).click();
    		}
    	}
        return screen(WalletPage.class);
    }
    public WelcomePage enterPinCode() {
    	if (isAndroid()) {
    		$(By.id("jp.co.soramitsu.sora.develop:id/"));

    		for (int i =  1; i <= 6; i++)
    		{
    			$(By.id("jp.co.soramitsu.sora.develop:id/"+i)).click();
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
