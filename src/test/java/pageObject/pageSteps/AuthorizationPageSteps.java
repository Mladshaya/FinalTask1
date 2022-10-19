package pageObject.pageSteps;

import static com.codeborne.selenide.Condition.*;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static pageObject.pageElements.AuthorizationPageElements.*;

public class AuthorizationPageSteps {

    @Step("Открываем страницу по ссылке https://edujira.ifellow.ru/")
    public static void openUrl(String url) {
        open(url);
    }

    @Step("Авторизуемся в системе под пользователем shustova")
    public static void authorization(String login, String password) {
        loginLane.shouldBe(visible).sendKeys(login);
        passwordLane.shouldBe(visible).sendKeys(password);
        buttonLogin.shouldBe(enabled).click();
    }
}
