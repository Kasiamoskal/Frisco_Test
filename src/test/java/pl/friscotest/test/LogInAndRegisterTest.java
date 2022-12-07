package pl.friscotest.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.friscotest.pages.AlertsPage;
import pl.friscotest.pages.CartPage;
import pl.friscotest.pages.LogInAndRegisterPage;
import pl.friscotest.pages.MainShopPage;
import pl.friscotest.utils.BaseTest;

import java.util.function.Consumer;

public class LogInAndRegisterTest extends BaseTest {

    MainShopPage mainShopPage;
    LogInAndRegisterPage logInAndRegisterPage;
    AlertsPage alerts;


    @BeforeMethod
    public void registerSetup() {
        mainShopPage = new MainShopPage(driver);
        logInAndRegisterPage = new LogInAndRegisterPage(driver);
        alerts = new AlertsPage(driver);
    }

    @Test
    public void createAccount() {
        logInAndRegisterPage.goToRegisterPage()
                .setName("Maria")
                .setSurname("Test")
                .setPhoneNumber("111111111")
                .setEmailAddress("haniatest01@wp.pl")
                .setPassword("Tescik111!")
                .setPostcode("05520")
                .allConsentsCheckbox()
                .createAccount();
    }

    @Test
    public void logIn() {
        logInAndRegisterPage.goToLogInPage()
                .setEmailAddress("hania02test@outlook.com")
                .setPassword("Tescik111!")
                .logIn();
    }

    @Test
    public void goToLogInPageFromRegistration() {
        logInAndRegisterPage.goToRegisterPage()
                .goToLogInFromRegisterPage();
    }

    @Test
    public void goToLogInPageFromRegistrationAndLogIn() {
        logInAndRegisterPage.goToRegisterPage()
                .goToLogInFromRegisterPage()
                .setEmailAddress("hania02test@outlook.com")
                .setPassword("Tescik111!")
                .logIn();
    }

    @Test
    public void goToRegistrationPageFromLogIn() {
        logInAndRegisterPage.goToLogInPage()
                .goToRegisterPageFromLogIn();
    }

    @Test
    public void goToRegistrationPageFromLogInAndCreateAccount() {
        logInAndRegisterPage.goToLogInPage()
                .goToRegisterPageFromLogIn()
                .setName("Maria")
                .setSurname("Test")
                .setPhoneNumber("111111111")
                .setEmailAddress("haniatest01@wp.pl")
                .setPassword("Tescik111!")
                .setPostcode("05520")
                .allConsentsCheckbox()
                .createAccount();
    }

    @Test
    public void passwordEyeIcon() {
        logInAndRegisterPage.goToLogInPage()
                .eyeIconButton("Tescik");
    }

    @Test
    public void remindPassword() {
        logInAndRegisterPage.goToLogInPage()
                .goToRemindPasswordPage()
                .setEmailAddress("hania02test@outlook.com")
                .resetPassword();
    }

    @Test
    public void remindPasswordAlert() {
        logInAndRegisterPage.goToLogInPage()
                .goToRemindPasswordPage()
                .resetPassword();
        WebElement error = alerts.getGiveEmailAddressOnRemindPasswordPage();
        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getText(), "Podaj adres e-mail");
    }

    @Test
    public void returnFromRemindPasswordPage() {
        logInAndRegisterPage.goToLogInPage()
                .goToRemindPasswordPage()
                .goBackToLogInPage();

    }

    @Test
    public void eyeIconRegistrationPage() {
        logInAndRegisterPage.goToRegisterPage()
                .eyeIconButton("Tescik");
    }
    @Test
    public void regulationsLink() {
        logInAndRegisterPage.goToRegisterPage()
                .regulations();
}
    @Test
    public void logoOnRegistrationPage() {
        logInAndRegisterPage.goToRegisterPage()
                .logoFrisco();
    }
    @Test
    public void bottomBarOnRegistrationPage() {
        logInAndRegisterPage.goToRegisterPage()
                .bottomBarExpand()
                .bottomBarMessage("Hello")
                .proceedBottomBar();
        //bottom bar czasem się pojawia, a czasem nie, jak side bary
    }
    @Test
    public void allCheckboxesOnRegistrationPage() {
        logInAndRegisterPage.goToRegisterPage()
                .acceptRulesCheckbox()
                .newsletterCheckbox()
                .promoConsentCheckbox()
                .mailNewsletterCheckbox();

    }

    }
