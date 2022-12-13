package ru.litres.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.litres.elements.Button;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private SelenideElement
//            loginButton = $(".Login-module__wrapper"),
            loginButton = $(".Login-module__loginLink"),
            emailButton = $x("//button[.='Электронная почта']"),
            email = $(".AuthorizationPopup-module__input"),
            nextButton = $x("//button[.='Продолжить']"),
            passField = $(By.name("pwd")),
            userName = $(".Profile-module__name"),
            checkUnSuccessMessage = $(".AuthorizationPopup-module__error"),
            authorizationPopup = $(".AuthorizationPopup-module__closeIcon");
    private Button submitButton = new Button("Войти", $x("//button[.='Войти']"));

    public LoginPage clickLoginButtonForSignIn() {
        loginButton.click();
        return this;
    }

    public LoginPage emailFill(String value) {
        emailButton.click();
        email.setValue(value);
        return this;
    }

    public LoginPage passwordFill(String value) {
        nextButton.click();
        passField.setValue(value);
        return this;
    }

    public LoginPage clickSubminButton() {
        submitButton.click();
        return this;
    }
    public void checkUnSuccessLogin(String value) {
        checkUnSuccessMessage.shouldHave(text(value));
    }
}
