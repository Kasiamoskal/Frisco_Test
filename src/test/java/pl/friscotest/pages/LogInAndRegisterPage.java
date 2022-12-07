package pl.friscotest.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.friscotest.utils.SeleniumHelper;

import static pl.friscotest.utils.XPathPagesConstants.LogInAndRegisterPageXPaths.*;

public class LogInAndRegisterPage {

    @FindBy(xpath = "//a[contains(text(),'Zaloguj się')]")
    private WebElement logInWithAccount;
    @FindBy(xpath = "//div[@class='icon-comp Logo']")
    private WebElement logo;
    @FindBy(xpath = "//input[@id='fullName.firstName']")
    private WebElement name;
    @FindBy(xpath = "//input[@id='fullName.lastName']")
    private WebElement surname;
    @FindBy(xpath = "//input[@id='phoneNumber']")
    private WebElement phoneNumber;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailAddress;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;
    @FindBy(xpath = "//input[@id='postcode']")
    private WebElement postcode;
    @FindBy(xpath = ALL_CONSENTS_CHECKBOX_XPATH)
    private WebElement checkboxAllConsents;
    @FindBy(xpath = ACCEPT_CONDITIONS_CHECKBOX_XPATH)
    private WebElement acceptRulesCheckbox;
    @FindBy(xpath = NEWSLETTER_AGREEMENT_CHECKBOX_XPATH)
    private WebElement checkboxNewsletterConsent;
    @FindBy(xpath = PROMO_INFO_CHECKBOX_XPATH)
    private WebElement checkboxPromoConsent;
    @FindBy(xpath = MAIL_NEWSLETTER_CHECKBOX_XPATH)
    private WebElement checkboxMailNewsletterConsent;
    @FindBy(xpath = "//button[@class='button cta higher alone center']")
    private WebElement createAccountButton;
    @FindBy(xpath = "//a[@href='/regulamin']")
    private WebElement regulationsLink;
    @FindBy(xpath = EXPAND_BOTTOM_BAR)
    private WebElement bottomSideBar;
    @FindBy(xpath = BOTTOM_BAR_TEXT_MESSAGE_XPATH)
    private WebElement messageTextSideBar;
    @FindBy(xpath = PROCEED_BUTTON_BOTTOM_BAR_XPATH)
    private WebElement proceedButtonSideBar;
    @FindBy(xpath = "//div[@class='register-link']/a")
    private WebElement registerLink;
    @FindBy(xpath = "//div[@class='icon-comp EyeOpen']")
    private WebElement eyeIcon;
    @FindBy(xpath = "//button[@class='button cta higher']")
    private WebElement logInButton;
    @FindBy(xpath = "//a[@href='/password']")
    private WebElement remindPassword;
    @FindBy(xpath = "//button[@class='button cta higher non-click']")
    private WebElement resetPassword;
    @FindBy(xpath = "//button[@class='button transparent higher go-back']")
    private WebElement goBackButton;

    SeleniumHelper wait = new SeleniumHelper();
    MainShopPage mainShopPage;
    Actions actions;
    JavascriptExecutor js;
    private WebDriver driver;

    public LogInAndRegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        mainShopPage = new MainShopPage(driver);
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    public LogInAndRegisterPage goToLogInPage() {
        mainShopPage.acceptCookiesButton();
        mainShopPage.goToLogInPage();
        return this;
    }

    public LogInAndRegisterPage goToRegisterPage() {
        mainShopPage.acceptCookiesButton();
        mainShopPage.goToRegisterPage();
        return this;
    }

    public LogInAndRegisterPage goToRegisterPageFromLogIn() {
        wait.waitForElementToBeVisible(driver, registerLink);
        registerLink.click();
        return this;
    }

    public LogInAndRegisterPage setName(String firstName) {
        wait.click(name);
        name.sendKeys(firstName);
        return this;
    }

    public LogInAndRegisterPage setSurname(String lastName) {
        wait.click(surname);
        surname.sendKeys(lastName);
        return this;
    }

    public LogInAndRegisterPage setPhoneNumber(String number) {
        wait.click(phoneNumber);
        phoneNumber.sendKeys(number);
        return this;
    }

