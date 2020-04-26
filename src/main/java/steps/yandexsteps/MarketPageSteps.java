package steps.yandexsteps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.yandexpages.ComputersPage;
import pages.yandexpages.YandexMarketPage;
import steps.basestep.BaseSteps;

public class MarketPageSteps extends BaseSteps {

    public MarketPageSteps(WebDriver driver) {
        super(driver);
    }

    private YandexMarketPage page = new YandexMarketPage(driver);
    private ComputersPage cPage = new ComputersPage(driver);

    @Step("Выбрать раздел Компьютеры")
    public void getComputers() {
        page.getComputersButton().click();
        waitUntilElementToBeVisible(cPage.getComputersHeaderLabel());
    }

    @Step("В поисковую строку ввести значение {0}.")
    public void setToSearchInput(String value) {
        page.getSearchInput().sendKeys(value);
    }

    @Step("Нажать кнопку «Найти»")
    public void clickSearchButton() {
        page.getSearchButton().click();
    }
}
