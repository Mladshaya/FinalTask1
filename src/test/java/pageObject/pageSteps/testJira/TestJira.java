package pageObject.pageSteps.testJira;

import hooks.WebHooks;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import static pageObject.pageSteps.AuthorizationPageSteps.authorization;
import static pageObject.pageSteps.AuthorizationPageSteps.openUrl;
import static pageObject.pageSteps.CreateTaskSteps.*;
import static pageObject.pageSteps.ProjectPageSteps.*;
import static utils.Configuration.getConfigurationValue;

@DisplayName("TestJira")
public class TestJira extends WebHooks {

    @Test
    @Tag("1")
    @DisplayName("ТК 1. Авторизация")
    public void Test_1() {
        openUrl(getConfigurationValue("jiraUrl"));
        authorization();
    }

    @Test
    @Tag("2")
    @DisplayName("ТК 2. Открытие проекта")
    public void Test_2() {
        openUrl(getConfigurationValue("jiraUrl"));
        authorization();
        openProject();
    }

    @Test
    @Tag("3")
    @DisplayName("ТК 3. Нахождение количества заведенных задач в проекте")
    public void Test_3() {
        openUrl(getConfigurationValue("jiraUrl"));
        authorization();
        openProject();
        findTasksAmount();
    }

    @Test
    @Tag("4")
    @DisplayName("ТК 4. Проверка статуса и версии задачи")
    public void Test_4() {
        openUrl(getConfigurationValue("jiraUrl"));
        authorization();
        openProject();
        findTasksAmount();
        searchTask();
        checkVersion();
        checkStatus();
    }

    @Test
    @Tag("5")
    @DisplayName("ТК 5. Заведение дефекта и проверка смены статусов")
    public void Test_5() {
        openUrl(getConfigurationValue("jiraUrl"));
        authorization();
        openProject();
        findTasksAmount();
        searchTask();
        checkVersion();
        checkStatus();
        createTask();

    }
}
