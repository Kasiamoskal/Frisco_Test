package pl.friscotest.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.friscotest.pages.AlertsPage;
import pl.friscotest.pages.MainShopPage;
import pl.friscotest.pages.PaymentMethodsPage;
import pl.friscotest.utils.BaseTest;

public class PaymentMethodsTest extends BaseTest {

    MainShopPage mainShopPage;
    AlertsPage alert;
    PaymentMethodsPage paymentMethods;

    @BeforeMethod
    public void registerSetup() {
        mainShopPage = new MainShopPage(driver);
        alert = new AlertsPage(driver);
        paymentMethods = new PaymentMethodsPage(driver);
    }


    @Test
    public void paymentHeadingTextTest() {
        mainShopPage.acceptCookiesButton()
                .kebabMenuExpand()
                .paymentMethodsInfo();
        paymentMethods.titleCheck();
    }

    @Test
    public void  paymentInfoPageHelpLink(){
        mainShopPage.acceptCookiesButton()
                .kebabMenuExpand()
                .paymentMethodsInfo();
        paymentMethods.helpButton();
    }
}
