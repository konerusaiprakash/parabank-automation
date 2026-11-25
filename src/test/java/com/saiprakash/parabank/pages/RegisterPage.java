package com.saiprakash.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/** Customer registration page. A successful registration also logs the customer in. */
public class RegisterPage extends BasePage {

    private final By firstName = By.id("customer.firstName");
    private final By lastName = By.id("customer.lastName");
    private final By street = By.id("customer.address.street");
    private final By city = By.id("customer.address.city");
    private final By state = By.id("customer.address.state");
    private final By zipCode = By.id("customer.address.zipCode");
    private final By phone = By.id("customer.phoneNumber");
    private final By ssn = By.id("customer.ssn");
    private final By username = By.id("customer.username");
    private final By password = By.id("customer.password");
    private final By confirmPassword = By.id("repeatedPassword");
    private final By registerButton = By.cssSelector("input[value='Register']");
    private final By message = By.cssSelector("#rightPanel p");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage open() {
        driver.get(baseUrl + "/register.htm");
        return this;
    }

    public void register(String user, String pass) {
        type(firstName, "Sai");
        type(lastName, "Prakash");
        type(street, "12 MG Road");
        type(city, "Vijayawada");
        type(state, "Andhra Pradesh");
        type(zipCode, "520001");
        type(phone, "9876543210");
        type(ssn, "123-45-6789");
        type(username, user);
        type(password, pass);
        type(confirmPassword, pass);
        click(registerButton);
    }

    public String getConfirmationMessage() {
        return textOf(message);
    }
}
