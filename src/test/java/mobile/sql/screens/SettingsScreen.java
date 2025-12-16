package mobile.sql.screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class SettingsScreen {

    private final SelenideElement settingsButton = $(accessibilityId("Settings"));
    private final SelenideElement settingsTitle = $x("//android.widget.TextView[@text='Settings']");

    private final SelenideElement sendFeedbackOption = $x("//android.widget.TextView[@resource-id='randomappsinc.com.sqlpracticeplus:id/settings_option' and @text='Send feedback']");
    private final SelenideElement myOtherAppsOption = $x("//android.widget.TextView[@resource-id='randomappsinc.com.sqlpracticeplus:id/settings_option' and @text='My other apps']");
    private final SelenideElement rateAppOption = $x("//android.widget.TextView[@resource-id='randomappsinc.com.sqlpracticeplus:id/settings_option' and @text='Rate this app']");
    private final SelenideElement sourceCodeOption = $x("//android.widget.TextView[@resource-id='randomappsinc.com.sqlpracticeplus:id/settings_option' and @text='Source code']");
    private final SelenideElement databaseTablesOption = $x("//android.widget.TextView[@resource-id='randomappsinc.com.sqlpracticeplus:id/settings_option' and @text='Database tables']");

    @Step("Нажать на кнопку Settings")
    public SettingsScreen clickSettingsButton() {
        settingsButton.shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }

    @Step("Проверить заголовок 'Settings'")
    public SettingsScreen verifySettingsTitle() {
        settingsTitle.shouldBe(Condition.visible).shouldHave(Condition.text("Settings"));
        return this;
    }

    @Step("Проверить все элементы настроек")
    public SettingsScreen verifyAllSettingsElements() {
        sendFeedbackOption.shouldBe(Condition.visible);
        myOtherAppsOption.shouldBe(Condition.visible);
        rateAppOption.shouldBe(Condition.visible);
        sourceCodeOption.shouldBe(Condition.visible);
        databaseTablesOption.shouldBe(Condition.visible);
        return this;
    }
}