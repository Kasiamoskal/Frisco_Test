package pl.friscotest.utils;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumHelper {

    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait;
    Actions actions;

    JavascriptExecutor js;

    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);

        wait.ignoring(StaleElementReferenceException.class);
    }

    public void click(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        actions.click(webElement).perform();
    }

    public void scrollAndClick(@NotNull WebElement webElement){
        if(!webElement.isDisplayed()){
            js.executeScript("arguments[0].scrollIntoView();", webElement);
        }
        click(webElement);
    }

    public void waitForElementToExist (WebDriver driver, By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }
    public void waitForElementToBeVisible (WebDriver driver, WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public void waitForElementToBeClickable(WebDriver driver, By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
