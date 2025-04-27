import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParameterizedLoginTests {

    static List<LoginTestData> provideTestData() throws IOException {
        String filePath = "src/test/resources/testdata.xlsx";
        return ExcelTestDataReader.readLoginTestData(filePath);
    }

    @DisplayName("Параметризированный тест входа в систему")
    @ParameterizedTest(name = "{0}")
    @MethodSource("provideTestData")
    void loginTest(LoginTestData testData) {
        open("https://slqa.ru/cases/ChatGPTLogin/");

        $("#username").sendKeys(testData.getUsername());
        $("#password").sendKeys(testData.getPassword());
        $("#loginButton").click();

        // Проверка сообщения
        $("#message")
                .shouldHave(text(testData.getExpectedMessage()))
                .shouldBe(testData.isVisible() ? visible : not(visible))
                .shouldBe(cssClass(testData.getCssClass()));

        // Проверка приветствия
        if (testData.isGreetingVisible()) {
            $("#greeting")
                    .shouldHave(text(testData.getExpectedGreeting()))
                    .shouldBe(visible);
        } else {
            $("#greeting")
                    .shouldBe(empty)
                    .shouldNotBe(visible);
        }
    }
}
