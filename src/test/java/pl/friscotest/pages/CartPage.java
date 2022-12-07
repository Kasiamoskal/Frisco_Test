package pl.friscotest.pages;

import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pl.friscotest.utils.SeleniumHelper;

import java.util.List;

import static pl.friscotest.utils.XPathPagesConstants.CartPageXPaths.*;

public class CartPage {

    @FindBy(xpath = "//a[@class='change-list-view-mode_button button secondary']")
    private WebElement changeLayout;
    @FindBy(xpath = "//div[@class='chooser-wrapper_list active']")
    private WebElement listLayout;
    @FindBy(xpath = "//div[@class='chooser-wrapper_grid']")
    private WebElement gridLayout;
    @FindBy(xpath = "//a[@class='button non-click button higher primary alone']")
    private WebElement fileOrder;
    @FindBy(xpath = RECOMMENDED_PRODUCTS_XPATH)
    private List<WebElement> recommendedProducts;
    @FindBy(xpath = ADD_PRODUCTS_XPATH)
    private List<WebElement> addProduct;
    @FindBy(xpath = SUBTRACT_PRODUCT_XPATH)
    private List<WebElement> subtractProduct;
    @FindBy(xpath = REMOVE_PRODUCTS_XPATH)
    private List<WebElement> removeProduct;
    @FindBy(xpath = UNDO_CHANGES_XPATH)
    private WebElement undoChangesPopUp;
    @FindBy(xpath = CLOSE_POPUP_XPATH)
    private WebElement closeChangesPopUp;
    @FindBy(xpath = SAVING_CHEVRON_XPATH)
    private WebElement savingCountChevron;
    @FindBy(xpath = "//div[@class='message-box_close']")
    private WebElement infoMessage;

    SeleniumHelper wait = new SeleniumHelper();
    MainShopPage mainShopPage;
    Actions actions;
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        mainShopPage = new MainShopPage(driver);
        actions = new Actions(driver);

    }

    public CartPage goToFullCart() {
        mainShopPage.acceptCookiesButton();
        mainShopPage.sideCartBar();
        mainShopPage.sideCartFullView();
        return this;
    }

    public CartPage addProductToCart() {
        wait.waitForElementToBeClickable(driver, By.xpath(RECOMMENDED_PRODUCTS_XPATH));
        Assert.assertTrue(CollectionUtils.isNotEmpty(recommendedProducts));
        Assert.assertTrue(recommendedProducts.size() > 2);
        wait.click(recommendedProducts.get(0));
        wait.click(recommendedProducts.get(0));
        return this;
    }

    public CartPage adjustProducts() {
        addProduct.forEach(product -> wait.click(product));
        return this;
    }

    public CartPage deductProduct() {
        subtractProduct.forEach(product -> wait.click(product));
        return this;
    }

    public CartPage removeProducts() {
        wait.waitForElementToBeClickable(driver, By.xpath(REMOVE_PRODUCTS_XPATH));
        Assert.assertTrue(CollectionUtils.isNotEmpty(removeProduct));
        Assert.assertTrue(removeProduct.size() > 1);
        wait.click(removeProduct.get(0));
        return this;
    }

    public CartPage undoChanges() {
        wait.waitForElementToExist(driver, By.xpath(UNDO_CHANGES_XPATH));
        undoChangesPopUp.click();
        return this;
    }

    public CartPage closeChanges() {
        wait.waitForElementToExist(driver, By.xpath(CLOSE_POPUP_XPATH));
        closeChangesPopUp.click();
        return this;
    }

    public CartPage countChevronExpand() {
        wait.waitForElementToExist(driver, By.xpath(SAVING_CHEVRON_XPATH));
        savingCountChevron.click();
        return this;
    }

    public CartPage changeLayoutButton() {
        wait.waitForElementToBeVisible(driver, changeLayout);
        changeLayout.click();
        return this;
    }

    public CartPage changeToListLayout() {
        wait.waitForElementToBeVisible(driver, listLayout);
        listLayout.click();
        return this;
    }

    public CartPage changeToGridLayout() {
        wait.waitForElementToBeVisible(driver, gridLayout);
        gridLayout.click();
        return this;
    }

    public CartPage fileOrderButton() {
        wait.waitForElementToBeVisible(driver, fileOrder);
        fileOrder.click();
        return this;
    }

    public CartPage cartInfoClose() {
        wait.waitForElementToBeVisible(driver, infoMessage);
        infoMessage.click();
        return this;
    }

    public CartPage cartInfoNotDisplay() {
        try {
            Assert.assertFalse(infoMessage.isDisplayed());

        } catch (NoSuchElementException e) {
            System.out.println("Informacja nie wyświetliła się");
        }
        return this;
    }
}
