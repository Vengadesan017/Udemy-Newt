from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.options import Options
import os

chrome_option = Options()
chrome_option.add_argument("--disable-web-security-choice-screen")

service = Service("./chromedriver-win64/chromedriver.exe")
driver = webdriver.Chrome(options=chrome_option, service=service)
driver.get("https://demoqa.com/login")

def login():
    # find element in html page
    user_name = WebDriverWait(driver, 10).until(EC.visibility_of_element_located((By.ID, 'userName')))
    password_feild = WebDriverWait(driver, 10).until(EC.visibility_of_element_located((By.ID, 'password')))
    login_button = driver.find_element(By.ID, 'login')

    # fill data in form
    user_name.send_keys("newuser17")
    password_feild.send_keys("NewUser@17")
    driver.execute_script('arguments[0].click();', login_button)

def fill_form():
    ### navigate to form then fill the form then submit
    # go to the form s page by the side nav
    elements = WebDriverWait(driver, 10).until(
        EC.visibility_of_element_located((By.XPATH, '//*[@id="app"]/div/div/div/div[1]/div/div/div[1]/span/div')))
    elements.click()

    # find the form
    text_box = WebDriverWait(driver, 10).until(EC.visibility_of_element_located((By.ID, 'item-0')))
    text_box.click()

    # find the form inputs
    full_name = WebDriverWait(driver, 10).until(EC.visibility_of_element_located((By.ID, 'userName')))
    email = WebDriverWait(driver, 30).until(EC.visibility_of_element_located((By.ID, 'userEmail')))
    cur_address = WebDriverWait(driver, 10).until(EC.visibility_of_element_located((By.ID, 'currentAddress')))
    per_address = WebDriverWait(driver, 30).until(EC.visibility_of_element_located((By.ID, 'permanentAddress')))
    submit_button = driver.find_element(By.ID, 'submit')

    # fill form
    full_name.send_keys("Hello World... :)")
    email.send_keys("hello@world.com")
    cur_address.send_keys("My current address is...")
    per_address.send_keys("My permanent address is...")

    # click the submit button
    driver.execute_script('arguments[0].click();', submit_button)



def download_file():
    # download the file
    download_field = WebDriverWait(driver, 30).until(
        EC.presence_of_element_located((By.ID, 'item-7'))
    )

    # Scroll the element into view using JavaScript
    driver.execute_script("arguments[0].scrollIntoView();", download_field)

    # Now click the element
    download_field.click()
    # download the file
    download = driver.find_element(By.ID, 'downloadButton')
    driver.execute_script('arguments[0].click();', download)





login()
fill_form()
download_file()

input("Press enter to stop")
driver.quit()

