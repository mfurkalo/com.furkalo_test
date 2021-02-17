package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import static core.MultiToneChrome.getInstance;

public class BaseTest {

    public WebDriver driver;

    public WebDriver setUp() {
        driver = getInstance().getDriver();
        return driver;
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
