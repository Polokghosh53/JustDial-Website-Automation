package homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;



public class JustDialHomePage {
	public static WebDriver driver;

	static By loginPopUp = By.cssSelector(".jd_modal_close.jdicon");
	static By location = By.cssSelector(".input_location_box>input");
	static By autoSuggest = By.id("react-autowhatever-city-auto-suggest--item-1");
	static By services = By.id("main-auto");

	public JustDialHomePage(WebDriver driver) {
		JustDialHomePage.driver = driver;
	}

	public void closeLoginPopUp() {

		driver.findElement(loginPopUp).click();
	}

	public void searchDetails(String arg) {
		driver.findElement(location).click();
		driver.findElement(location).sendKeys(arg);
		driver.findElement(autoSuggest).click();
	}

	public void servicesDetails(String arg) {
		driver.findElement(services).sendKeys(arg);
		driver.findElement(services).sendKeys(Keys.ENTER);
	}

}
