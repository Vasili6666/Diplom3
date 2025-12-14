package mobile.sql.tests;

import mobile.sql.helpers.Attach;
import mobile.sql.screens.SettingsScreen;
import mobile.sql.screens.SqlPracticeScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;


public class SettingsTest extends MobileTestBase {

    SqlPracticeScreen sqlScreen = new SqlPracticeScreen();
    SettingsScreen settingsScreen = new SettingsScreen();

    @Test
    @DisplayName("Проверка всех элементов в настройках SQL Practice PRO")
    void settingsTest() {
        // Шаг 1: Обрабатываем приветственное меню
        sqlScreen.clickOkButton();

        // Даем время приложению загрузиться
        sleep(3000);

        // Шаг 2: Заходим в основное меню и нажимаем кнопку Settings
        settingsScreen.clickSettingsButton();

        // Даем время окну настроек открыться
        sleep(2000);

        // Шаг 3: Проверяем, что открылось окно с названием Settings
        settingsScreen.verifySettingsTitle();

        // Шаг 4: Проверяем наличие всех элементов настроек
        settingsScreen.verifyAllSettingsElements();

        // Тест пройден - все элементы найдены
        // Делаем скриншот для отчета
        Attach.screenshotAs("Settings Screen - All elements found");
    }
}