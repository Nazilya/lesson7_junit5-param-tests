package ru.litres.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import ru.litres.components.MyBooksMenu;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SearchPage searchPage = new SearchPage();
    private SelenideElement searchInputSelector = $(By.name("q"));
    private MyBooksMenu myBooksMenu = new MyBooksMenu();


    @Step("найти книгу на главной странице")
    public SearchPage searchBook(String value) {
        searchInputSelector.setValue(value).pressEnter();
        searchInputSelector.clear();
        return searchPage;
    }

    @Step("кликнуть  для открытия меню 'Мои книги'")
    public MainPage openMyBooksPage() {
        myBooksMenu.click();
        return this;
    }

    @Step("навести мышку на меню 'Мои книги'")
    public MainPage navigateToMyBooksDrugAndDropMenu() {
        myBooksMenu.navigateTo();
        return this;
    }

}

