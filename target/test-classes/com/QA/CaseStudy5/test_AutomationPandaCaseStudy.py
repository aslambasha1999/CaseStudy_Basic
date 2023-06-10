import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

@pytest.fixture
def driver():
    # Setup
    driver = webdriver.Chrome()  
    driver.implicitly_wait(10)
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