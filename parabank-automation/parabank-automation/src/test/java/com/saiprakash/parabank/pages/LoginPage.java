package com.saiprakash.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/** Home page with the customer login panel. */
public class LoginPage extends BasePage {

    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector("input[value='Log In']");
    private final By errorMessage = By.cssSelector("p.error");
    private final By logoutLink = By.linkText("Log Out");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(baseUrl + "/index.htm");
        return this;
    }

    public void login(String user, String pass) {
        type(usernameField, user);
        type(passwordField, pass);
        click(loginButton);
    }

    public void logout() {
        click(logoutLink);
    }

    public String getErrorMessage() {
        return textOf(errorMessage);
    }
}
