package mobile.sql.tests;

import mobile.sql.helpers.Attach;
import mobile.sql.screens.SqlPracticeScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.screenshot;

@Tag("mobile")
public class SqlQueryTest extends MobileTestBase {


    SqlPracticeScreen sqlScreen = new SqlPracticeScreen();

    @Test
    @DisplayName("Выполнение SQL запроса в приложении SQL Practice PRO")
    void sqlQueryTest() {

        sqlScreen
                .clickOkButton()
                .selectTask()
                .enterSqlQuery()
                .submitQuery()
                .verifyResults();

        screenshot("sql_query_results");
        Attach.screenshotAs("SQL Query Results");
        Attach.pageSource();
    }
}