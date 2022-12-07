package pl.friscotest.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.friscotest.pages.MainShopPage;
import pl.friscotest.utils.BaseTest;

public class MainShopTest extends BaseTest {


    MainShopPage mainShopPage;

    @BeforeMethod
    public void registerSetup() {
        mainShopPage = new MainShopPage(driver);
    }

    @Test
    public void categoriesTest() {

        mainShopPage.acceptCookiesButton()
        .shopCatButton()
        .freshSubCatHover()
        .fruitsAndVeggiesSubCat()
        .fruitsSubCategory();

    }
}
