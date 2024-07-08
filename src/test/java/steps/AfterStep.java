package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;

public class AfterStep {
    @AfterEach
    public void tearDown(){
        WebDriverRunner.getWebDriver().quit();

    }
    @io.cucumber.java.AfterStep
    public void makeScreen(){
        Selenide.screenshot(System.currentTimeMillis()+"step");
    }
}
