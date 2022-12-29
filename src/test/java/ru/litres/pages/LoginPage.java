package ru.litres.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.litres.elements.Button;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private SelenideElement
//            loginButton = $(".Login-module__wrapper"),
            loginButton = $("a[href='/pages/login/']"),
            emailButton = $x("//button[.='Электронная почта']"),
            email = $("input[name='email']"),
            nextButton = $x("//button[.='Продолжить']"),
            passField = $(By.name("pwd")),
            userName = $(".Profile-module__name"),
            checkUnSuccessMessage = $(".AuthorizationPopup-module__error_1sCCK"),
            authorizationPopup = $(".AuthorizationPopup-module__closeIcon");
    private Button submitButton = new Button("Войти", $x("//button[.='Войти']"));

    @Step("нажать на кнопку Логин")
    public LoginPage clickLoginButtonForSignIn() {
        loginButton.click();
        return this;
    }
    @Step("заполнить поле Электронная почта")
    public LoginPage emailFill(String value) {
        emailButton.click();
        email.setValue(value);
        return this;
    }
    @Step("заполнить поле пароль")
    public LoginPage passwordFill(String value) {
        nextButton.click();
        passField.setValue(value);
        return this;
    }
    @Step("нажать на кнопку Войти")
    public LoginPage clickSubminButton() {
        submitButton.click();
        return this;
    }
    @Step("проверить сообщение об ошибке при неудачной попытке входа")
    public void checkUnSuccessLogin(String value) {
        checkUnSuccessMessage.shouldHave(text(value));
    }
}
