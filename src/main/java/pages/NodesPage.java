package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class NodesPage {

    @AndroidFindBy(xpath = "//*[@text='Select Node']")
    @iOSXCUITFindBy(accessibility = "Select Node")
    private SelenideElement selectNodeTitle;

    @AndroidFindBy(xpath = "//*[@text='DEFAULT NODES']")
    @iOSXCUITFindBy(accessibility = "DEFAULT NODES")
    private SelenideElement defaultNodesTitle;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText[1]")
    private SelenideElement nodeNameField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText[2]")
    private SelenideElement nodeAddressField;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.view.View[1]")
    private SelenideElement framenode1Btn;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.view.View[2]")
    private SelenideElement framenode2Btn;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.view.View[3]")
    private SelenideElement framenode3Btn;

    @AndroidFindBy(xpath = "//*[@text='OK']")
    private SelenideElement confirmBtn;

    @AndroidFindBy(xpath = "//*[@text='Add Custom Node']")
    private SelenideElement addCustomNodebtn;

    @AndroidFindBy(xpath = "//*[@text='Successfully switch the node']")
    private SelenideElement successfullySwitchForm;

    @AndroidFindBy(xpath = "//*[@text='Connected']")
    private SelenideElement connectedToast;

    @AndroidFindBy(xpath = "//*[@text='Error']")
    private SelenideElement alreadyAddedNodeError;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.Button")
    private SelenideElement backBtn;


    public void switchToDefaultNode()
    {
        selectNodeTitle.shouldBe(Condition.visible);
        defaultNodesTitle.shouldBe(Condition.visible);
        framenode3Btn.shouldBe(Condition.visible).click();
        confirmBtn.shouldBe(Condition.visible).click();
        successfullySwitchForm.shouldBe(Condition.visible);
        confirmBtn.shouldBe(Condition.visible).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        log.info("Node switched");
        backBtn.shouldBe(Condition.visible).click();
    }

    public void addCustomNode()
    {
        selectNodeTitle.shouldBe(Condition.visible);
        defaultNodesTitle.shouldBe(Condition.visible);
        addCustomNodebtn.shouldBe(Condition.visible).click();
        nodeNameField.shouldBe(Condition.visible).sendKeys("custom node");
        nodeAddressField.shouldBe(Condition.visible).sendKeys("wss://ws.framenode-3.r0.dev.sora2.soramitsu.co.jp");
        addCustomNodebtn.shouldBe(Condition.visible).click();
        alreadyAddedNodeError.shouldBe(Condition.visible);
        confirmBtn.shouldBe(Condition.visible).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        backBtn.shouldBe(Condition.visible).click();
        backBtn.shouldBe(Condition.visible).click();
    }
    }
