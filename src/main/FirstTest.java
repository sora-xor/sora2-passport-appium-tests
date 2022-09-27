import io.appium.java_client.ios.IOSDriver;
import screens.MainScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.net.URL;
import java.sql.Timestamp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.time.Duration;

public class FirstTest extends BaseTest {
	public IOSDriver driver;
	private String bundlId = "co.jp.soramitsu.sora.dev";

    @BeforeSuite
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOs");
				capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("appium:platformVersion", "16.0");
        capabilities.setCapability("appium:deviceName", "iPhone 14 Pro");
        capabilities.setCapability("appium:includeSafariInWebviews", true);
        capabilities.setCapability("appium:newCommandTimeout", 3600);
        capabilities.setCapability("appium:connectHardwareKeyboard", true);
				capabilities.setCapability("appium:wdaLaunchTimeout", 40000);

        URL remoteUrl = new URL("http://0.0.0.0:4723/wd/hub");

        driver = new IOSDriver(remoteUrl, capabilities);
	 	try
 		{
	 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	 		throw new InterruptedException();
 		}
	 	catch(InterruptedException e)
 		{
	 		System.out.println(e);
 		}
 		driver.activateApp(bundlId);
        }

    @AfterSuite
    public void tearDown() {
    	driver.terminateApp(bundlId);
        driver.quit();
    }


 @Test
    public void testCheckAppInstalled () {
        // Our bondle ID is co.jp.soramitsu.sora.dev.
	 	Assert.assertTrue(driver.isAppInstalled(bundlId));
    };

 @Test
 	public void testCreateAccount () {
	 	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	 	// Check we have big logo.
	 	Assert.assertNotNull(driver.findElement(By.name("SORA Logo Big")), "Something went wrong, we don't get big logo at the app start");

	 	//Creating the account.
	 	driver.findElement(By.name("CREATE ACCOUNT")).click();
	 	driver.findElement(By.name("Account Name")).sendKeys("Test User" + timestamp.getTime());
	 	driver.findElement(By.name("CONTINUE")).click();

	 	//Check we have pop-up window
	 	Assert.assertNotNull(driver.findElement(By.xpath("//XCUIElementTypeAlert[@name=\"Do not take screenshots\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]")), "We didn't get the screenshots alert");
	 	driver.findElement(By.name("OK")).click();

	 	//Check we are on mnomonic screen
	 	WebElement alertSign = driver.findElement(By.name("iconWarningBig"));
	 	Assert.assertNotNull(alertSign, "We didn't get the red alert sign");

	 	//Remember the mnemonic
	 	ArrayList<String> keyWords = new ArrayList<String>();
	 	for (int i =  1; i <= 2; i++)
	 	{
	 		for (int j = 2; j <= 12; j += 2)
	 		{
	 			keyWords.add(driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"SORA Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther["+i+"]/XCUIElementTypeStaticText["+j+"]")).getText());
	 		}
	 	}
		driver.findElement(By.name("CONTINUE")).click();
		System.out.println(keyWords.toString()); //Just print memonic for debug here

		//Check we are in mnemonic reorder screen
		Assert.assertNotNull(driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"SORA Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")), "We ddn't get to the mnemoic reorder screen");
		Assert.assertNotNull(driver.findElement(By.name(keyWords.get(1))));
		//Enter the mnemonic
		for (int i = 0; i < keyWords.size(); i++)
	 	{
			Assert.assertTrue(driver.findElement(By.name(keyWords.get(i))).isDisplayed());
			driver.findElement(By.name(keyWords.get(i))).click();
	 	}
		Assert.assertTrue(driver.findElement(By.name("CONFIRM")).isDisplayed());
	 	driver.findElement(By.name("CONFIRM")).click();

	 	//Check that we are at the pin code setup screen
	 	Assert.assertNotNull(driver.findElement(By.name("Setup Pin Code")), "We don't get to the pin code screen");

	 	//Insert 123456 pin
	 	for (int i =  1; i <= 6; i++)
	 	{
	 		driver.findElement(By.name(""+i)).click();
	 	}

	 	//Check that we are on confirm pin code screen
	 	Assert.assertNotNull(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Confirm Pin Code\"]")), "We don't get to the confirm pin code screen");

	 	//Insert 123456
	 	for (int i =  1; i <= 6; i++)
	 	{
	 		driver.findElement(By.name(""+i)).click();
	 	}

	 	//Check we are on the main screen. The main screen can be used in different tests so it's in the screenn package.
	 	MainScreen mainScreen = new MainScreen(driver);
	 	mainScreen.validateHeader();
 	};

 }
