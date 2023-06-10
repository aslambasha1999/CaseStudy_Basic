import time
import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains

@pytest.fixture
def driver():
    # Setup
    driver = webdriver.Chrome()  
    yield driver
    # Teardown
    driver.quit()

def test_scenario_1(driver):
    # Launch the URL
    driver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/")
    
    # Verify the title
    expected_title = "Want to practice test automation? Try these demo sites! | Automation Panda"
    assert driver.title == expected_title
    
    # Click on "Speaking" and verify the title of the page
    speaking_link = driver.find_element(By.XPATH, "//a[contains(text(),'Speaking')]")
    speaking_link.click()
    expected_speaking_title = "Speaking | Automation Panda"
    assert driver.title == expected_speaking_title
    
    # Verify "Keynote Addresses" is present and verify the text
    keynote_element = driver.find_element(By.XPATH, "//h2[contains(text(),'Keynote Addresses')]")
    assert keynote_element.is_displayed()
    assert keynote_element.text == "Keynote Addresses"
    
    # Verify "Conference Talks" is present and verify the text
    conference_element = driver.find_element(By.XPATH, "//h2[@id='conferences']")
    assert conference_element.is_displayed()
    assert conference_element.text == "Conference Talks"


def test_scenario_2(driver):
    # Launch the URL
    driver.get("https://www.flipkart.com/")


    # To Click X Button on PopUp
    cross_button = WebDriverWait(driver, 10).until(
        EC.visibility_of_element_located((By.XPATH, "//button[contains(text(),'✕')]"))
    )
    assert cross_button.is_displayed()
    cross_button.click()

    
    
    # Verify the Login button is present
    login_button = WebDriverWait(driver, 10).until(
        EC.visibility_of_element_located((By.XPATH, "//a[contains(text(),'Login')]"))
    )
    assert login_button.is_displayed()
    
    # Scroll to the Login button
    actions = ActionChains(driver)
    actions.move_to_element(login_button).perform()
    
    # Click on Login button
    actions.click(login_button).perform()
    
    # Enter Phone Number and click on Request OTP button
    phone_input = driver.find_element(By.XPATH, "(//input[@class='_2IX_2- VJZDxU'])[1]")
    phone_input.send_keys("6200629798")  
    
    request_otp_button = driver.find_element(By.XPATH, "//button[contains(text(),'Request OTP')]")
    request_otp_button.click()
  

    # Handle "Press and Hold to Confirm Human Verification"
    human_verification_element = WebDriverWait(driver, 10).until(
        EC.visibility_of_element_located((By.XPATH, "//div[@aria-label='Press & Hold']"))
    )
    actions.move_to_element(human_verification_element).click_and_hold().perform()
    time.sleep(20)  
    actions.release().perform()

    # Verify the success message
    success_message = WebDriverWait(driver, 10).until(
        EC.visibility_of_element_located((By.XPATH, "//div[contains(text(), 'Please enter the OTP sent to')]"))
    )
    
    expected_message = f"Please enter the OTP sent to {phone_input.get_attribute('value')}"
    assert success_message.text == expected_message

