package ru.litres.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.litres.pages.MainPage;
import ru.litres.pages.SearchPage;

public class SearchTests extends BaseTest {
    private MainPage mainPage = new MainPage();
    private SearchPage searchPage = new SearchPage();

    @CsvFileSource(resources = "/searchBook.csv")
    @ParameterizedTest(name = "{1} при поиске книги с названием {0}")
    @Tag("UITests")
    void searchBooksTest1(String bookName, String resultMessage) {
        mainPage.searchBook(bookName);
        searchPage.checkResultOfSearchMessage(resultMessage);
    }
}
