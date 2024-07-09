import com.codeborne.selenide.Configuration;
import io.cucumber.java.BeforeAll;
import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.chrome.ChromeOptions;


@Suite
@Cucumber
@SelectClasspathResource("features")

public class TestBase {
    @BeforeAll
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options. addArguments("--disable-notifications");
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 6000;
        Configuration.browserCapabilities=options;
    }

}