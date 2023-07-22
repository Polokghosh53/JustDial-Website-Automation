package carWashServicesPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cognizant.hackathon.user.UserSleep;

public class CarWashServicesInKolkata {
	public static WebDriver driver;

	By sortingOfRating = By.xpath("//*[contains(text(),'Top Rated')]");
	By serviceCenterNames = By.xpath("//*[contains(@class, 'results_thumb_icon')]/parent::*");
	By serviceCenterPhones = By.xpath("//*[contains(@class, 'callcontent')]");
	By hiddenPhoneNumbers = By.xpath("//*[@class='button_flare']");

	public CarWashServicesInKolkata(WebDriver driver) {
		CarWashServicesInKolkata.driver = driver;
	}

	public void clickOnTheTopRated() {
		UserSleep.rest(5000);
		driver.findElement(sortingOfRating).click();
	}

	public void serviceCenterNamesAndPhoneNumbers() {
		List<WebElement> elements = driver.findElements(serviceCenterNames);
		List<WebElement> phoneNumberSpans = driver.findElements(serviceCenterPhones);

		int hiddenPhoneIndex = 0;

		if (elements.size() > 4) {
			System.out.println("--------------------------------------------------------------------------------------");
			for (int i = 0; i < 5; i++) {
				UserSleep.rest(2000);
				String name = elements.get(i).getText();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,200)");
				UserSleep.rest(2000);
				WebElement phoneNumberSpan = phoneNumberSpans.get(i);
				String phoneNumber = null;

				if (phoneNumberSpan.getAttribute("class").contains("callNowAnchor")) {
					phoneNumber = phoneNumberSpan.getText();
				} else {
					driver.findElements(hiddenPhoneNumbers).get(hiddenPhoneIndex++).click();

					UserSleep.rest(2000);
					phoneNumber = phoneNumberSpan.getText();
				}
				
				
				System.out.println(
						"Car Washing service center's name is: " + name + " and phone number is: " + phoneNumber);
			}
			System.out.println("---------------------------------------------------------------------------------------");
		}

	}
	public void navigateBackToHomePage() {
//		driver.navigate().to("https://www.justdial.com/");
		driver.navigate().to("https://www.justdial.com/");
	}

}
