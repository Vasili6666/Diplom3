package mobile.sql.screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class LibraryScreen {

    private final SelenideElement libraryButton = $(accessibilityId("Library"));
    private final SelenideElement libraryTitle = $x("//*[@text='Library' or @resource-id='randomappsinc.com.sqlpracticeplus:id/md_title']");
    private final SelenideElement closeButton = $x("//*[@text='CLOSE' or @resource-id='randomappsinc.com.sqlpracticeplus:id/md_buttonDefaultPositive']");

    @Step("Нажать на кнопку Library")
    public LibraryScreen clickLibraryButton() {
        libraryButton.shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }

    @Step("Проверить заголовок 'Library'")
    public LibraryScreen verifyLibraryTitle() {
        libraryTitle.shouldBe(Condition.visible).shouldHave(Condition.text("Library"));
        return this;
    }

    @Step("Нажать кнопку Close")
    public LibraryScreen clickCloseButton() {
        closeButton.shouldBe(Condition.visible, Condition.enabled).click();
        libraryTitle.shouldNotBe(Condition.visible);
        return this;
    }
}