package tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BrainMainPage;

import static data.BrainConstants.BASE_URL;

public class BrainPool extends BaseTest {

    @BeforeMethod
    public void openSite() {
        setUp().get(BASE_URL);
    }

    @AfterMethod
    public void driverDestroy() {
        tearDown();
    }

    @Description("Positive log-in into Brain")
    @Test
    @TmsLink("1")
    public void positiveLogIn() {
        String userName = "Maksym";
        BrainMainPage brainMainPage = new BrainMainPage(driver);

        brainMainPage.clickLogIn();
        brainMainPage.putLogin();
        brainMainPage.putPassword();
        brainMainPage.clickOnSubmitButton();
        brainMainPage.checkUserName(userName);
    }

    @Description("Negative log-in into Brain with a wrong phone number) ")
    @Test
    @TmsLink("2")
    public void negativeLogInWithWrongPassword() {
        String errorMessage = "Некоректний телефон";
        BrainMainPage brainMainPage = new BrainMainPage(driver);

        brainMainPage.clickLogIn();
        brainMainPage.putWrongLogin();
        brainMainPage.putPassword();
        brainMainPage.clickOnSubmitButton();
        brainMainPage.checkWrongAccountMessage(errorMessage);
    }

    @Description("Negative log-in into Brain with a wrong password) ")
    @Test
    @TmsLink("3")
    public void negativeLogInWithWrongLogIn() {
        String errorMessage = "Некоректний пароль";
        BrainMainPage brainMainPage = new BrainMainPage(driver);

        brainMainPage.clickLogIn();
        brainMainPage.putLogin();
        brainMainPage.putWrongPassword();
        brainMainPage.clickOnSubmitButton();
        brainMainPage.checkWrongAccountMessage(errorMessage);
    }
}
