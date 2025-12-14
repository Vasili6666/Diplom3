package mobile.sql.screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class SettingsScreen {

    // Локаторы для кнопки Settings и заголовка
    private final SelenideElement settingsButton = $(accessibilityId("Settings"));
    private final SelenideElement settingsTitle = $x("//android.widget.TextView[@text='Settings']");

    // Локаторы для всех элементов настроек (только те, что вы указали)
    private final SelenideElement sendFeedbackOption = $x("//android.widget.TextView[@resource-id='randomappsinc.com.sqlpracticeplus:id/settings_option' and @text='Send feedback']");
    private final SelenideElement myOtherAppsOption = $x("//android.widget.TextView[@resource-id='randomappsinc.com.sqlpracticeplus:id/settings_option' and @text='My other apps']");
    private final SelenideElement rateAppOption = $x("//android.widget.TextView[@resource-id='randomappsinc.com.sqlpracticeplus:id/settings_option' and @text='Rate this app']");
    private final SelenideElement sourceCodeOption = $x("//android.widget.TextView[@resource-id='randomappsinc.com.sqlpracticeplus:id/settings_option' and @text='Source code']");
    private final SelenideElement databaseTablesOption = $x("//android.widget.TextView[@resource-id='randomappsinc.com.sqlpracticeplus:id/settings_option' and @text='Database tables']");

    @Step("Нажать на кнопку Settings (иконка настроек)")
    public SettingsScreen clickSettingsButton() {
        settingsButton.shouldBe(Condition.visible.because("Кнопка Settings не найдена"),
                Condition.enabled.because("Кнопка Settings не активна")).click();
        return this;
    }

    @Step("Проверить, что открылось окно с заголовком 'Settings'")
    public SettingsScreen verifySettingsTitle() {
        settingsTitle.shouldBe(Condition.visible.because("Заголовок Settings не найден"))
                .shouldHave(Condition.text("Settings").because("Текст заголовка не 'Settings'"));
        return this;
    }

    @Step("Проверить все элементы настроек")
    public SettingsScreen verifyAllSettingsElements() {
        // Проверяем все указанные элементы
        sendFeedbackOption.shouldBe(Condition.visible.because("Опция Send feedback не найдена"));
        myOtherAppsOption.shouldBe(Condition.visible.because("Опция My other apps не найдена"));
        rateAppOption.shouldBe(Condition.visible.because("Опция Rate this app не найдена"));
        sourceCodeOption.shouldBe(Condition.visible.because("Опция Source code не найдена"));
        databaseTablesOption.shouldBe(Condition.visible.because("Опция Database tables не найдена"));

        return this;
    }

    @Step("Проверить заголовок и все элементы настроек")
    public SettingsScreen verifyCompleteSettingsScreen() {
        verifySettingsTitle();
        verifyAllSettingsElements();
        return this;
    }
}