package ru.litres.pages;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

public class MyBooksPage {
    private ElementsCollection navigationMenuItems = $$x("//ul[@class='my-books-list']//li");
    private ElementsCollection myBooksMenuElement = $$(".MyBooksMenu-module__item_moFw2"); //их 6 -  список элементов выпадающего меню Мои книги

    @Step("проверить количество элементов меню 'Мои книги'")
    public MyBooksPage checkMyBooksNavMenuElementsCount(int resultCount) {
        navigationMenuItems.should(CollectionCondition.size(resultCount));
        return this;
    }
    @Step("проверить названия элементов меню 'Мои книги'")
    public MyBooksPage checkMyBooksNavMenuElements(List<String> buttonsName) {
        navigationMenuItems.filter(visible)
                .shouldHave(CollectionCondition.texts(buttonsName));
        return this;
    }
    @Step("проверить количество элементов выпадаюего меню 'Мои книги'")
    public MyBooksPage checkMyBooksDrugAndDropMenuElementsCount(int resultCount) {
        myBooksMenuElement.should(CollectionCondition.size(resultCount));
        return this;
    }
    @Step("проверить названия элементов выпадаюего меню 'Мои книги'")
    public MyBooksPage checkMyBooksDrugAndDropMenuElements(List<String> buttonsName) {
        myBooksMenuElement.filter(visible)
                .shouldHave(CollectionCondition.texts(buttonsName));
        return this;
    }
}
