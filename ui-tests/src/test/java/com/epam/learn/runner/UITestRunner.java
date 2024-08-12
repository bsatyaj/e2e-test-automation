package com.epam.learn.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.epam.learn"},
        plugin = {"pretty", "html:target/cucumber-report/report.html"}
)
public class UITestRunner extends AbstractTestNGCucumberTests {
}
