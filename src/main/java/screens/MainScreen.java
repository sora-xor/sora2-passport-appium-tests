package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainScreen {
	private IOSDriver driver;
	
	private WebElement walletHeader = driver.findElement(By.name("Wallet"));
	
	public MainScreen() {
	}
	
	public MainScreen(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	public void validateHeader() {
		Assert.assertTrue(walletHeader.isDisplayed(), "Main screen header isn't displayed.");
    }
	
	
	
}
