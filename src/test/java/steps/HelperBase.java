package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class HelperBase {
    public void click(SelenideElement element){
        element.shouldBe(Condition.enabled).click();
    }
}
