package steps.addToFavorite;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class BeforeAdd {
    @Given("Открыт сайт {string}")
    public void openUrl(String url) {
        open(url);

    }
}
