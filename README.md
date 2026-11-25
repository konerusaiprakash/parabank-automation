# ParaBank Banking Application Automation (Selenium + Cucumber + TestNG)

BDD test automation framework for the public demo banking application
[ParaBank](https://parabank.parasoft.com/parabank), built with Java, Selenium WebDriver, Cucumber,
TestNG and Maven using the Page Object Model.

## What it covers
- Customer registration and login (positive and negative scenarios)
- Funds transfer between accounts (data-driven with Scenario Outline)
- Bill payment, including mandatory field validation
- A new customer is registered for every run, so tests do not depend on old data

## Tech stack
Java 17, Selenium WebDriver 4, Cucumber 7 (BDD), TestNG, Maven, Extent Reports, Jenkins

## Project structure
```
src/test/java/com/saiprakash/parabank
  base/        DriverFactory (Chrome/Firefox, headless option) and Hooks (setup, teardown, failure screenshots)
  pages/       Page Object classes
  stepdefs/    Cucumber step definitions
  runners/     TestNG + Cucumber runner
  utils/       ConfigReader, TestDataGenerator
src/test/resources
  features/    authentication, transfer_funds, bill_pay
  config.properties, extent.properties
Jenkinsfile
```

## How to run
Requirements: JDK 17, Maven, Chrome or Firefox.

```
mvn clean test
```

Useful options:

```
mvn clean test -Dbrowser=firefox
mvn clean test -Dheadless=true
mvn clean test -Dcucumber.filter.tags="@smoke"
```

## Reports
- Extent Report: `target/extent-report/ExtentSpark.html`
- Cucumber HTML report: `target/cucumber-reports/cucumber.html`
- Failed scenarios include a screenshot

## Notes
ParaBank is a shared public demo site, so it can be slow or reset its data. If a test fails once, run it again
before changing the code.

## Author
Koneru Loka Saiprakash
