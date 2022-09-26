package org.wiki.tests;

import net.wiki.drivermanager.DriverManager;
import net.wiki.pages.ArticlePage;
import net.wiki.pages.HomePage;
import net.wiki.utils.ExcelUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.wiki.reports.GetScreenShot;
import org.wiki.reports.Logs;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Parent class of all TestNG methods
 * for common(reusable) methods
 */
public class BaseTest {

    WebDriver driver;
    HomePage homePage;
    ArticlePage articlePage;


    /**
     * Called before TestNG method
     * Sets up Webdriver taking parameter
     * from maven command-line arguments
     */
    @BeforeMethod
    public void setup() {
        String browserName = System.getProperty("browser", "CH");
        Logs.info("Set browser to " + browserName);
        driver = new DriverManager().getWebDriver(browserName);
        Logs.info("launched Web Driver");
    }

    /**
     * Releases Webdriver object after test method run
     * Takes screenshot when test fails
     * @param iResult: TestNG Test Method Result
     */
    @AfterMethod
    public void tearDown(ITestResult iResult) {
        if (iResult.getStatus() == iResult.FAILURE) {
            String testName = iResult.getName().trim();
            Logs.debug("Failed Test Case Name " + testName);
            String timestamp = new SimpleDateFormat( "MM_dd_yyyy_hh_mm_ss" ).format( new Date() );

            try {
                String screenPath = GetScreenShot.capture( driver, testName + "_" + " " + timestamp );
                Logs.debug("Screenshot captured in path " + screenPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Output log to HTML reporter and console Log
     * @param message: Message to be logged
     */
    public void reportLog(String message) {
        Logs.info(message);
        Reporter.log(message);
    }

    /**
     * @return test data from Excel sheet
     * @throws Exception to handle Excel File InputStream
     */
    @DataProvider(name = "Search Article")
    public static Object[][] searchArticle() throws Exception {

        ArrayList<String> testObjArray = ExcelUtil.readExcelData();
        Object[][] o = new Object[testObjArray.size()][1];
        for (int i = 0; i < testObjArray.size(); i++) {
            o[i][0] = testObjArray.get(i);
        }
        return o;
    }
}
