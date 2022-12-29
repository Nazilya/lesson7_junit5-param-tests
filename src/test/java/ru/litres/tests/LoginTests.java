package ru.litres.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.litres.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginTests extends BaseTest{
    private LoginPage loginPage = new LoginPage();

    @CsvSource(value = {"1| 12345678 | Неверное сочетание логина и пароля",
            "test@gmail.com| 1 | Неверное сочетание логина и пароля"
    }, delimiter = '|')
    @ParameterizedTest(name = "{2} при попытке авторизоваться с эл почтой {0} и паролем {1}")
    @Tag("UITests")
    void unsuccessloginTest(String login, String password, String result) {
        loginPage.clickLoginButtonForSignIn()
                .emailFill(login)
                .passwordFill(password)
                .clickSubminButton()
                .checkUnSuccessLogin(result);
    }
}
