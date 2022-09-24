package org.wiki.tests;

import net.wiki.drivermanager.DriverManager;
import net.wiki.pages.ArticlePage;
import net.wiki.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.wiki.reports.GetScreenShot;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


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
        if (iResult.getStatus() == iResult.FAILURE) {
            String testName = iResult.getName().trim();
            String timestamp = new SimpleDateFormat( "MM_dd_yyyy_hh_mm_ss" ).format( new Date() );

            try {
                GetScreenShot.capture( driver, testName + "_" + " " + timestamp );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (driver != null) {
            driver.quit();
        }
    }
}
