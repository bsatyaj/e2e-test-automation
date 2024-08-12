package com.epam.learn.pages;


import com.epam.learn.driver.WebDriverUtils;

public class AccountCreated {
    public String getAccountCreatedMessage() {
        String message1 = WebDriverUtils.findByXpath("//h2/b").getText();
        String message2 = WebDriverUtils.findByXpath("//h2/following-sibling::p[1]").getText();
        String message3 = WebDriverUtils.findByXpath("//h2/following-sibling::p[2]").getText();
        return message1 + " " + message2 + " " + message3;
    }

    public void clickContinue() {
        WebDriverUtils.findByLinkText("Continue").click();
    }
}
