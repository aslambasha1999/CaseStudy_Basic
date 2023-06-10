package com.QA.CaseStudy1.Scenario1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationPandaScenario extends Base{
	
	

	@Test(priority=1)
	public void verifyTitleOnAutomationPanda() {
		
		String expectedTitle = "Want to practice test automation? Try these demo sites! | Automation Panda";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        
        System.out.println("Title Verified on Home Page");
		
	}
	
	@Test(priority = 2)
    public void verifyContactPage() {
		
        
		pageElements.clickContactLink();
        String expectedTitle = "Contact | Automation Panda";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Title Verified on Contact Page");
    }

	 @Test(priority = 3)
	    public void fillContactFormAndVerifyMessageSent() {
		 
		 	pageElements.fillContactForm("Shaik Aslambasha", "aslam@example.com", "This is a test comment for demo");
	        String expectedMessage = "Your message has been sent";
	        String actualMessage = pageElements.getMessageSentText();
	        Assert.assertEquals(actualMessage, expectedMessage);
	        System.out.println("Sent Message text Verified");
	    }
}
