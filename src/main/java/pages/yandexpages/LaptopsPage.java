package pages.yandexpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.basepage.BasePage;

import static java.lang.String.format;

public class LaptopsPage extends BasePage {
    public LaptopsPage(WebDriver driver) {
        super(driver);
    }

    private By laptopsHeaderLabel = By.xpath("//div/h1[text()=\"Ноутбуки\"]");
    private By resultsLocator = By.cssSelector("[data-id*=\"model\"]");
    private String countResultLocator = "//span[contains(text(),'Показывать по %s')]";
    private By resultButtonCountLocator = By.cssSelector("button[role=\"listbox\"] span");
    private By resultsListLocator = By.cssSelector("[data-id*=\"model\"]");
    private String resultElementNameLocator = "(//*[contains(@data-id,\"model\")]//h3/a)[%s]";

    @FindBy(css = "#glpricefrom")
    private WebElement priceFromTextField;

    @FindBy(css = "#glpriceto")
    private WebElement priceToTextField;

    @FindBy(xpath = "(.//*[@type='button'])[5]")
    private WebElement listBoxButton;

    public By getLaptopsHeaderLabel() {
        return laptopsHeaderLabel;
    }

    public WebElement getPriceFromTextField() {
        return priceFromTextField;
    }

    public WebElement getPriceToTextField() {
        return priceToTextField;
    }

    public By getResultsLocator() {
        return resultsLocator;
    }

    public WebElement getListBoxButton() {
        return listBoxButton;
    }

    public By getCountResultBy(String count) {
        return By.xpath(format(countResultLocator, count));
    }

    public By getResultButtonCountLocator() {
        return resultButtonCountLocator;
    }

    public By getResultsListLocator() {
        return resultsListLocator;
    }

    public WebElement getElementByNumber(int number) {
        return new WebDriverWait(driver,10).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath(format(resultElementNameLocator, number))));
    }
}
