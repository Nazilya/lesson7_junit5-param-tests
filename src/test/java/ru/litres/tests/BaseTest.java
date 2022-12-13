package ru.litres.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
//        Configuration.timeout = 5000;  //5 сек
//        Configuration.baseUrl = "https://www.litres.ru/";
//        Configuration.browser = "Firefox";
    }

    @BeforeEach
    void setUp() {
        open("https://www.litres.ru/");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


//    @AfterEach
//    public void tearDown() {
//        Selenide.closeWindow();
//    }

}
/*
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
 */
