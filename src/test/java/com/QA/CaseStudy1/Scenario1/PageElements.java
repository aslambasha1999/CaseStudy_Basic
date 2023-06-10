package com.QA.CaseStudy1.Scenario1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageElements {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//a[contains(text(),'Contact')]")
    private WebElement contactLink;
	
	
	@FindBy(xpath="//input[@id='g3-name']")
    private WebElement nameInput;

    @FindBy(xpath="//input[@name='g3-email']")
    private WebElement emailInput;

    @FindBy(css = "#contact-form-comment-g3-message")
    private WebElement commentInput;

    @FindBy(xpath="//strong[contains(text(),'Contact Me')]")
    private WebElement submitButton;

    @FindBy(id = "contact-form-success-header")
    private WebElement messageSentText;

	
	
	public void clickContactLink() {
        contactLink.click();
        System.out.println("Clicked on Contact Link");
    }
	
	 public void fillContactForm(String name, String email, String comment) {
	        nameInput.sendKeys(name);
	        System.out.println("Name Entered");
	        emailInput.sendKeys(email);
	        System.out.println("Email Entered");
	        commentInput.sendKeys(comment);
	        System.out.println("Comment Message Entered");
	        submitButton.click();
	        System.out.println("Clicked on Submit Button");
	    }

	    public String getMessageSentText() {
	        return messageSentText.getText();
	    }
	
	    
	    public PageElements(WebDriver driver)
		{
	    	this.driver = driver;
	    	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	        PageFactory.initElements(driver, this);
		}
	
	
}
