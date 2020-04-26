package tests.basetest;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public class BaseTest {
    protected WebDriver driver = new DriverManager().getDriver();

    @After
    public void shutdown() {
        driver.quit();
    }
}