    public LogInAndRegisterPage setEmailAddress(String email) {
        wait.waitForElementToBeVisible(driver,emailAddress);
        emailAddress.sendKeys(email);
        return this;
    }

    public LogInAndRegisterPage setPassword(String typePassword) {
        wait.click(password);
        password.sendKeys(typePassword);
        return this;
    }

    public LogInAndRegisterPage setPostcode(String typePostcode) {
        postcode.click();
        postcode.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        postcode.sendKeys(typePostcode);
        return this;
    }

    public LogInAndRegisterPage allConsentsCheckbox() {
        wait.waitForElementToBeClickable(driver, By.xpath(ALL_CONSENTS_CHECKBOX_XPATH));
        checkboxAllConsents.click();
        return this;
    }

    public LogInAndRegisterPage acceptRulesCheckbox() {
        wait.waitForElementToExist(driver, By.xpath(ACCEPT_CONDITIONS_CHECKBOX_XPATH));
       actions.click(acceptRulesCheckbox).perform();
        return this;
    }

    public LogInAndRegisterPage newsletterCheckbox() {
        wait.waitForElementToExist(driver, By.xpath(NEWSLETTER_AGREEMENT_CHECKBOX_XPATH));
        actions.click(checkboxNewsletterConsent).perform();
        return this;
    }

    public LogInAndRegisterPage promoConsentCheckbox() {
        wait.waitForElementToExist(driver, By.xpath(PROMO_INFO_CHECKBOX_XPATH));
        actions.click(checkboxPromoConsent).perform();
        return this;
    }

    public LogInAndRegisterPage mailNewsletterCheckbox() {
        wait.waitForElementToExist(driver, By.xpath(MAIL_NEWSLETTER_CHECKBOX_XPATH));
        js.executeScript("arguments[0].scrollIntoView();", checkboxMailNewsletterConsent);
        actions.click(checkboxMailNewsletterConsent).perform();
        return this;
    }

    public LogInAndRegisterPage createAccount() {
        wait.waitForElementToBeVisible(driver, createAccountButton);
        createAccountButton.click();
        return this;
    }

    public LogInAndRegisterPage bottomBarExpand() {
        wait.waitForElementToExist(driver, By.xpath(EXPAND_BOTTOM_BAR));
        bottomSideBar.click();
        return this;
    }

    public LogInAndRegisterPage bottomBarMessage(String message) {
        wait.waitForElementToExist(driver, By.xpath(BOTTOM_BAR_TEXT_MESSAGE_XPATH));
        messageTextSideBar.sendKeys(message);
        return this;
    }

    public LogInAndRegisterPage proceedBottomBar() {
        wait.waitForElementToBeClickable(driver, By.xpath(PROCEED_BUTTON_BOTTOM_BAR_XPATH));
        proceedButtonSideBar.click();
        return this;
    }

    public LogInAndRegisterPage goToLogInFromRegisterPage() {
        wait.waitForElementToBeVisible(driver, logInWithAccount);
        logInWithAccount.click();
        return this;
    }

    public LogInAndRegisterPage eyeIconButton(String typePassword) {
        wait.waitForElementToBeVisible(driver, password);
        password.sendKeys(typePassword);
        eyeIcon.click();
        return this;
    }

    public LogInAndRegisterPage goToRemindPasswordPage() {
        wait.waitForElementToBeVisible(driver, remindPassword);
        remindPassword.click();
        return this;
    }

    public LogInAndRegisterPage logIn() {
        wait.waitForElementToBeVisible(driver, logInButton);
        logInButton.click();
        return this;
    }

    public LogInAndRegisterPage resetPassword() {
        wait.waitForElementToBeVisible(driver, resetPassword);
        resetPassword.click();
        return this;
    }

    public LogInAndRegisterPage goBackToLogInPage() {
        wait.waitForElementToBeVisible(driver, goBackButton);
        goBackButton.click();
        return this;
    }
    public LogInAndRegisterPage logoFrisco(){
        wait.waitForElementToBeVisible(driver, logo);
        logo.click();
        return this;
    }
    public LogInAndRegisterPage regulations(){
        wait.waitForElementToBeVisible(driver, regulationsLink);
        regulationsLink.click();
        return this;
    }

}
