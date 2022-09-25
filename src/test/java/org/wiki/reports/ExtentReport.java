package org.wiki.reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExtentReport implements IReporter, ITestListener {
    private ExtentReports extent;
    private ExtentTest test;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
                               String outputDirectory) {
        extent = new ExtentReports( outputDirectory + File.separator
                + "Wikipedia Test Automation Report.html", true );

        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
                buildTestNodes( context.getPassedTests(), LogStatus.PASS );
                buildTestNodes( context.getFailedTests(), LogStatus.FAIL );
                buildTestNodes( context.getSkippedTests(), LogStatus.SKIP );
            }
        }

        extent.flush();
        extent.close();
    }

    private void buildTestNodes(IResultMap tests, LogStatus status) {
        ExtentTest test;

        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.startTest( result.getMethod().getMethodName() );

                test.setStartedTime( getTime( result.getStartMillis() ) );
                test.setEndedTime( getTime( result.getEndMillis() ) );

                for (String message : Reporter.getOutput( result )) {
                    if (message.contains( "Verified that " ))
                        test.log( LogStatus.PASS, message );
                    else
                        test.log( LogStatus.INFO, message );
                }

                for (String group : result.getMethod().getGroups())
                    test.assignCategory( group );

                if (status.name().equals("FAIL")) {
                    test.log( status, "Test " + status.toString().toLowerCase() + "ed" );
                }

                if (result.getThrowable() != null) {
                    test.log( status, result.getThrowable() );
                } else {
                    test.log( status, "Test " + status.toString().toLowerCase() + "ed" );
                }
                extent.endTest( test );
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis( millis );
        return calendar.getTime();
    }


    @Override
    public void onTestStart(ITestResult result) {

        result.getTestContext().getAttribute( "testName" );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult iResult) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}

