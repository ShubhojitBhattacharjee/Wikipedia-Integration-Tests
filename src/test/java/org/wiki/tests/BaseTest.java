package org.wiki.tests;

import net.wiki.drivermanager.DriverManager;
import net.wiki.pages.ArticlePage;
import net.wiki.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    WebDriver driver;
    HomePage homePage;
    ArticlePage articlePage;

    @BeforeMethod
    public void setup(ITestContext ctx) {
        String browserName = ctx.getCurrentXmlTest().getParameter("browser");
        driver = new DriverManager().getWebDriver(browserName);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult iResult) {

        if (driver != null) {
            driver.quit();
        }
    }
}
