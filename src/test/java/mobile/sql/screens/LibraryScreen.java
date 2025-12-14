package mobile.sql.screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class LibraryScreen {

    // Используем accessibilityId для кнопки Library (лучше всего работает в Android)
    private final SelenideElement libraryButton = $(accessibilityId("Library"));

    // Для заголовка используем text или id
    private final SelenideElement libraryTitle = $x("//*[@text='Library' or @resource-id='randomappsinc.com.sqlpracticeplus:id/md_title']");

    // Кнопка Close
    private final SelenideElement closeButton = $x("//*[@text='CLOSE' or @resource-id='randomappsinc.com.sqlpracticeplus:id/md_buttonDefaultPositive']");

    // Контейнер (опционально)
    private final SelenideElement libraryDialog = $x("//*[contains(@resource-id, 'md_content')]");

    @Step("Нажать на кнопку Library (иконка книги)")
    public LibraryScreen clickLibraryButton() {
        // Увеличиваем таймаут и добавляем ожидание
        libraryButton.shouldBe(Condition.visible.because("Кнопка Library не найдена"),
                Condition.enabled.because("Кнопка Library не активна")).click();
        return this;
    }

    @Step("Проверить, что открылось окно с заголовком 'Library'")
    public LibraryScreen verifyLibraryTitle() {
        // Проверяем заголовок с таймаутом
        libraryTitle.shouldBe(Condition.visible.because("Заголовок Library не найден"))
                .shouldHave(Condition.text("Library").because("Текст заголовка не 'Library'"));
        return this;
    }

    @Step("Нажать кнопку Close и проверить, что окно библиотеки закрылось")
    public LibraryScreen clickCloseButton() {
        // Нажимаем кнопку Close
        closeButton.shouldBe(Condition.visible.because("Кнопка Close не найдена"),
                Condition.enabled.because("Кнопка Close не активна")).click();

        // Проверяем, что окно закрылось (не виден заголовок)
        libraryTitle.shouldNotBe(Condition.visible.because("Окно Library не закрылось"));

        return this;
    }
}