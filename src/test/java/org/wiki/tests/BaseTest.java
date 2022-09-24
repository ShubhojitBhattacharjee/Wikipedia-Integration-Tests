package org.wiki.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.wiki.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult iResult) {

        if (driver != null) {
            driver.quit();
        }
    }
}
