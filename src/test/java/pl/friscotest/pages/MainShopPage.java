package pl.friscotest.pages;

import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pl.friscotest.utils.SeleniumHelper;


import java.util.List;

import static pl.friscotest.utils.XPathPagesConstants.MainShopPageXPaths.*;

public class MainShopPage {

    @FindBy(xpath = "//button[contains(text(),'Akceptuję')]")
    private WebElement acceptCookies;
    @FindBy(xpath = "//span[contains(text(),'Kategorie sklepu')]")
    private WebElement shopCategories;
    @FindBy(xpath = FRESH_SUBCAT_HOVER_XPATH)
    private WebElement freshSubCat;
    @FindBy(xpath = "//a[contains(text(),'Warzywa i owoce')]")
    private WebElement fruitsAndVegetablesSubCat;
    @FindBy(xpath = "//a[contains(text(),'Owoce')]")
    private WebElement fruitsSubCat;
    @FindBy(xpath = "//parent::div[not(@style)]/a [@href='/stn,dostawa'and @class='no-icon button secondary']")
    private WebElement deliveryInfo;
    @FindBy(xpath = "//div [contains (@class,'button more')]")
    private WebElement kebabMenu;
    @FindBy(xpath = "//parent::div[not(@style)]/a [@href='/stn,metody-platnosci'and @class='no-icon button secondary']")
    private WebElement paymentMethodsPage;
    @FindBy(xpath = "//div[@class='header-cart header-box']")
    private WebElement sideCart;
    @FindBy(xpath = CLEAR_SIDE_CART_XPATH)
    private WebElement sideCartClear;
    @FindBy(xpath = "//a[@class='cart-side-box_actions_full-view']")
    private WebElement sideCartFull;
    @FindBy(xpath = "//a[@class='button primary large alone']")
    private WebElement sideCartOrder;
    @FindBy(xpath = "//div[@class='icon-comp Close']")
    private WebElement sideCartInfo;
    @FindBy(xpath = ADD_RECOMMENDED_PRODUCTS_XPATH)
    private List<WebElement> recommendProductsList;
    @FindBy(xpath = "//a[@class='button cta']")
    private WebElement sideCartPopUpClear;
    @FindBy(xpath = "//a[@class='button secondary']")
    private WebElement sideCartPopUpAnnul;
    @FindBy(xpath = "//a[@class='cross']")
    private WebElement sideCartPopUpCross;
    @FindBy(xpath = CHEVRON_EXPAND_XPATH)
    private WebElement savingCounterChevron;
    @FindBy(xpath = "//button[@class='button cta' and text()='Zaloguj się']")
    private WebElement logInButton;
    @FindBy(xpath = "//button[@class='button cta' and text()='Załóż konto']")
    private WebElement registerButton;


    private WebDriver driver;
    SeleniumHelper wait = new SeleniumHelper();
    Actions actions;

    public MainShopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        actions = new Actions(driver);
    }

    public MainShopPage acceptCookiesButton() {
        wait.waitForElementToBeVisible(driver, acceptCookies);
        acceptCookies.click();
        return this;
    }

    public MainShopPage shopCatButton() {
        shopCategories.click();
        return this;
    }

    public MainShopPage freshSubCatHover() {
        wait.waitForElementToExist(driver, By.xpath(FRESH_SUBCAT_HOVER_XPATH));
        actions.moveToElement(freshSubCat).perform();
        return this;
    }

    public MainShopPage fruitsAndVeggiesSubCat() {
        wait.waitForElementToBeVisible(driver, fruitsAndVegetablesSubCat);
        actions.moveToElement(fruitsAndVegetablesSubCat).perform();
        return this;
    }

    public MainShopPage fruitsSubCategory() {
        wait.waitForElementToBeVisible(driver, fruitsSubCat);
        actions.moveToElement(fruitsSubCat).perform();
        actions.click().build().perform();
        return this;
    }

    public MainShopPage kebabMenuExpand() {
        kebabMenu.click();
        return this;
    }

    public MainShopPage deliveryInfoButton() {
        wait.waitForElementToBeVisible(driver, deliveryInfo);
        deliveryInfo.click();
        return this;
    }

    public MainShopPage paymentMethodsInfo() {
        wait.waitForElementToBeVisible(driver, paymentMethodsPage);
        paymentMethodsPage.click();
        return this;
    }

    public MainShopPage sideCartBar() {
        wait.waitForElementToBeVisible(driver, sideCart);
        sideCart.click();
        return this;
    }

    public MainShopPage sideCartInfoClose() {
        wait.waitForElementToBeVisible(driver, sideCartInfo);
        sideCartInfo.click();
        return this;
    }

    public MainShopPage sideCartInfoNotDisplay() {
        try {
            Assert.assertFalse(sideCartInfo.isDisplayed());

        } catch (NoSuchElementException e) {
            System.out.println("Informacja nie wyświetliła się");
        }
        return this;
    }

    public MainShopPage addRecommendedProducts() {
        wait.waitForElementToBeClickable(driver, By.xpath(ADD_RECOMMENDED_PRODUCTS_XPATH));
        Assert.assertTrue(CollectionUtils.isNotEmpty(recommendProductsList));
        Assert.assertTrue(recommendProductsList.size() > 2);
        wait.scrollAndClick(recommendProductsList.get(0));
        wait.scrollAndClick(recommendProductsList.get(0));
        wait.scrollAndClick(recommendProductsList.get(0));
        return this;
    }

    public MainShopPage clearSideCart() {
        wait.waitForElementToExist(driver, By.xpath(CLEAR_SIDE_CART_XPATH));
        sideCartClear.click();
        return this;
    }

    public MainShopPage sideCartFullView() {
        wait.waitForElementToBeVisible(driver, sideCartFull);
        sideCartFull.click();
        return this;
    }

    public MainShopPage sideCartFileOrder() {
        wait.waitForElementToBeVisible(driver, sideCartOrder);
        sideCartOrder.click();
        return this;
    }

    public MainShopPage sideCartClearPopUp() {
        wait.waitForElementToBeVisible(driver, sideCartPopUpClear);
        sideCartPopUpClear.click();
        return this;
    }

    public MainShopPage sideCartAnnulPopUp() {
        wait.waitForElementToBeVisible(driver, sideCartPopUpAnnul);
        sideCartPopUpAnnul.click();
        return this;
    }

    public MainShopPage sideCartCrossPopUp() {
        wait.waitForElementToBeVisible(driver, sideCartPopUpCross);
        sideCartPopUpCross.click();
        return this;
    }
//    public MainShopPage altClearSideCart(){
//        try{
//            clearSideCart();
//        }catch(StaleElementReferenceException e){
//            clearSideCart();
//        }
//        return this;
//    }

    public MainShopPage chevronExpand() {
        wait.waitForElementToBeClickable(driver, By.xpath(CHEVRON_EXPAND_XPATH));
        actions.doubleClick(savingCounterChevron);
        return this;
    }

    public MainShopPage goToLogInPage() {
        wait.waitForElementToBeVisible(driver, logInButton);
        logInButton.click();
        return this;
    }

    public MainShopPage goToRegisterPage() {
        wait.waitForElementToBeVisible(driver, registerButton);
        registerButton.click();
        return this;
    }
}



