package tests.yandextests;

import io.qameta.allure.Story;
import org.junit.Test;
import steps.yandexsteps.ComputersPageSteps;
import steps.yandexsteps.LaptopsPageSteps;
import steps.yandexsteps.MarketPageSteps;
import steps.yandexsteps.YandexPageSteps;
import tests.basetest.BaseTest;
import utils.DataManager;

import java.util.Arrays;

@Story("Поиск товара в маркете")
public class YandexMarketTest extends BaseTest {
    private YandexPageSteps yandexPageSteps = new YandexPageSteps(driver);
    private MarketPageSteps marketPageSteps = new MarketPageSteps(driver);
    private ComputersPageSteps computersPageSteps = new ComputersPageSteps(driver);
    private LaptopsPageSteps laptopsPageSteps = new LaptopsPageSteps(driver);
    private String url = DataManager.getValue("yandex_url");

    @Test
    public void marketTest() {
        yandexPageSteps.openPage(url);
        yandexPageSteps.getMarket();
        marketPageSteps.getComputers();
        computersPageSteps.getLaptops();
        laptopsPageSteps.setPrice("10000", "30000");
        laptopsPageSteps.setMakers(Arrays.asList("Lenovo", "HP"));
        laptopsPageSteps.waitSearchResults();
        laptopsPageSteps.setCountResult("12");
        laptopsPageSteps.waitSearchResults();
        laptopsPageSteps.assertResultsCount(12);
        laptopsPageSteps.rememberElementNameByNumber(1);
        marketPageSteps.setToSearchInput(laptopsPageSteps.getElementName());
        marketPageSteps.clickSearchButton();
        laptopsPageSteps.assertSearchResult(laptopsPageSteps.getElementName());
    }
}
