package homePageTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cognizant.hackathon.driver.DriverSetUp;
import com.cognizant.hackathon.user.UserSleep;

import carWashServicesPage.CarWashServicesInKolkata;
import homePage.JustDialHomePage;

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

		report = new ExtentSparkReporter(System.getProperty("user.dir") + "/testreport/TESTREPORT1.html");
		report.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(report);
	}

	@Test(priority = 1)
	public void CloseLoginPopUp() {
		
		page = new JustDialHomePage(driver);
		page.closeLoginPopUp();
		test = extent.createTest("1", "Test Case 1 has passed");
		UserSleep.rest(5000);
	}

	@Test(priority = 2)
	public void SettingSearchLocationAsKolkata() {
		page = new JustDialHomePage(driver);
		page.searchDetails("Kolkata");
		test = extent.createTest("2", "Test Case 2 has passed");
	}

	@Test(priority = 3)
	public void SearchingForCarWashingServices() {
		page = new JustDialHomePage(driver);
		page.servicesDetails("Car Washing Services");
		test = extent.createTest("3", "Test Case 3 has passed");
	}

	@Test(priority = 4)
	public void SortingSearchResultByRatingDescending() {
		car = new CarWashServicesInKolkata(driver);
		car.clickOnTheTopRated();
		test = extent.createTest("4", "Test Case 4 has passed");
	}

	@AfterTest
	public void CloseJustDialWebPage() {
		UserSleep.rest(5000);
		driver.close();
		extent.flush();
	}

}
