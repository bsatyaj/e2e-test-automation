package com.epam.learn.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class WebDriverUtils {
    public static WebElement findByXpath(String xpath) {
        WebElement element = WebDriverManager.getDriver().findElement(By.xpath(xpath));
        scrollAndHighlight(element);
        return element;
    }

    public static WebElement findById(String id) {
        WebElement element = WebDriverManager.getDriver().findElement(By.id(id));
        scrollAndHighlight(element);
        return element;
    }

    public static WebElement findByLinkText(String linkText) {
        WebElement element = WebDriverManager.getDriver().findElement(By.linkText(linkText));
        scrollAndHighlight(element);
        return element;
    }

    public static WebElement findByCssSelector(String cssSelector) {
        WebElement element = WebDriverManager.getDriver().findElement(By.cssSelector(cssSelector));
        scrollAndHighlight(element);
        return element;
    }

    public static JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) WebDriverManager.getDriver();
    }

    public static void scrollIntoView(WebElement element) {
        getJavascriptExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void highlight(WebElement element) {
        getJavascriptExecutor().executeScript("arguments[0].style.border='1px solid red'", element);
    }

    public static void scrollAndHighlight(WebElement element) {
        scrollIntoView(element);
        highlight(element);
    }

    public static void removeClosedShadowRootElement(WebElement parentElement) {
        getJavascriptExecutor().executeScript("arguments[0].remove()", parentElement);
    }
}
