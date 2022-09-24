package net.wiki.drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class DriverManager {

    private WebDriver driver;

    public WebDriver getWebDriver(String browserName) {
        try {
            if ("CH".equals(browserName)) {
                driver = getChromeDriver();

            } else if ("FF".equals(browserName)) {
                driver = getFirefoxDriver();

            } else if ("SF".equals(browserName)) {
                driver = getSafariDriver();

            } else {
                throw new Exception("Invalid browser: " + browserName);
            }
            driver.manage().window().maximize();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cannot set browser " + browserName);
        }
        return driver;
    }

    private WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver getSafariDriver() {
        return new SafariDriver();
    }
}
