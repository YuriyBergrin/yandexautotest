package steps.yandexsteps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.yandexpages.YandexMarketPage;
import pages.yandexpages.YandexPage;
import steps.basestep.BaseSteps;

import java.util.Set;

public class YandexPageSteps extends BaseSteps {

    public YandexPageSteps(WebDriver driver) {
        super(driver);
    }

    private YandexPage page = new YandexPage(driver);
    private YandexMarketPage ymPage = new YandexMarketPage(driver);

    @Override
    public void openPage(String url) {
        super.openPage(url);
        waitUntilElementToBeVisible(page.getYandexLogoLocator());
    }

    @Step("Перейти в яндекс маркет")
    public void getMarket() {
        final Set<String> oldWindowsSet = driver.getWindowHandles();
        page.getMarketButton().click();
        switchToNewWindow(oldWindowsSet);
        waitUntilElementToBeVisible(ymPage.getYandexMarketLogoLocator());
        try {
            ymPage.getAcceptRegionButton().click();
        } catch (Exception e) {
            System.out.println("Кнопка принятия региона не появилась!");
        }
    }

}
