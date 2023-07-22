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
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.cognizant.hackathon.driver.DriverSetUp;
import com.cognizant.hackathon.pages.JustDialHomePage;
import com.cognizant.hackathon.user.UserSleep;
import com.cognizant.hackathon.util.ExtentReportManager;
import com.cognizant.hackathon.util.ScreenshotUtil;

import carWashServicesPage.CarWashServicesInKolkata;

public class JustDialHomePageTest {
	static WebDriver driver;
	static String baseUrl = "https://www.justdial.com/";
	static ExtentSparkReporter report;
	static ExtentReports extent;
	static ExtentTest test;
	JustDialHomePage page;
	CarWashServicesInKolkata car;

	@BeforeTest
	public void OpenJustDialWebPage() {
		driver = DriverSetUp.chooseDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		UserSleep.rest(10000);

		String reportPath = System.getProperty("user.dir") + "/testreport/TESTREPORT1.html";
        extent = ExtentReportManager.createInstance(reportPath);
	}

	@Test(priority = 1)
	public void CloseLoginPopUp() {
		try {
			page = new JustDialHomePage(driver);
			page.closeLoginPopUp();
			test = extent.createTest("1", "Test Case 1 has passed");
			UserSleep.rest(6000);
			test.pass("Closed Login Pop-Up");
		} catch (Exception e) {
			test = extent.createTest("1","Test Case 1 has failed");
			test.fail("Test Case 1 failed");
		}
	}

	@Test(priority = 2)
	public void SettingSearchLocationAsKolkata() {
		try {
			page = new JustDialHomePage(driver);
			page.searchDetails("Kolkata");
			test = extent.createTest("2", "Test Case 2 has passed");
			test.pass("Search Location as Kolkata has been set");
		} catch (Exception e) {
			test = extent.createTest("2","Test Case 2 has failed");
			test.fail("Test Case 2 failed");
		}
	}

	@Test(priority = 3)
	public void SearchingForCarWashingServices() {
		try {
			page = new JustDialHomePage(driver);
			page.servicesDetails("Car Washing Services");
			test = extent.createTest("3", "Test Case 3 has passed");
			test.pass("Searched for Car Washing Services");
		} catch (Exception e) {
			test = extent.createTest("3","Test Case 3 has failed");
			test.fail("Test Case 3 failed");
		}
	}

	@Test(priority = 4)
	public void SortingSearchResultByRatingDescending() {
		try {
			UserSleep.rest(5000);
			car = new CarWashServicesInKolkata(driver);
			car.clickOnTheTopRated();
			test = extent.createTest("4", "Test Case 4 has passed");
			test.pass("Search result has been sorted in descending order");
		} catch (Exception e) {
			test = extent.createTest("4","Test Case 4 has failed");
			test.fail("Test Case 4 failed");
		}
	}

	@Test(priority = 5)
	public void PrintingNamesAndPhoneNumbersOfTopFiveResult() {
		try {
			UserSleep.rest(5000);
			car = new CarWashServicesInKolkata(driver);
			car.serviceCenterNamesAndPhoneNumbers();
			test = extent.createTest("5", "Test Case 5 has passed");
			test.pass("Top Five Names and Phone Numbers has been printed");
		} catch (Exception e) {
			test = extent.createTest("5","Test Case 5 has failed");
			test.fail("Test Case 5 failed");
		}
	}

	@Test(priority = 6)
	public void NavigateBackToHomePage() {
		try {
			UserSleep.rest(5000);
			car = new CarWashServicesInKolkata(driver);
			car.navigateBackToHomePage();
			test = extent.createTest("6", "Test Case 6 has passed");
			test.pass("Navigated to Home Page");
		} catch (Exception e) {
			test = extent.createTest("6","Test Case 6 has failed");
			test.fail("Test Case 6 failed");
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
		driver.close();
		extent.flush();
	}

}
