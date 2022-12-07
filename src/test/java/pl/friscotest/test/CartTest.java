package pl.friscotest.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.friscotest.pages.AlertsPage;
import pl.friscotest.pages.CartPage;
import pl.friscotest.pages.MainShopPage;
import pl.friscotest.utils.BaseTest;

public class CartTest extends BaseTest {

    MainShopPage mainShopPage;
    CartPage cartPage;
    AlertsPage alerts;


    @BeforeMethod
    public void registerSetup() {
        mainShopPage = new MainShopPage(driver);
        cartPage = new CartPage(driver);
        alerts = new AlertsPage(driver);
    }

    @Test
    public void addRecommendedProducts() {
        mainShopPage.acceptCookiesButton()
                .sideCartBar()
                .addRecommendedProducts();
    }

    @Test
    public void sideCartInfoClose() {
        mainShopPage.acceptCookiesButton()
                .sideCartBar()
                .sideCartInfoClose();
        driver.navigate().refresh();
        mainShopPage.sideCartBar()
                .sideCartInfoNotDisplay();
    }

    @Test
    public void clearSideCart() {
        mainShopPage.acceptCookiesButton()
                .sideCartBar()
                .addRecommendedProducts()
                .clearSideCart()
                .sideCartClearPopUp();
    }

    @Test
    public void annulPopUpSideCart() {
        mainShopPage.acceptCookiesButton()
                .sideCartBar()
                .addRecommendedProducts()
                .clearSideCart()
                .sideCartAnnulPopUp();
    }

    @Test
    public void closingPopUpSideCart() {
        mainShopPage.acceptCookiesButton()
                .sideCartBar()
                .addRecommendedProducts()
                .clearSideCart()
                .sideCartCrossPopUp();
    }

    @Test
    public void fullViewSideCart() {
        mainShopPage.acceptCookiesButton()
                .sideCartBar()
                .addRecommendedProducts()
                .sideCartFullView();

    }

    @Test
    public void fileOrderSideCart() {
        mainShopPage.acceptCookiesButton()
                .sideCartBar()
                .addRecommendedProducts()
                .sideCartFileOrder();

    }

    @Test
    public void sideCartChevron() {
        mainShopPage.acceptCookiesButton()
                .sideCartBar()
                .addRecommendedProducts()
                .chevronExpand();
    }

    @Test
    public void promoCount() {
        mainShopPage.acceptCookiesButton()
                .sideCartBar()
                .addRecommendedProducts();
        WebElement error = alerts.getSavingCounterTitle();
        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getText(), "Oszczędzam przy tym zamówieniu");
    }

    @Test
    public void fullCartAddProducts() {
        cartPage.goToFullCart()
                .addProductToCart();
    }

    @Test
    public void addProductToFullCart() {
        cartPage.goToFullCart()
                .addProductToCart()
                .adjustProducts();
    }

    @Test
    public void subtractProductFromFullCart() {
        cartPage.goToFullCart()
                .addProductToCart()
                .adjustProducts()
                .deductProduct();
    }

    @Test
    public void removeProductFromCart() {
        cartPage.goToFullCart()
                .addProductToCart()
                .removeProducts();
    }

    @Test
    public void undoChangesPopUp() {
        cartPage.goToFullCart()
                .addProductToCart()
                .removeProducts()
                .undoChanges();
    }

    @Test
    public void exitChangesPopUp() {
        cartPage.goToFullCart()
                .addProductToCart()
                .removeProducts()
                .closeChanges();
    }

    @Test
    public void expandSavingCountChevron() {
        cartPage.goToFullCart()
                .addProductToCart()
                .countChevronExpand();
    }

    @Test
    public void changeLayoutToList() {
        cartPage.goToFullCart()
                .changeLayoutButton()
                .changeToListLayout();
    }

    @Test
    public void changeLayoutToGrind() {
        cartPage.goToFullCart()
                .changeLayoutButton()
                .changeToGridLayout();
    }

    @Test
    public void fileOrder() {
        cartPage.goToFullCart()
                .addProductToCart()
                .fileOrderButton();
    }

    @Test
    public void cartInfoClose() {
        cartPage.goToFullCart()
                .cartInfoClose();
        driver.navigate().refresh();
        cartPage.cartInfoNotDisplay();
    }
}