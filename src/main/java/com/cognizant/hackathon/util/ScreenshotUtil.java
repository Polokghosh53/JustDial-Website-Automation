package com.cognizant.hackathon.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	//Takes a screenshot of the current state of the WebDriver
	public String takeScreenshot(WebDriver driver, String methodName) {
		
		// Remove underscores and spaces from the methodName to create a clean filename
		String name = methodName.replaceAll("[_\\s]", "");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "/Screenshot/"+ name + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			// Copy the source screenshot file to the destination file path
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}

}
