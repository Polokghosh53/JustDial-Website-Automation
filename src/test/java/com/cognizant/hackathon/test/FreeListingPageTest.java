package com.cognizant.hackathon.test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.cognizant.hackathon.driver.DriverSetUp;
import com.cognizant.hackathon.pages.FreeListingPage;
import com.cognizant.hackathon.user.UserSleep;
import com.cognizant.hackathon.util.ExtentReportManager;
import com.cognizant.hackathon.util.ScreenshotUtil;

public class FreeListingPageTest {
	private WebDriver driver;
	private String baseUrl = "https://www.justdial.com/";
	private ExtentReports extent;
	private ExtentTest test;
	private FreeListingPage page;

	@BeforeTest
	public void OpenJustDialWebPage() {
		driver = DriverSetUp.chooseDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        UserSleep.rest(10000);

		String reportPath = System.getProperty("user.dir") + "/testreport/TESTREPORT3.html";
        extent = ExtentReportManager.createInstance(reportPath);
	}

	@Test(priority = 1)
	public void CloseLoginPopUp() {
		try {
			page = new FreeListingPage(driver);
			page.closeLoginPopUp();
			test = extent.createTest("1", "Test Case 1 has passed");
			UserSleep.rest(5000);
			test.pass("Closed Login Pop-Up");
		} catch (Exception e) {
			test = extent.createTest("1","Test Case 1 has failed");
			test.fail("Test Case 1 failed");
		}
	}

	@Test(priority = 2)
	public void NavigatingToFreeListingPage() {
		try {
			page = new FreeListingPage(driver);
			page.clickOnTheFreeListing();
			test = extent.createTest("2", "Test Case 2 has passed");
			test.pass("Navigated to the Free Listing Page");
		} catch (Exception e) {
			test = extent.createTest("2","Test Case 2 has failed");
			test.fail("Test Case 2 failed");
		}
	}

	@Test(priority = 3)
	public void FillingFreeListingFormWithPhoneNumberFieldInvalid() {
		try {
			page = new FreeListingPage(driver);
			page.fillTheForm("Car Wash", "Kolkata", "Polok", "Ghosh", "8961872976");
			test = extent.createTest("3", "Test Case 3 has passed");
			test.pass("Free Listing form filled");
		} catch (Exception e) {
			test = extent.createTest("3","Test Case 3 has failed");
			test.fail("Test Case 3 failed");
		}
	}

	@AfterMethod
	protected void takeFailedScreenshots(ITestResult result) throws IOException {
		if (test != null) {
			ScreenshotUtil sc = new ScreenshotUtil();
			String loc = sc.takeScreenshot(driver, result.getName());
			test.info("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(loc).build());
		}
	}

	@AfterTest
	public void CloseJustDialWebPage() {
		UserSleep.rest(5000);
		driver.quit();
		extent.flush();
	}
}
