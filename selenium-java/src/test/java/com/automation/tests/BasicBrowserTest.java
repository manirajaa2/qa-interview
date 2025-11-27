package com.automation.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicBrowserTest {
    
    private WebDriver driver;
    
    @BeforeMethod
    public void setUp() {
        try {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        } catch (Exception e) {
            System.err.println("Error during WebDriver setup: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
    
    @Test(description = "Open example.com and verify URL")
    public void testOpenExampleAndVerifyURL() {
        try {
            driver.get("https://www.example.com");
            String expectedURL = "https://www.example.com/";
            String actualURL = driver.getCurrentUrl();
            Assert.assertEquals(actualURL, expectedURL, "URL verification failed!");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

