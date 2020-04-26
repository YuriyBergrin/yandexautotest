package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private WebDriver driver;

    public WebDriver getDriver() {
        /**
         * если на машине не прописан в path путь до драйвера,
         * раскоментируй строчку ниже и положи в паку drivers свой драйвер
         * у меня лежит драйвер для линукс, под хром 81 версии
         */
        //System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
