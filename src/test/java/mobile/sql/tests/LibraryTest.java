package mobile.sql.tests;

import mobile.sql.helpers.Attach;
import mobile.sql.screens.LibraryScreen;
import mobile.sql.screens.SqlPracticeScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

@Tag("smoke")
public class LibraryTest extends MobileTestBase {

    SqlPracticeScreen sqlScreen = new SqlPracticeScreen();
    LibraryScreen libraryScreen = new LibraryScreen();

    @Test
    @DisplayName("Проверка библиотеки SQL Practice PRO")

    void libraryTest() {
        // Шаг 1: Обрабатываем приветственное меню
        sqlScreen.clickOkButton();

        // Даем время приложению загрузиться
        sleep(3000);

        // Шаг 2: Заходим в основное меню и нажимаем кнопку Library
        libraryScreen.clickLibraryButton();

        // Даем время диалогу открыться
        sleep(2000);

        // Шаг 3: Проверяем, что открылось окно с названием Library
        libraryScreen.verifyLibraryTitle();

        // Шаг 4: Нажимаем кнопку Close и проверяем, что окно закрылось
        libraryScreen.clickCloseButton();

        // Даем время диалогу закрыться
        sleep(1000);
    }
}