package pl.friscotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.friscotest.utils.SeleniumHelper;
import pl.friscotest.utils.XPathPagesConstants;

import static pl.friscotest.utils.XPathPagesConstants.AlertsPageXPaths.SAVING_COUNTER_TITLE_XPATH;

public class AlertsPage {

    @FindBy(xpath = "//p[contains(text(),'Podany przez Ciebie kod pocztowy nie znajduje się ')]")
    private WebElement incorrectPostcodeAlert;

    @FindBy(xpath = "//p[contains(text(),'Podany przez Ciebie kod pocztowy znajduje się')]")
    private WebElement correctPostcodeAlert;
    @FindBy(xpath = SAVING_COUNTER_TITLE_XPATH)
    private WebElement savingCounterTitle;
    @FindBy(xpath = "//div[contains(text(),'Podaj adres e-mail')]")
    private WebElement giveEmailAddress;
    @FindBy(xpath = "//div[contains(text(),'Hasło jest wymagane')]")
    private WebElement passwordNeeded;
    @FindBy(xpath = "//div[@class='form-input-n_error']")
    private WebElement giveEmailAddressOnRemindPasswordPage;


    private WebDriver driver;

    SeleniumHelper wait = new SeleniumHelper();

    public AlertsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getIncorrectPostcodeAlert() {
        wait.waitForElementToBeVisible(driver, incorrectPostcodeAlert);
        return incorrectPostcodeAlert;
    }

    public WebElement getCorrectPostcodeAlert() {
        wait.waitForElementToBeVisible(driver, correctPostcodeAlert);
        return correctPostcodeAlert;
    }

    public WebElement getSavingCounterTitle() {
        wait.waitForElementToExist(driver, By.xpath(SAVING_COUNTER_TITLE_XPATH));
        return savingCounterTitle;
    }

    public WebElement getGiveEmailAddressOnRemindPasswordPage() {
        wait.waitForElementToBeVisible(driver, giveEmailAddressOnRemindPasswordPage);
        return giveEmailAddressOnRemindPasswordPage;
    }
}
