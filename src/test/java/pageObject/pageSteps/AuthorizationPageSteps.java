package pageObject.pageSteps;

import static com.codeborne.selenide.Condition.*;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static pageObject.pageElements.AuthorizationPageElements.*;
import static utils.Configuration.getConfigurationValue;

public class AuthorizationPageSteps {

    @Step
    public static void openUrl(String url) {
        open(url);
    }

    @Step
    public static void authorization() {
        loginLane.shouldBe(visible).sendKeys(getConfigurationValue("login"));
        passwordLane.sendKeys(getConfigurationValue("password"));
        buttonLogin.shouldBe(enabled).click();
    }
}
