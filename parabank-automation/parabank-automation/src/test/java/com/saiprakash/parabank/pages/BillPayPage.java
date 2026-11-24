package com.saiprakash.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/** Bill payment page. */
public class BillPayPage extends BasePage {

    private final By payeeName = By.name("payee.name");
    private final By street = By.name("payee.address.street");
    private final By city = By.name("payee.address.city");
    private final By state = By.name("payee.address.state");
    private final By zipCode = By.name("payee.address.zipCode");
    private final By phone = By.name("payee.phoneNumber");
    private final By accountNumber = By.name("payee.accountNumber");
    private final By verifyAccount = By.name("verifyAccount");
    private final By amount = By.name("amount");
    private final By sendPayment = By.cssSelector("input[value='Send Payment']");
    private final By result = By.cssSelector("#billpayResult h1.title");
    private final By validationErrors = By.cssSelector("span.error");

    public BillPayPage(WebDriver driver) {
        super(driver);
    }

    public BillPayPage open() {
        driver.get(baseUrl + "/billpay.htm");
        return this;
    }

    public void payBill(String payee, String value) {
        type(payeeName, payee);
        type(street, "45 Station Road");
        type(city, "Vijayawada");
        type(state, "Andhra Pradesh");
        type(zipCode, "520002");
        type(phone, "9123456780");
        type(accountNumber, "12345");
        type(verifyAccount, "12345");
        type(amount, value);
        click(sendPayment);
    }

    public void submitWithoutDetails() {
        click(sendPayment);
    }

    public String getResultHeading() {
        return textOf(result);
    }

    public boolean hasValidationErrors() {
        wait.until(d -> !d.findElements(validationErrors).isEmpty());
        return driver.findElements(validationErrors).stream().anyMatch(e -> !e.getText().isBlank());
    }
}
