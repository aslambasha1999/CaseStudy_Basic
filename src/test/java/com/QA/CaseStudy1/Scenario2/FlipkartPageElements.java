package com.QA.CaseStudy1.Scenario2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartPageElements {
	
	static WebDriver driver;
	static WebDriverWait wait;

	@FindBy(xpath = "//img[@title='Flipkart']")
    private static WebElement flipkartLogo;
	
	@FindBy(xpath="//button[contains(text(),'✕')]")
	private static WebElement crossBtn;
	

    @FindBy(xpath="//input[@name='q']")
    private static WebElement searchBox;
    
    @FindBy(className = "_10Ermr")
    private static WebElement resultCount;
    
    @FindBy(xpath = "(//div[@class='_2kHMtA'])[1]")
    private static WebElement firstSearchItem;
    
    
    
    
    
    public static boolean isFlipkartLogoDisplayed() {
        return flipkartLogo.isDisplayed();
    }

    public static void searchForProduct(String productName) {
        searchBox.sendKeys(productName);
        searchBox.sendKeys(Keys.ENTER);
    }
    
    public static String getSearchResultCount()
    {
    	return resultCount.getText().split(" ")[5];
    	
    }
    
    public static void clickFirstSearchItem() {
        firstSearchItem.click();
    }

	public static void clickXBtn()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(crossBtn));
		crossBtn.click();
		
	}
    
    public FlipkartPageElements(WebDriver driver)
	{
    	this.driver = driver;
    	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
	}

}
