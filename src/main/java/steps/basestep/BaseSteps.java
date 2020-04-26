package steps.basestep;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BaseSteps {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @Step("Зайти на {0}")
    public void openPage(String url) {
        driver.get(url);
    }

    public void waitUntilElementToBeVisible(By locator) {
        wait.until(visibilityOfElementLocated(locator));
    }

    public void waitUntilElementToBeClickable(By locator){
        wait.until(elementToBeClickable(locator));
    }

    public void switchToNewWindow(final Set<String> oldWindowsSet) {
        String newWindow = (wait)
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );
        driver.close();
        driver.switchTo().window(newWindow);
    }
}
