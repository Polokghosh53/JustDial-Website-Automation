package com.cognizant.hackathon.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.cognizant.hackathon.user.UserSleep;

public class FreeListingPage {
	public static WebDriver driver;

	JavascriptExecutor jse = (JavascriptExecutor) driver;
	By loginPopUp = By.cssSelector(".jd_modal_close.jdicon");
	By link = By.linkText("Free Listing");
	By companyName = By.id("fcom");
	By location = By.id("flcity");
	By firstName = By.name("fname");
	By lastName = By.name("lname");
	By mobileNo = By.id("fmb0");
	By submit = By.cssSelector("button.bbtn.subbtn");

	public FreeListingPage(WebDriver driver) {
		FreeListingPage.driver = driver;
	}

	public void closeLoginPopUp() {

		driver.findElement(loginPopUp).click();
	}

	public void clickOnTheFreeListing() {
		driver.findElement(link).click();
	}

	public void fillTheForm(String arg1, String arg2, String arg3, String arg4, String arg5) {
		driver.findElement(companyName).sendKeys(arg1);
		driver.findElement(location).clear();
		driver.findElement(location).sendKeys(arg2);
		driver.findElement(By.cssSelector(".fsec>.drop>span.slct")).click();
		jse.executeScript("document.querySelector('#salopt').style.display='block'");
		driver.findElement(By.cssSelector("#salopt>li:nth-child(1)")).click();
		driver.findElement(firstName).sendKeys(arg3);
		driver.findElement(lastName).sendKeys(arg4);
		driver.findElement(mobileNo).sendKeys(arg5);
		UserSleep.rest(2000);
		driver.findElement(submit).click();
		UserSleep.rest(4000);
		Alert alert = driver.switchTo().alert();
		String message = driver.switchTo().alert().getText();
		System.out.println(message);
		alert.accept();


	}

}
