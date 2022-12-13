package ru.litres.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.litres.pages.MainPage;
import ru.litres.pages.MyBooksPage;
import java.util.List;
import java.util.stream.Stream;

public class MyBooksTests extends BaseTest {

    private MainPage mainPage = new MainPage();
    private MyBooksPage myBooksPage = new MyBooksPage();

    static Stream<Arguments> checkMyBooksMenuButtonsTest() {
        return Stream.of(
                Arguments.of(7, List.of("Все", "Мои", "Просмотренные", "Отложенные", "Корзина", "Списки", "Архив"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка наличия кнопок {1} в меню Мои книги и их общее кол-во {0}")
    void checkMyBooksMenuButtonsTest(int count, List<String> buttonsNames) {
        SelenideLogger.addListener("allure", new AllureSelenide());
        mainPage.openMyBooksPage();
        myBooksPage
                .checkMyBooksNavMenuElementsCount(count)
                .checkMyBooksNavMenuElements(buttonsNames);
    }

    static Stream<Arguments> checkMyBooksDrugAndDropMenuButtonsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        return Stream.of(
                Arguments.of(6, List.of("Все", "Мои", "Просмотренные", "Отложенные", "Корзина", "Списки"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка наличия кнопок {1} в выпадающем меню Мои книги и их общее кол-во {0}")
    void checkMyBooksDrugAndDropMenuButtonsTest(int count, List<String> buttonsNames) {
        SelenideLogger.addListener("allure", new AllureSelenide());
        mainPage.navigateToMyBooksDrugAndDropMenu();
        myBooksPage
                .checkMyBooksDrugAndDropMenuElementsCount(count)
                .checkMyBooksDrugAndDropMenuElements(buttonsNames);
    }
}
