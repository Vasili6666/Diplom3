package mobile.sql.tests;

import mobile.sql.helpers.Attach;
import mobile.sql.screens.SettingsScreen;
import mobile.sql.screens.SqlPracticeScreen;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;


public class SettingsTest extends MobileTestBase {

    SqlPracticeScreen sqlScreen = new SqlPracticeScreen();
    SettingsScreen settingsScreen = new SettingsScreen();

    @Test
    @DisplayName("Проверка всех элементов в настройках SQL Practice PRO")
    void settingsTest() {

        sqlScreen.clickOkButton();
        sleep(3000);
        settingsScreen.clickSettingsButton();
        sleep(2000);
        settingsScreen.verifySettingsTitle();
        settingsScreen.verifyAllSettingsElements();

        Attach.screenshotAs("Settings Screen - All elements found");
    }
}