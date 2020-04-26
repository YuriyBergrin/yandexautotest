package steps.yandexsteps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.yandexpages.LaptopsPage;
import steps.basestep.BaseSteps;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LaptopsPageSteps extends BaseSteps {

    public LaptopsPageSteps(WebDriver driver) {
        super(driver);
    }

    private LaptopsPage page = new LaptopsPage(driver);
    private String elementName;

    @Step("Задать параметр «Цена, Р» от {0} до {1} рублей.")
    public void setPrice(String priceFrom, String priceTo) {
        page.getPriceFromTextField().sendKeys(priceFrom);
        page.getPriceToTextField().sendKeys(priceTo);
    }

    @Step("Выбрать производителей {makers}")
    public void setMakers(List<String> makers) {
        for (String maker : makers
        ) {
            driver.findElement(By.xpath("//*[contains(@name,\"" + maker + "\")]/parent::label/div")).click();
        }
    }

    @Step("Дождаться результатов поиска.")
    public void waitSearchResults() {
        waitUntilElementToBeClickable(page.getResultsLocator());
    }

    @Step("Установить количество показываемых элементов на страницу {0}")
    public void setCountResult(String count) {
        for (int i = 0; i < 3; i++) {
            page.getListBoxButton().click();
            driver.findElement(page.getCountResultBy(count)).click();
            waitUntilElementToBeClickable(page.getResultButtonCountLocator());
            if (driver.findElement(page.getResultButtonCountLocator()).getText().equals("Показывать по " + count)) {
                break;
            }
        }
    }

    @Step("Проверить, что на странице отобразилось {0} элементов.")
    public void assertResultsCount(int count) {
        List<WebElement> results = wait.until(ExpectedConditions.numberOfElementsToBe((page.getResultsListLocator()), 12));
        assertEquals(results.size(), count);
    }

    @Step("Запомнить наименование первого значения в списке")
    public void rememberElementNameByNumber(int number) {
        elementName = page.getElementByNumber(number).getText();
    }

    @Step("Проверить, что наименование товара соответствует значению {0}.")
    public void assertSearchResult(String value) {
        assertTrue(page.getElementByNumber(1).getText().contains(value));
    }

    public String getElementName() {
        return elementName;
    }
}
