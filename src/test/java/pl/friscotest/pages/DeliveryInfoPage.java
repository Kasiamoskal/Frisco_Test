package pl.friscotest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.friscotest.utils.SeleniumHelper;

public class DeliveryInfoPage {

    @FindBy(xpath = "//input[@id='postcode']")
    private WebElement postCode;

    @FindBy(xpath = "//button[@title='Powiększ' and @type='button']")
    private WebElement enlargeMap;

    @FindBy(xpath = "//button[@title='Pomniejsz' and @type='button']")
    private WebElement decreaseMap;

    @FindBy(xpath = "//button[@class='button secondary higher' and contains(text(),'Zapisz się!')]")
    private WebElement newsletterSignInButton;

    @FindBy(xpath = "//div[contains(text(),'Warszawa') and @class='input']")
    private WebElement citySelection;

    @FindBy(xpath = "//div[contains(text(),'Poznań')]")
    private WebElement anotherCitySelection;


    private WebDriver driver;
    SeleniumHelper wait = new SeleniumHelper();
    Actions actions;
    MainShopPage mainShopPage;

    public DeliveryInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        actions = new Actions(driver);
        mainShopPage = new MainShopPage(driver);
    }


    public void setIncorrectPostcode(String incorrectPostcode) {
        wait.waitForElementToBeVisible(driver, postCode);
        postCode.sendKeys(incorrectPostcode);
    }

    public void setCorrectPostcode(String correctPostcode) {
        wait.waitForElementToBeVisible(driver, postCode);
        postCode.sendKeys(correctPostcode);
    }

    public void setEnlargeMap() {
        wait.waitForElementToBeVisible(driver, enlargeMap);
        enlargeMap.click();
    }

    public void setDecreaseMap() {
        wait.waitForElementToBeVisible(driver, decreaseMap);
        decreaseMap.click();
    }

    public void newsletterSignIn() {
        wait.waitForElementToBeVisible(driver, newsletterSignInButton);
        newsletterSignInButton.click();
    }

    public void selectCity() {
        wait.click(citySelection);
    }

    public void selectAnotherCity() {
        wait.click(anotherCitySelection);
    }
}
