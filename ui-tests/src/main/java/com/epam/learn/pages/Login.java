package com.epam.learn.pages;

import com.epam.learn.driver.WebDriverUtils;
import org.openqa.selenium.support.ui.Select;
import utility.StringUtils;

import java.util.Map;

public class Login {
    String nameTextBox = "//form[@action='/{{action}}']/input[@name='name']";
    String emailTextBox = "//form[@action='/{{action}}']/input[@name='email']";
    String signupButton = "//button[text()='Signup']";
    String titleRadioButton = "//input[@value='{{title}}']";
    String createAccountButton = "//button[text()='Create Account']";

    public void enterUserDetails(String name, String email) {
        WebDriverUtils.findByXpath(nameTextBox.replace("{{action}}", "signup")).sendKeys(name);
        WebDriverUtils.findByXpath(emailTextBox.replace("{{action}}", "signup")).sendKeys(email);
    }

    public void clickSignup() {
        WebDriverUtils.findByXpath(signupButton).click();
    }

    public void enterUserDetails(Map<String, String> data) {
        //WebDriverUtils.removeClosedShadowRootElement(WebDriverUtils.findByXpath(""));
        WebDriverUtils.findByXpath(titleRadioButton.replace("{{title}}", data.get("TITLE"))).click();
        WebDriverUtils.findById("password").sendKeys(data.get("PASSWORD"));
        setDateOfBirth(data.get("DATE_OF_BIRTH"));
        if (data.get("NOTIFY_NEWSLETTER").equalsIgnoreCase("Yes")) WebDriverUtils.findById("newsletter").click();
        if (data.get("NOTIFY_SPECIAL_OFFER").equalsIgnoreCase("Yes")) WebDriverUtils.findById("optin").click();
        WebDriverUtils.findById("first_name").sendKeys(data.get("FIRST_NAME"));
        WebDriverUtils.findById("last_name").sendKeys(data.get("LAST_NAME"));
        WebDriverUtils.findById("company").sendKeys(data.get("COMPANY"));
        WebDriverUtils.findById("address1").sendKeys(data.get("ADDRESS1"));
        WebDriverUtils.findById("address2").sendKeys(StringUtils.prepare(data.get("ADDRESS2")));

        Select countryDropdown = new Select(WebDriverUtils.findById("country"));
        countryDropdown.selectByValue(data.get("COUNTRY"));

        WebDriverUtils.findById("state").sendKeys(data.get("STATE"));
        WebDriverUtils.findById("city").sendKeys(data.get("CITY"));
        WebDriverUtils.findById("zipcode").sendKeys(data.get("ZIPCODE"));
        WebDriverUtils.findById("mobile_number").sendKeys(data.get("MOBILE_NUMBER"));
    }

    public void setDateOfBirth(String dateOfBirth) {
        String[] dobParts = dateOfBirth.split("-");
        setDateOfBirth(dobParts[0], dobParts[1], dobParts[2]);
    }

    public void setDateOfBirth(String day, String month, String year) {
        Select dayDropdown = new Select(WebDriverUtils.findById("days"));
        dayDropdown.selectByVisibleText(day);

        Select monthDropdown = new Select(WebDriverUtils.findById("months"));
        monthDropdown.selectByVisibleText(month);

        Select yearDropdown = new Select(WebDriverUtils.findById("years"));
        yearDropdown.selectByVisibleText(year);
    }

    public void clickCreateAccount() {
        WebDriverUtils.findByXpath(createAccountButton).click();
    }
}
