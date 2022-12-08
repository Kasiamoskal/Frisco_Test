package pl.friscotest.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
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
        ExtentTest test = extentReports.createTest("Add Recommended Products Test");
        mainShopPage.acceptCookiesButton()
                .sideCartBar()
                .addRecommendedProducts();
        test.log(Status.PASS,"Added recommended products on the Cart bar");
    }

    @Test
    public void sideCartInfoClose() {
        ExtentTest test = extentReports.createTest("Info Side Cart Test");
        mainShopPage.acceptCookiesButton()
                .sideCartBar()
                .sideCartInfoClose();
        test.log(Status.PASS,"Closed side info");
        driver.navigate().refresh();
        mainShopPage.sideCartBar()
                .sideCartInfoNotDisplay();
        test.log(Status.PASS,"Page refreshed successfully and the info is not displayed");
    }

    @Test
    public void clearSideCart() {
        ExtentTest test = extentReports.createTest("Clear Side Cart Test");
        mainShopPage.acceptCookiesButton()
                .sideCartBar()
                .addRecommendedProducts()
                .clearSideCart()
                .sideCartClearPopUp();
        test.log(Status.PASS,"The Cart bar cleared");
    }
    @Test
    public void annulPopUpSideCart() {
        ExtentTest test = extentReports.createTest("Annul PopUp Side Cart Test");
        mainShopPage.acceptCookiesButton()
                .sideCartBar()
                .addRecommendedProducts()
                .clearSideCart()
                .sideCartAnnulPopUp();
        test.log(Status.PASS,"Products weren't deprecated from the Cart Test");
    }

    @Test
    public void closingPopUpSideCart() {
        ExtentTest test = extentReports.createTest("Closing PopUp In Side Cart Test");
        mainShopPage.acceptCookiesButton()
                .sideCartBar()
                .addRecommendedProducts()
                .clearSideCart()
                .sideCartCrossPopUp();
        test.log(Status.PASS,"Products weren't deprecated from the Cart Test");
    }

    @Test
    public void fullViewSideCart() {
        ExtentTest test = extentReports.createTest("Side Cart Full View Test");
        mainShopPage.acceptCookiesButton()
                .sideCartBar()
                .addRecommendedProducts()
                .sideCartFullView();
        test.log(Status.PASS,"Successfully opened the full Cart view");
    }

    @Test
    public void fileOrderSideCart() {
        ExtentTest test = extentReports.createTest("File Order In Side Cart Test");
        mainShopPage.acceptCookiesButton()
                .sideCartBar()
                .addRecommendedProducts()
                .sideCartFileOrder();
        test.log(Status.PASS,"Products weren't deprecated from the Cart");
    }

    @Test
    public void sideCartChevron() {
        ExtentTest test = extentReports.createTest("Saving Count Chevron Side Cart Test");
        mainShopPage.acceptCookiesButton()
                .sideCartBar()
                .addRecommendedProducts()
                .chevronExpand();
        test.log(Status.PASS,"Promo info was expanded");
    }

    @Test
    public void promoCount() {
        ExtentTest test = extentReports.createTest("Promo Count Test");
        mainShopPage.acceptCookiesButton()
                .sideCartBar()
                .addRecommendedProducts();
        WebElement error = alerts.getSavingCounterTitle();
        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getText(), "Oszczędzam przy tym zamówieniu");
        test.log(Status.PASS,"Promo info is properly displayed");
    }

    @Test
    public void fullCartAddProducts() {
        ExtentTest test = extentReports.createTest("Add Product To Full Cart Test");
        cartPage.goToFullCart()
                .addProductToCart();
        test.log(Status.PASS,"Products were successfully added to Cart");
    }

    @Test
    public void addProductToFullCart() {
        ExtentTest test = extentReports.createTest("Add Product Test");
        cartPage.goToFullCart()
                .addProductToCart()
                .adjustProducts();
        test.log(Status.PASS,"Products weren't deprecated from the Cart");
    }

    @Test
    public void subtractProductFromFullCart() {
        ExtentTest test = extentReports.createTest("Subtract Product Test");
        cartPage.goToFullCart()
                .addProductToCart()
                .adjustProducts()
                .deductProduct();
        test.log(Status.PASS,"Products were successfully added and deprecated from the Cart");
    }

    @Test
    public void removeProductFromCart() {
        ExtentTest test = extentReports.createTest("Remove Product From Cart Test");
        cartPage.goToFullCart()
                .addProductToCart()
                .removeProducts();
        test.log(Status.PASS,"Products were deprecated from the Cart");
    }

    @Test
    public void undoChangesPopUp() {
        ExtentTest test = extentReports.createTest("Undo Changes In Cart Test");
        cartPage.goToFullCart()
                .addProductToCart()
                .removeProducts()
                .undoChanges();
        test.log(Status.PASS,"Pop up displayed and can be interacted with");
    }

    @Test
    public void exitChangesPopUp() {
        ExtentTest test = extentReports.createTest("Exit Changes In Cart Test");
        cartPage.goToFullCart()
                .addProductToCart()
                .removeProducts()
                .closeChanges();
        test.log(Status.PASS,"Pop up displayed and can be interacted with");
    }

    @Test
    public void expandSavingCountChevron() {
        ExtentTest test = extentReports.createTest("Saving Count Chevron Test");
        cartPage.goToFullCart()
                .addProductToCart()
                .countChevronExpand();
        test.log(Status.PASS,"Promo info is displayed");
    }

    @Test
    public void changeLayoutToList() {
        ExtentTest test = extentReports.createTest("Change Layout To List Test");
        cartPage.goToFullCart()
                .changeLayoutButton()
                .changeToListLayout();
        test.log(Status.PASS,"Layout can be successfully changed to List");
    }

    @Test
    public void changeLayoutToGrind() {
        ExtentTest test = extentReports.createTest("Change Layout To Grind Test");
        cartPage.goToFullCart()
                .changeLayoutButton()
                .changeToGridLayout();
        test.log(Status.PASS,"Layout can be successfully changed to Grind");
    }

    @Test
    public void fileOrder() {
        ExtentTest test = extentReports.createTest("File Order Test");
        cartPage.goToFullCart()
                .addProductToCart()
                .fileOrderButton();
        test.log(Status.PASS,"The order was successfully filed");
    }

    @Test
    public void cartInfoClose() {
        ExtentTest test = extentReports.createTest("Closing The Promo Info Test");
        cartPage.goToFullCart()
                .cartInfoClose();
        driver.navigate().refresh();
        cartPage.cartInfoNotDisplay();
        test.log(Status.PASS,"Cart info is not displayed after refreshing the page");
    }
}