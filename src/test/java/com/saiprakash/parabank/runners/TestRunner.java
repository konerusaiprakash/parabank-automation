package com.saiprakash.parabank.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/** Entry point. Run a subset with: mvn test -Dcucumber.filter.tags="@smoke" */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.saiprakash.parabank.stepdefs", "com.saiprakash.parabank.base"},
        plugin = {
            "pretty",
            "html:target/cucumber-reports/cucumber.html",
            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}
