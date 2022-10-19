package pageObject.pageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.*;
import static pageObject.pageElements.ProjectPageElements.*;

public class ProjectPageSteps {
    @Step("Открываем проект Test")
    public static void openProject() {

        buttonProject.shouldBe(Condition.enabled).click();
        buttonAllProject.shouldBe(Condition.visible).click();
        searchProject.setValue("Test");
        searchProject.pressEnter();
        linkProject.shouldHave(Condition.exactText("Test")).click();
    }

    @Step("Проверяем количество задач")
    public static void findTasksAmount() {
        tasksList.shouldBe(Condition.enabled).click();
        String text = tasksAmount.getText();
        String amount = text.substring(text.lastIndexOf("з") + 1);
        assertNotNull(amount);
    }

    @Step("Находим задачу TestSelenium_bug")
    public static void searchTask() {
        taskFilter.shouldBe(Condition.enabled).click();
        buttonAllTasks.click();
        searchField.shouldBe(Condition.empty).setValue("TestSelenium_bug");
        searchField.pressEnter();
    }

    @Step("Проверяем затронутую версию Version 2.0")
    public static void checkVersion() {
        String version = taskVersion.getText();
        assertEquals("Version 2.0", version);

    }

    @Step("Проверяем статус задачи")
    public static void checkStatus() {
        taskStatus.shouldBe(visible);
        String status = taskStatus.getText();
        assertEquals("СДЕЛАТЬ", status);
    }
}
