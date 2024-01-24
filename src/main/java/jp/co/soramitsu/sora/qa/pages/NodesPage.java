package jp.co.soramitsu.sora.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import jp.co.soramitsu.sora.qa.configs.TestConfig;
import jp.co.soramitsu.sora.qa.infrastructure.Utils;
import lombok.extern.log4j.Log4j2;

import static jp.co.soramitsu.sora.qa.infrastructure.Platform.isAndroid;

@Log4j2
public class NodesPage {

    @AndroidFindBy(xpath = "//*[@text='Select Node']")
    @iOSXCUITFindBy(accessibility = "Select Node")
    private SelenideElement selectNodeTitle;

    @AndroidFindBy(xpath = "//*[@text='DEFAULT NODES']")
    @iOSXCUITFindBy(accessibility = "DEFAULT NODES")
    private SelenideElement defaultNodesTitle;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText[1]")
    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Node Name\"")
    private SelenideElement nodeNameField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText[2]")
    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Node Address\"")
    private SelenideElement nodeAddressField;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.view.View[1]")
    @iOSXCUITFindBy(accessibility = "framenode-1.r0.dev")
    private SelenideElement framenode1Btn;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.view.View[2]")
    @iOSXCUITFindBy(accessibility = "framenode-2.r0.dev")
    private SelenideElement framenode2Btn;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.view.View[3]")
    @iOSXCUITFindBy(accessibility = "framenode-3.r0.dev")
    private SelenideElement framenode3Btn;

    @AndroidFindBy(xpath = "//*[@text='OK']")
    @iOSXCUITFindBy(accessibility = "OK")
    private SelenideElement confirmBtn;

    @AndroidFindBy(xpath = "//*[@text='Add Custom Node']")
    @iOSXCUITFindBy(accessibility = "Add node")
    private SelenideElement addCustomNodebtn;

    @AndroidFindBy(xpath = "//*[@text='Successfully switch the node']")
    private SelenideElement successfullySwitchForm;

    @AndroidFindBy(xpath = "//*[@text='Connected']")
    private SelenideElement connectedToast;

    @AndroidFindBy(xpath = "//*[@text='Error']")
    @iOSXCUITFindBy(accessibility = "This node already exists")
    private SelenideElement alreadyAddedNodeError;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.Button")
    private SelenideElement backBtn;

    @iOSXCUITFindBy(accessibility = "Select Node")
    private SelenideElement backToSelectNodeBtn;


    @Step
    public MorePage switchToDefaultNode() {
        selectNodeTitle.shouldBe(Condition.visible);
        defaultNodesTitle.shouldBe(Condition.visible);
        framenode3Btn.shouldBe(Condition.visible).click();
        confirmBtn.shouldBe(Condition.visible).click();
        //todo add checking that node actually switched
        successfullySwitchForm.shouldBe(Condition.visible);
        confirmBtn.shouldBe(Condition.visible).click();
        log.info("Node switched");
        backBtn.shouldBe(Condition.visible).click();
        return new MorePage();
    }

    @Step
    public void addExistingCustomNode() {
        selectNodeTitle.shouldBe(Condition.visible);
        defaultNodesTitle.shouldBe(Condition.visible);
        addCustomNodebtn.shouldBe(Condition.visible).click();
        nodeNameField.shouldBe(Condition.visible).sendKeys("custom node");
        nodeAddressField.shouldBe(Condition.visible).sendKeys(TestConfig.config.nodeAddress()); //todo move this to config
        alreadyAddedNodeError.shouldBe(Condition.visible);
        log.info("Error message shown");
        if (isAndroid()) {
            confirmBtn.shouldBe(Condition.visible).click();
            backBtn.shouldBe(Condition.visible).click();
            backBtn.shouldBe(Condition.visible).click();
        } else {
            backToSelectNodeBtn.shouldBe(Condition.visible).click();
            //swipe doesn't work
            Utils.swipeDown();
        }
    }
}
