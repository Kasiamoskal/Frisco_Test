package pl.friscotest.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.friscotest.pages.MainShopPage;
import pl.friscotest.pages.SideBarsPage;
import pl.friscotest.utils.BaseTest;

public class SideBarTest extends BaseTest {

    SideBarsPage sideBarsPage;
    MainShopPage mainShopPage;

    @BeforeMethod
    public void registerSetup() {
        mainShopPage = new MainShopPage(driver);
        sideBarsPage = new SideBarsPage(driver);
    }

    @Test(enabled = false)
    public void chatSideBarTest() {
        mainShopPage.acceptCookiesButton();
        sideBarsPage.customerHelpSideBar();
    }

    @Test(enabled = false)
    public void chatStart() {
        mainShopPage.acceptCookiesButton();
        sideBarsPage.customerHelpSideBar();
        sideBarsPage.chatStart();
    }

    @Test(enabled = false)
    public void chatClose() {
        mainShopPage.acceptCookiesButton();
        sideBarsPage.customerHelpSideBar();
        sideBarsPage.chatExit();
    }

    @Test(enabled = false)
    public void chatHide() {
        mainShopPage.acceptCookiesButton();
        sideBarsPage.customerHelpSideBar();
        sideBarsPage.chatHide();
    }

    @Test(enabled = false)
    public void clickOnEachChatOption() {
        mainShopPage.acceptCookiesButton();
        sideBarsPage.customerHelpSideBar();
        sideBarsPage.clickOnChatBoxOptions();
    }

    @Test(enabled = false)
    public void fileReportSideBarTest() {
        mainShopPage.acceptCookiesButton();
        sideBarsPage.fileReportSidebar();
    }

    @Test(enabled = false)
    public void fileReportPointOnScreen() {
        mainShopPage.acceptCookiesButton();
        sideBarsPage.fileReportSidebar();
        sideBarsPage.setFileReportPointScreen();
    }

    @Test(enabled = false)
    public void fileReportNotPointOnScreen() {
        mainShopPage.acceptCookiesButton();
        sideBarsPage.fileReportSidebar();
        sideBarsPage.setFileReportNotPointScreen();

    }

    @Test(enabled = false)
    public void fileReportFileComplain() {
        mainShopPage.acceptCookiesButton();
        sideBarsPage.fileReportSidebar();
        sideBarsPage.setFileReportForm();
    }

    @Test(enabled = false)
    public void fileReportBarClose() {
        mainShopPage.acceptCookiesButton();
        sideBarsPage.fileReportSidebar();
        sideBarsPage.setExitFileReport();

    }

}
