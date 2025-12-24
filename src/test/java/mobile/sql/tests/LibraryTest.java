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

        sqlScreen.clickOkButton();
        sleep(3000);
        libraryScreen.clickLibraryButton();
        sleep(2000);
        libraryScreen.verifyLibraryTitle();
        libraryScreen.clickCloseButton();
        sleep(1000);
    }
}