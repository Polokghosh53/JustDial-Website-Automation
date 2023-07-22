package com.cognizant.hackathon.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.cognizant.hackathon.user.UserSleep;

public class JustDialHomePage {
	public static WebDriver driver;

	By loginPopUp = By.cssSelector(".jd_modal_close.jdicon");
	By location = By.cssSelector(".input_location_box>input");
	By autoSuggest = By.id("react-autowhatever-city-auto-suggest--item-1");
	By services = By.id("main-auto");

	public JustDialHomePage(WebDriver driver) {
		JustDialHomePage.driver = driver;
	}

	public void closeLoginPopUp() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(loginPopUp).click();
	}

	public void searchDetails(String arg) {
		driver.findElement(location).click();
		driver.findElement(location).sendKeys(arg);
		UserSleep.rest(2000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(autoSuggest).click();
	}

	public void servicesDetails(String arg) {
		driver.findElement(services).sendKeys(arg);
		driver.findElement(services).sendKeys(Keys.ENTER);
		
	}

}
