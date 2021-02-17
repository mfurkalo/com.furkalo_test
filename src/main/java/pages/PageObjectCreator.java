package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObjectCreator {

    protected WebDriver driver;

    public PageObjectCreator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
