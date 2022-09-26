package net.wiki.drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;


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

            setWebDriverTimeouts();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cannot set browser " + browserName);
        }
        return driver;
    }

    private WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        String headlesStatus = System.getProperty("headless", "false");
        if (headlesStatus.equalsIgnoreCase("true")) {
            firefoxOptions.addArguments("--headless");
        }
        return new FirefoxDriver(firefoxOptions);
    }

    private WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        String headlesStatus = System.getProperty("headless", "false");
        if (headlesStatus.equalsIgnoreCase("true")) {
            chromeOptions.addArguments("--headless");
        }
        return new ChromeDriver(chromeOptions);
    }

    private WebDriver getSafariDriver() throws Exception {
        if (System.getProperty("headless", "false").equalsIgnoreCase("true"))
            throw new Exception("Headless Mode is not supported in Safari");
        return new SafariDriver();
    }

    private void setWebDriverTimeouts() throws Exception {
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } else {
            throw new Exception("Driver is null. Cannot set driver timeouts.");
        }
    }
}
