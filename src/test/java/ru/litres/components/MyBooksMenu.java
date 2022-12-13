package ru.litres.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class MyBooksMenu {
    private SelenideElement
            myBooksSelector = $(".MyBooks-modules__wrapper"); //локатор кнопки Мои книги в правом ерхнем углу
    public void click() {
        myBooksSelector.click();
    }


    public void navigateTo() {
        myBooksSelector.hover();
    }

}
