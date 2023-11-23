package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static infrastructure.Platform.isAndroid;
import static infrastructure.Platform.isIOS;

public class AppSettingsPage {
    @AndroidFindBy(xpath = "//*[@text='Change language']")
    @iOSXCUITFindBy(accessibility = "Change language")
    private SelenideElement changeLanguageEnglishBtn;

    @AndroidFindBy(xpath = "//*[@text='App settings']")
    @iOSXCUITFindBy(accessibility = "App settings")
    private SelenideElement appSettingsSpanishField;

    @AndroidFindBy(xpath = "//*[@text='English']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"English\"])[1]\n")
    private SelenideElement englishLanguage;

    @AndroidFindBy(xpath = "//*[@text='Русский']")
    @iOSXCUITFindBy(accessibility = "Русский")
    private SelenideElement russianLanguage;
    @AndroidFindBy(xpath = "//*[@text='Español']")
    @iOSXCUITFindBy(accessibility = "Español")
    private SelenideElement spanishLanguage;

    @AndroidFindBy(xpath = "//*[@text='Deutsch']")
    @iOSXCUITFindBy(accessibility = "Deutsch")
    private SelenideElement deutschLanguage;

    @AndroidFindBy(xpath = "//*[@text='Français']")
    @iOSXCUITFindBy(accessibility = "Français")
    private SelenideElement frenchLanguage;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.Button")
    private SelenideElement backBtn;

    @iOSXCUITFindBy(accessibility = "cross")
    private SelenideElement crossBtn;

    @AndroidFindBy(xpath = "//*[@text='Cuentas Cripto']")
    @iOSXCUITFindBy(accessibility = "Cuentas Cripto")
    private SelenideElement cryptoAccountBtnSpanish;

    @AndroidFindBy(xpath = "//*[@text='Comprar XOR con fiat']")
    private SelenideElement buyXorWithFiatBtnSpanish;

    @AndroidFindBy(xpath = "//*[@text='Tarjeta SORA']")
    private SelenideElement soraCardBtnSpanish;

    @AndroidFindBy(xpath = "//*[@text='Nodos']")
    @iOSXCUITFindBy(accessibility = "Nodos")
    private SelenideElement nodesBtnSpanish;

    @AndroidFindBy(xpath = "//*[@text='App settings']")
    private SelenideElement AppSettingBtnSpanish;

    public AppSettingsPage switchToEnglish() {
        appSettingsSpanishField.shouldBe(Condition.visible).click();
        changeLanguageEnglishBtn.shouldBe(Condition.visible).click();
        englishLanguage.shouldBe(Condition.visible).click();
        if (isIOS()) crossBtn.shouldBe(Condition.visible).click();
        return screen(AppSettingsPage.class);
    }

    public AppSettingsPage switchToRussian()
    {
        return screen(AppSettingsPage.class);
    }

    public AppSettingsPage switchToSpanish() {
        changeLanguageEnglishBtn.shouldBe(Condition.visible).click();
        spanishLanguage.shouldBe(Condition.visible).click();
        if (isIOS()) crossBtn.shouldBe(Condition.visible).click();
        cryptoAccountBtnSpanish.shouldBe(Condition.visible);
        //if (isAndroid()) buyXorWithFiatBtnSpanish.shouldBe(Condition.visible);
        if (isAndroid()) soraCardBtnSpanish.shouldBe(Condition.visible);
        nodesBtnSpanish.shouldBe(Condition.visible);
        appSettingsSpanishField.shouldBe(Condition.visible).click();
        return screen(AppSettingsPage.class);
    }

    public AppSettingsPage switchToFrench()
    {
        return screen(AppSettingsPage.class);
    }


    public AppSettingsPage switchToGerman()
    {
        return screen(AppSettingsPage.class);
    }

    public AppSettingsPage switchToNorwegian()
    {
        return screen(AppSettingsPage.class);
    }

    public AppSettingsPage switchToChinese()
    {
        return screen(AppSettingsPage.class);
    }

    public AppSettingsPage switchToIndonesian()
    {
        return screen(AppSettingsPage.class);
    }

    public AppSettingsPage switchToTurkish()
    {
        return screen(AppSettingsPage.class);
    }

    public AppSettingsPage switchToArab()
    {
        return screen(AppSettingsPage.class);
    }

}

