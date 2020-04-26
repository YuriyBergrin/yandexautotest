package pages.yandexpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.basepage.BasePage;

public class YandexPage extends BasePage {
    public YandexPage(WebDriver driver) {
        super(driver);
    }

    private By yandexLogoLocator = By.cssSelector(".home-logo__custom img");

    public By getYandexLogoLocator() {
        return yandexLogoLocator;
    }

    @FindBy(css = "[data-id=\"market\"]")
    private WebElement marketButton;

    public WebElement getMarketButton() {
        return marketButton;
    }
}
