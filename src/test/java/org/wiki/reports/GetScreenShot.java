package org.wiki.reports;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class GetScreenShot {

	public static void capture(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = "test-output" + File.separator + "Screenshots" + File.separator + screenShotName+".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
	}
	
}