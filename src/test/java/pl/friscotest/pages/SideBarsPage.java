package pl.friscotest.pages;

import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pl.friscotest.utils.SeleniumHelper;

import java.util.List;

public class SideBarsPage {

    @FindBy(xpath = "//ubdiv[@class='userback-button userback-button-e' and text()='Zgłoś uwagę']")
    private WebElement fileReport;
    @FindBy(xpath = "//div[@class='FTChat_custom_bar FTChat_bar r']")
    private WebElement chat;
    @FindBy(xpath = "//ubroutemenu[@class='userback-feedback-type-draw']")
    private WebElement fileReportPointScreen;
    @FindBy(xpath = "//ubroutemenu[@class='userback-feedback-type-form']")
    private WebElement fileReportNotPointScreen;
    @FindBy(xpath = "//ubroutemenu[@class='userback-feedback-type-help']")
    private WebElement fileReportForm;
    @FindBy(xpath = "//div[@class='userback-controls userback-controls-e']/uclose[@class='userback-controls-close']")
    private WebElement getFileReportClose;
    @FindBy(xpath = "//input[@class='FTChat_start_button']")
    private WebElement startChat;
    @FindBy(xpath = "//span[@class='c' and @title='Przerwij chat' and text()='Zamknij chat']")
    private WebElement exitChat;
    @FindBy(xpath = "//div[@class='FTChat_custom_bar FTChat_header']/i[@class='m'and @title='Minimalizuj okno']")
    private WebElement hideChat;
    @FindBy(xpath = "//uclose[@class='userback-controls-close' and @title='Zamknij']")
    private WebElement exitFileReport;
    @FindBy(xpath = "//div[@class='FTChat_container FTChat_poll']/form[@method='FTChat_post']/fieldset/label")
    private List<WebElement> chatBoxList;


    private WebDriver driver;
    SeleniumHelper wait = new SeleniumHelper();
    MainShopPage mainShopPage;
    Actions actions;

    public SideBarsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        mainShopPage = new MainShopPage(driver);
        actions = new Actions(driver);
    }

    public void fileReportSidebar() {
        wait.waitForElementToBeVisible(driver, fileReport);
        fileReport.click();
    }

    public void setFileReportPointScreen() {
        wait.waitForElementToBeVisible(driver, fileReportPointScreen);
        fileReportPointScreen.click();
    }

    public void setFileReportNotPointScreen() {
        wait.waitForElementToBeVisible(driver, fileReportNotPointScreen);
        fileReportNotPointScreen.click();
    }

    public void setFileReportForm() {
        wait.waitForElementToBeVisible(driver, fileReportForm);
        fileReportForm.click();
    }

    public void customerHelpSideBar() {
        wait.waitForElementToBeVisible(driver, chat);
        chat.click();
    }

    public void setExitFileReport() {
        wait.waitForElementToBeVisible(driver, exitFileReport);
        exitFileReport.click();
    }

    public void clickOnChatBoxOptions() {
        wait.waitForElementToBeVisible(driver, chat);
        Assert.assertTrue(CollectionUtils.isNotEmpty(chatBoxList));
        chatBoxList.forEach(option -> {
            wait.waitForElementToBeVisible(driver, option);
            option.click();
            Assert.assertTrue(option.isEnabled());
        });
    }

    public void chatStart() {
        wait.waitForElementToBeVisible(driver, chat);
        startChat.click();
    }

    public void chatExit() {
        wait.waitForElementToBeVisible(driver, chat);
        exitChat.click();
    }
    public void chatHide(){
        wait.waitForElementToBeVisible(driver,chat);
        hideChat.click();
    }
//    public SideBarsPage asd() throws InterruptedException {
//        // wait.waitForElementToExist(driver, By.xpath(EXPAND_BOTTOM_BAR));
//        int timeout = 5;
//        while (timeout != 0 ) {
//            try {
//                if (chat.isDisplayed()) {
//                    break;
//                }
//            } catch (NoSuchElementException e) {
//                driver.navigate().refresh();
//                Thread.sleep(5000);
//                timeout--;
//            }
//        }
//        chat.click();
//        return this;
//    }
}
