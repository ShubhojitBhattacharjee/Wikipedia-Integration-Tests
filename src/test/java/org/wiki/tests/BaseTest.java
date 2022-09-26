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

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class BaseTest {

    WebDriver driver;
    HomePage homePage;
    ArticlePage articlePage;

    @BeforeMethod
    public void setup(ITestContext ctx) {
        String browserName = System.getProperty("browser", "CH");
//        String browserName = ctx.getCurrentXmlTest().getParameter("browser");
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

    public void reportLog(String message) {
        Reporter.log(message);
    }

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
