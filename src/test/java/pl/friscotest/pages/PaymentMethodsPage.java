package pl.friscotest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.friscotest.utils.SeleniumHelper;

public class PaymentMethodsPage {

    @FindBy(xpath = "//h1[contains(@class,'breadcrumbs_title')]")
    private WebElement title;

    @FindBy(xpath = "//p[@class='adnotation']/a [@href='/stn,pomoc' and contains(text(),'Pomoc')]")
    private WebElement helpLink;

    private WebDriver driver;
    SeleniumHelper wait = new SeleniumHelper();
    MainShopPage mainShopPage;


    public PaymentMethodsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        mainShopPage = new MainShopPage(driver);
    }

    public void titleCheck() {
        wait.waitForElementToBeVisible(driver, title);
        String titleEquals = "Metody płatności";
        String titleActual = title.getText();
        if(titleEquals.equals(titleActual)){
            System.out.println("Tekst się zgadza");
        }else
            System.out.println("Tekst jest błędny");
    }

    public void helpButton(){
wait.waitForElementToBeVisible(driver, helpLink);
helpLink.click();
    }
}
