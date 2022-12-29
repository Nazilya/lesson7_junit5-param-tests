package ru.litres.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {
    private SelenideElement
            searchResult = $x("//h1"),
            searchedBooks = $(".Book-module__image_2zzY0");

    @Step("проверить результат поиска книги")
    public SearchPage checkResultOfSearchMessage(String result) {
        searchResult.shouldHave(text(result));
        return this;
    }
}
