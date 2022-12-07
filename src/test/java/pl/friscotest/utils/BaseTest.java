package pl.friscotest.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.frisco.pl/");
    }

    @AfterMethod
    public void turnDown(ITestResult testResult) {

        if(!testResult.isSuccess()){
            DriverFactory.cleanDriver();
            return;
        }
        driver.quit();
        DriverFactory.cleanDriver();
    }
}
