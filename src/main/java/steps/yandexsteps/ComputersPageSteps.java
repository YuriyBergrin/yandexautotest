package steps.yandexsteps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.yandexpages.ComputersPage;
import pages.yandexpages.LaptopsPage;
import steps.basestep.BaseSteps;

public class ComputersPageSteps extends BaseSteps {

    public ComputersPageSteps(WebDriver driver) {
        super(driver);
    }

    private ComputersPage page = new ComputersPage(driver);
    private LaptopsPage lPage = new LaptopsPage(driver);

    @Step("Выбрать раздел Ноутбуки")
    public void getLaptops() {
        page.getLaptopsButton().click();
        waitUntilElementToBeVisible(lPage.getLaptopsHeaderLabel());
    }
}
