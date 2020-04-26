package pages.yandexpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.basepage.BasePage;

public class YandexMarketPage extends BasePage {
    public YandexMarketPage(WebDriver driver) {
        super(driver);
    }

    private By yandexMarketLogoLocator = By.cssSelector("#logoPartMarket");

    @FindBy(xpath = "//span[text()=\"Да, спасибо\"]")
    private WebElement acceptRegionButton;

    @FindBy(css = "[href*=\"kompiuternaia-tekhnika\"]")
    private WebElement computersButton;

    @FindBy(css = "#header-search")
    private WebElement searchInput;

    @FindBy(css = "[type=\"submit\"]")
    private WebElement searchButton;

    public WebElement getAcceptRegionButton() {
        return acceptRegionButton;
    }

    public WebElement getComputersButton() {
        return computersButton;
    }

    public By getYandexMarketLogoLocator() {
        return yandexMarketLogoLocator;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }
}
