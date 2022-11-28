package ru.litres.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.litres.pages.MainPage;
import ru.litres.pages.SearchPage;

public class SearchTests extends BaseTest {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @CsvFileSource(resources = "/searchBook.csv")
    @ParameterizedTest(name = "{1} при поиске книги с названием {0}")
    void searchBooksTest1(String bookName, String resultMessage) {
        mainPage.searchBook(bookName);
        searchPage.checkResultOfSearchMessage(resultMessage);
    }
}
