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
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        
        driver = new ChromeDriver(options);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    @Test(description = "Open example.com and verify URL")
    public void testOpenExampleAndVerifyURL() {
        driver.get("https://www.example.com");
        
        String expectedURL = "https://www.example.com/";
        String actualURL = driver.getCurrentUrl();
        System.out.println("Actual URL: " + actualURL);
        System.out.println("Expected URL: " + expectedURL);
        Assert.assertEquals(actualURL, expectedURL, "URL verification failed!");
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

