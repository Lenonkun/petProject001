package steps.addToFavorite;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import steps.HelperBase;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StepsAdd extends HelperBase {
    private static final Logger LOG = LoggerFactory.getLogger(StepsAdd.class);

    private final SelenideElement linkTehn = $("nav > ul > li:nth-child(3) > a");
    //
    private final SelenideElement mobileLink = $("div > div:nth-child(4) > a > div.label > div");
    private final SelenideElement smartLink = $("div[class='centered-']",0);
    private final SelenideElement showResultSearch = $("div > div.fb-button-cover.mt10.mb10 > button");
    private final SelenideElement favorites=
            $("div > a.header-navigation-links__link.header-navigation-links__link-title.js-favorite-page-link");

    private final SelenideElement selectedPhone =
            $("li[class='cpl-item cp-item js-catalogue-item js-conversion-target'");
    private String selectedPhoneId;



    @When("найти в каталоге телефон не дороже {int} рублей")
    public void searchNotebook(int price) {
        click(linkTehn);
        LOG.info("Открыт раздел с названием \"Техника\"");
        click(mobileLink);
        LOG.info("Открыт раздел \"Мобильные телефоны и аксессуары\"");

        click(smartLink);
        LOG.info("Перешли в раздел \"Смартфоны\"");
        $("input[class='fp-input js-price-max js-traits-price']").setValue(String.valueOf(price));
        LOG.info("Установлен фильтр максимальной цены");
        click(showResultSearch);
        LOG.info("Применён фильтр");
    }

    @And("добавить его в избранное")
    public void addToFavorite() {
        click(selectedPhone.$("button[title='Добавить в избранное']"));
        LOG.info("Телефон добавлен в избранное");
        selectedPhoneId=selectedPhone.getAttribute("data-product-id");
    }

    @Then("Телефон добавлен в избранное и его стоимость меньше  {int}")
    public void assertToFavorite(int expectPrice) {
        click(favorites);
        LOG.info("Открыт каталог избранных товаров");
        click($("div.main-column > nav > ul > li:nth-child(1) > a"));
        LOG.info("Выбрана вкладка Товаров и услуг");


        boolean existsPhone = $("[data-product-id='"+selectedPhoneId+"']").exists();
        assertTrue(existsPhone,"Телефон отсутстует в избранном");
        LOG.info("Выбранный телефон присутствует в избранном");

        int actualPrice = Integer.parseInt($("i[data-price-type='discount-new']")
                .getText()
                .replace(" ",""));
        boolean comparePrice = actualPrice<expectPrice;
        assertTrue(comparePrice, "Телефон стоит дороже, чем ожидали");
        LOG.info("Цена выбранного телефона в пределах ожидаемой");
        click($("div > ul > li > div > noindex > div > button"));

    }

}
