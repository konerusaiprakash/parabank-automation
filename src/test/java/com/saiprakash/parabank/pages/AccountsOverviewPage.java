package com.saiprakash.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/** Accounts overview page shown after a successful login. */
public class AccountsOverviewPage extends BasePage {

    private final By heading = By.cssSelector("h1.title");
    private final By accountTable = By.id("accountTable");

    public AccountsOverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(heading, "Accounts Overview"));
        return visible(accountTable).isDisplayed();
    }
}
