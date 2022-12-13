package ru.litres.pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SearchPage searchPage = new SearchPage();
    private SelenideElement searchInputSelector = $(By.name("q")),
            myBooksSelector = $(".MyBooks-modules__wrapper"); //локатор кнопки Мои книги в правом ерхнем углу

    @DisplayName("Search book on the main page")
    public SearchPage searchBook(String value) {
        searchInputSelector.setValue(value).pressEnter();
        searchInputSelector.clear();
        return searchPage;
    }

    @DisplayName("Click to open MyBooksMenu")
    public MainPage openMyBooksPage() {
        myBooksSelector.click();
        return this;
    }

    @DisplayName("Navigate to hover MyBooksMenu")
    public MainPage navigateToMyBooksDrugAndDropMenu() {
        myBooksSelector.hover();
        return this;
    }

}

