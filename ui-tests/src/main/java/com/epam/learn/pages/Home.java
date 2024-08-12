package com.epam.learn.pages;


import com.epam.learn.driver.WebDriverUtils;

public class Home {
    String signupOrLoginLink = "//a[text()=' Signup / Login']";

    public void navigateToLoginPage() {
        WebDriverUtils.findByXpath(signupOrLoginLink).click();
    }
}
