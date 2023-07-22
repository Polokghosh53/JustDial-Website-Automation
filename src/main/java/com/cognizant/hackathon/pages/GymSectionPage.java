package com.cognizant.hackathon.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GymSectionPage {
	public static WebDriver driver;

	By loginPopUp = By.cssSelector(".jd_modal_close.jdicon");
	By selectGym = By.xpath("//*[@id=\"__next\"]/div/section/section[2]/div/div/div[2]/a[13]");
	By popularModels = By.xpath("//*[@id=\"sectwo\"]/div[2]/div");

	public GymSectionPage(WebDriver driver) {
		GymSectionPage.driver = driver;
	}

	public void closeLoginPopUp() {

		driver.findElement(loginPopUp).click();
	}

	public void clickOnTheGym() {
		driver.findElement(selectGym).click();
	}

	public void gymCentersName() {
		List<String> popularModelNames = new ArrayList<>();
		List<WebElement> elements = driver.findElements(popularModels);
		for (WebElement e : elements) {
			popularModelNames.add(e.getText());
			System.out.println("Gym Center's name is: " + e.getText());
		}
	}
}
