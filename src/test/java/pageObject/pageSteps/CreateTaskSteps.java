package pageObject.pageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.time.Duration;

import static pageObject.pageElements.CreateTaskElements.*;
import static com.codeborne.selenide.Condition.visible;

public class CreateTaskSteps {

    @Step("Создаем баг и проводим по статусам до закрытого")
    public static void createTask() {
        buttonCreate.click();
        issueTypeField.click();
        issueTypeField.sendKeys("Ошибка");
        summaryField.shouldBe(visible, Duration.ofSeconds(60)).click();
        summaryField.setValue("Bug test");
        buttonText.click();
        descriptionField.click();
        descriptionField.setValue("Bug description. Actual result. Expected result");
        priorityField.click();
        priorityField.sendKeys("High");
        assigneeField.click();
        assigneeField.sendKeys("shustova");
        buttonCreateTask.click();
        linkTask.shouldBe(visible).click();
        buttonInwork.click();
        statusFieldInwork.shouldHave(Condition.text("В работе"));
        dropdownStatusTask.click();
        doneStatusTask.click();
        statusFieldDone.shouldHave(Condition.text("Готово"));
    }
}
