package com.epam.learn.driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.ConfigReader;

import java.time.Duration;

public class WebDriverManager {
    private static final ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();

    @Before
    public void setup(Scenario scenario) {
        String environment = System.getProperty("env");
        String browser = System.getProperty("browser");

        String baseUrl = ConfigReader.getValueBy(environment, "BASE_URL");

        if(browser.equalsIgnoreCase("chrome"))
            setChromeDriver();
        else if(browser.equalsIgnoreCase("firefox"))
            setFirefoxDriver();
        else if(browser.equalsIgnoreCase("edge"))
            setEdgeDriver();

        tDriver.get().manage().window().maximize();
        tDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        tDriver.get().get(baseUrl);
    }

    @After
    public void clean(Scenario scenario) {
        if(tDriver.get() != null)
            tDriver.get().quit();

        tDriver.remove();
    }

    public void setChromeDriver() {
        tDriver.set(new ChromeDriver());
    }

    public void setFirefoxDriver() {
        tDriver.set(new FirefoxDriver());
    }

    public void setEdgeDriver() {
        tDriver.set(new EdgeDriver());
    }

    public static WebDriver getDriver() {
        return tDriver.get();
    }
}
