package pl.friscotest.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.friscotest.pages.AlertsPage;
import pl.friscotest.pages.DeliveryInfoPage;
import pl.friscotest.pages.MainShopPage;
import pl.friscotest.utils.BaseTest;

public class DeliveryInfoTest extends BaseTest {

    MainShopPage mainShopPage;
    AlertsPage alert;
    DeliveryInfoPage deliverInfo;

    @BeforeMethod
    public void registerSetup() {
        mainShopPage = new MainShopPage(driver);
        alert = new AlertsPage(driver);
        deliverInfo = new DeliveryInfoPage(driver);
    }

    @Test
    public void incorrectPostcodeTest() {

        mainShopPage.acceptCookiesButton()
                .kebabMenuExpand()
                .deliveryInfoButton();
        deliverInfo.setIncorrectPostcode("111111");
        WebElement error = alert.getIncorrectPostcodeAlert();
        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getText(), "Podany przez Ciebie kod pocztowy nie znajduje się w obszarze dostaw Frisco VANem. Zamówienie Będzie dostarczone za pośrednictwem firmy kurierskiej.");
    }

    @Test
    public void correctPostcodeTest() {
        mainShopPage.acceptCookiesButton()
                .kebabMenuExpand()
                .deliveryInfoButton();
        deliverInfo.setCorrectPostcode("05520");
        WebElement error = alert.getCorrectPostcodeAlert();
        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getText(), "Podany przez Ciebie kod pocztowy znajduje się w obszarze dostaw Frisco VANem.");
    }

    @Test
    public void deliverMapTest() {
        mainShopPage.acceptCookiesButton()
                .kebabMenuExpand()
                .deliveryInfoButton();
        deliverInfo.setEnlargeMap();
        deliverInfo.setDecreaseMap();
    }

    @Test
    public void newsletterSignUpTest() {
        mainShopPage.acceptCookiesButton();
        mainShopPage.kebabMenuExpand();
        mainShopPage.deliveryInfoButton();
        deliverInfo.newsletterSignIn();
    }

    @Test
    public void deliverCityTest() {
        mainShopPage.acceptCookiesButton();
        mainShopPage.kebabMenuExpand();
        mainShopPage.deliveryInfoButton();
        deliverInfo.selectCity();
        deliverInfo.selectAnotherCity();
    }
}
