package ru.litres.pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    SearchPage searchPage = new SearchPage();
    private final SelenideElement searchInputSelector = $(By.name("q"));
    private final SelenideElement myBooksSelector = $x("//div[@class='MyBooks-modules__wrapper']//a"); //локатор кнопки Мои книги в правом ерхнем углу

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

