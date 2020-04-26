package pages.yandexpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.basepage.BasePage;

public class ComputersPage extends BasePage {
    public ComputersPage(WebDriver driver) {
        super(driver);
    }

    private By computersHeaderLabel = By.xpath("//*[text()=\"Компьютерная техника\"]");

    @FindBy(xpath = "//a[text()=\"Ноутбуки\"]")
    private WebElement laptopsButton;

    public By getComputersHeaderLabel() {
        return computersHeaderLabel;
    }

    public WebElement getLaptopsButton() {
        return laptopsButton;
    }
}
