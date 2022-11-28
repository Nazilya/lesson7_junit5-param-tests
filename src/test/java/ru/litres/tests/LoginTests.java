package ru.litres.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.litres.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginTests extends BaseTest{
    LoginPage loginPage = new LoginPage();

    @CsvSource(value = {"1| 12345678 | Неверное сочетание логина и пароля",
            "test@gmail.com| 1 | Неверное сочетание логина и пароля"
    }, delimiter = '|')
    @ParameterizedTest(name = "{2} when try to authorized by email {0} and password {1}")
    void UnsuccessloginTest(String login, String password, String result) {
        loginPage.clickLoginButtonForSignIn()
                .emailFill(login)
                .passwordFill(password)
                .clickSubminButton()
                .checkUnSuccessLogin(result);
    }
}
