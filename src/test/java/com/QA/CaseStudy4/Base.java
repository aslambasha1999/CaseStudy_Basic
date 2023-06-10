package com.QA.CaseStudy4;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


public class Base {
	
	WebDriver driver;
	WebDriverWait wait;
	String baseUrl;
	PageElements pageElements;

	
    @BeforeSuite
    @Parameters("baseUrl")
    public void setUp(String baseUrl) {
    	
        // Initialize WebDriver
        System.setProperty("webdriver.chrome.driver", "DriverExecutables\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Chrome Browser Opened");
        wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        driver.manage().window().maximize();
        System.out.println("Browser Maximized");
        
        // Set the base URL
        this.baseUrl = baseUrl;
        
        pageElements = new PageElements(driver);
        driver.get(baseUrl);
        
        System.out.println("URL Opened");
        
    }
    
    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser Closed");
        }
    }

}
