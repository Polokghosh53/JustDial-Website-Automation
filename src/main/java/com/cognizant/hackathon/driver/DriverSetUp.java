package com.cognizant.hackathon.driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverSetUp {
    private static WebDriver driver;

    public static WebDriver chooseDriver() {
        String browser = getBrowserChoice();

        if (browser == null) {
            throw new IllegalArgumentException("Invalid browser choice: browser property not found in config.properties");
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Polok\\Downloads\\chromedriver_win32\\chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "edge":
                System.setProperty("webdriver.edge.driver", "C:\\Users\\Polok\\Downloads\\edgedriver_win64\\msedgedriver.exe");
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications");
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                throw new IllegalArgumentException("Invalid browser choice: " + browser);
        }

        return driver;
    }

    private static String getBrowserChoice() {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("resources/properties/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("Failed to read config.properties file: " + e.getMessage());
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return properties.getProperty("browser");
    }
}
