//package pages.account;
//
//import com.codeborne.selenide.Condition;
//import com.codeborne.selenide.SelenideElement;
//import io.appium.java_client.pagefactory.AndroidFindBy;
//import lombok.extern.log4j.Log4j2;
//
//import static com.codeborne.selenide.appium.ScreenObject.screen;
//
//@Log4j2
//public class CreateAccountPage {
//
////    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/accountNameEt")
////    private SelenideElement accountNameField;
//
//    @AndroidFindBy(xpath = "//*[@text='CONTINUE']")
//    private SelenideElement nextBtn;
//
//    @AndroidFindBy(xpath = "//*[text()='Account name']")
//    private SelenideElement accountNameField;
//
//    // * [text () = 'Забыли аккаунт?'] ")
//
//    //    @AndroidFindBy(xpath = "//*[@text='Account name']")
//    // @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Next\"]")
////    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/nextBtn")
////    private SelenideElement nextBtn;
//
////    @AndroidFindBy(xpath = "//*[@text='OK']")
////    private SelenideElement doNotTakeScreenshotsBtn;
//
//    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/confirmBtn")
//    private SelenideElement confirmBtn;
//
//    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/tvPassphraseWords1")
//    private SelenideElement tvPassphraseWords1;
//
//    @AndroidFindBy(id = "jp.co.soramitsu.sora.develop:id/tvPassphraseWords2")
//    private SelenideElement tvPassphraseWords2;
//
//    public void getWords(){
//        String passphraseWords1 = tvPassphraseWords1.getText();
//        String passphraseWords2 = tvPassphraseWords2.getText();
//
//    }
//
//    public PayAttentionPage enterAccountName (String accountName) {
////      accountNameField.shouldBe(Condition.visible);
//        nextBtn.shouldBe(Condition.visible).click();
//        return screen(PayAttentionPage.class);
//    }
//
//
//}
