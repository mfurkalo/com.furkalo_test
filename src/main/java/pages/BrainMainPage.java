package pages;

import core.ClickOn;
import io.qameta.allure.Step;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static data.BrainConstants.*;

public class BrainMainPage extends PageObjectCreator implements ClickOn {
    public BrainMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".br-th-login")
    WebElement logInButton;

    @FindBy(id = "modal-login-phone-field")
    WebElement logInField;

    @FindBy(id = "modal-login-password-field")
    WebElement passwordInputField;

    @FindBy(className = "br-login-submit")
    WebElement submitButton;

    @FindBy(css = ".user-panel-button>span")
    WebElement userName;

    @FindBy(css = ".login-error")
    WebElement errorMessage;

    @Step("clicking on the authorization link")
    public void clickLogIn() {
        new WebDriverWait(driver, 20)
                .withMessage("logIn button is not clickable")
                .ignoring(ElementNotInteractableException.class)
                .until(ExpectedConditions.elementToBeClickable(logInButton));
        clickOnMouse(logInButton);
    }

    @Step("input " + LOGIN + "  into the log-in field")
    public void putLogin() {
        new WebDriverWait(driver, 20)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("login field not found")
                .until(ExpectedConditions.elementToBeClickable(logInField));
        putTextIntoField(logInField, LOGIN);
    }

    @Step("input " + WRONG_LOGIN + "  into the log-in field")
    public void putWrongLogin() {
        new WebDriverWait(driver, 20)
                .withMessage("login field not found")
                .until(ExpectedConditions.elementToBeClickable(logInField));
        putTextIntoField(logInField, WRONG_LOGIN);
    }

    @Step("input " + PASSWORD + " value into the password field")
    public void putPassword() {
        putTextIntoField(passwordInputField, PASSWORD);
    }

    @Step("input " + WRONG_PASSWORD + " value into the password field")
    public void putWrongPassword() {
        putTextIntoField(passwordInputField, WRONG_PASSWORD);
    }

    @Step("clicking on the submit button")
    public void clickOnSubmitButton() {
        clickOnMouse(submitButton);
    }

    @Step("check the user name")
    public void checkUserName(String expectedUserName) {
        new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).
                until(ExpectedConditions.visibilityOf(userName));
        Assert.assertEquals(userName.getText(), expectedUserName, "The user is not " + userName);
    }

    @Step("check presence of the error message ")
    public void checkWrongAccountMessage(String message) {
        SoftAssert softAssert = new SoftAssert();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(errorMessage));
        softAssert.assertTrue(errorMessage.isDisplayed(), "The wrong data input message is not shown ");
        softAssert.assertEquals(errorMessage.getText(), message, "Error message is different");
        softAssert.assertAll();
    }
}
