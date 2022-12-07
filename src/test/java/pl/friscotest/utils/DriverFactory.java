package pl.friscotest.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class DriverFactory {

    private static ChromeDriver chromeDriver;

    public static WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        return chromeDriver = Objects.isNull(chromeDriver) ? new ChromeDriver() : chromeDriver;
    }
    public static void cleanDriver(){
        chromeDriver = null;
    }
}
