package com.QA.CaseStudy1.Scenario2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FlipkartScenario extends Base2{
	
	@Test(priority = 1)
    public void verifyFlipkartLogoOnHomePage() {
		
		// Verify that Flipkart is present on the left side of the top
		if(FlipkartPageElements.isFlipkartLogoDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Flipkart logo is present on the left side of the top.");
		}
		else {
			
			System.out.println("Flipkart logo is not present on the left side of the top.");
			Assert.assertTrue(false);
			
		}
        
		
    }
	
	@Test(priority = 2)
    public void searchAndVerifyFirstItem() {
		
		FlipkartPageElements.clickXBtn();
		FlipkartPageElements.searchForProduct("iphone 14");
		String results=FlipkartPageElements.getSearchResultCount();
		System.out.println(results+" Results showing for the provided search");
		FlipkartPageElements.clickFirstSearchItem();
        
		String expectedMessage = "Iphone 14- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
        String actualMessage = driver.getTitle();
        Assert.assertEquals(actualMessage, expectedMessage);
        System.out.println("Browser Navigated to Correct Page");
		
		
		
		
	}
	

}
