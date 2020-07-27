package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
    private static WebDriver driver;

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriverInstance() {
        if (null == driver) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
//        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), DesiredCapabilities.chrome());

        }
        return driver;
    }

    public static void kill() {
        driver.quit();
        driver = null;
    }
}
