package core;

import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverOptions {

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }
}
