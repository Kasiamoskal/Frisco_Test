package pl.friscotest.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public WebDriver driver;
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentReports extentReports;


    @BeforeSuite
    public void beforeSuite() {
        String name="report";
        int randomNumber = (int)(Math.random()*100);
        htmlReporter = new ExtentHtmlReporter(name+randomNumber+".html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    @AfterSuite
    public void afterSuite() {
        htmlReporter.flush();
        extentReports.flush();

    }

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.frisco.pl/");
    }

    @AfterMethod
    public void turnDown(ITestResult testResult) {

        if (!testResult.isSuccess()) {
            DriverFactory.cleanDriver();
            return;
        }
        driver.quit();
        DriverFactory.cleanDriver();
    }
}
