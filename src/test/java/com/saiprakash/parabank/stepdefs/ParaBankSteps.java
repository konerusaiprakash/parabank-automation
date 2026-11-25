package com.saiprakash.parabank.stepdefs;

import com.saiprakash.parabank.base.DriverFactory;
import com.saiprakash.parabank.pages.AccountsOverviewPage;
import com.saiprakash.parabank.pages.BillPayPage;
import com.saiprakash.parabank.pages.LoginPage;
import com.saiprakash.parabank.pages.RegisterPage;
import com.saiprakash.parabank.pages.TransferFundsPage;
import com.saiprakash.parabank.utils.TestDataGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

/** Step definitions for all ParaBank feature files. */
public class ParaBankSteps {

    private String username;
    private String password;

    private RegisterPage registerPage() {
        return new RegisterPage(DriverFactory.getDriver());
    }

    private LoginPage loginPage() {
        return new LoginPage(DriverFactory.getDriver());
    }

    // ---------- authentication ----------

    @Given("the ParaBank home page is open")
    public void theParaBankHomePageIsOpen() {
        loginPage().open();
    }

    @Given("a registered customer")
    public void aRegisteredCustomer() {
        registerNewCustomer();
    }

    @When("the customer registers a new account")
    public void theCustomerRegistersANewAccount() {
        registerNewCustomer();
    }

    @Then("the registration success message is displayed")
    public void theRegistrationSuccessMessageIsDisplayed() {
        String message = registerPage().getConfirmationMessage();
        Assert.assertTrue(message.contains("Your account was created successfully"),
                "Unexpected registration message: " + message);
    }

    @When("the customer logs out and logs in with the same credentials")
    public void theCustomerLogsOutAndLogsInAgain() {
        LoginPage login = loginPage();
        login.logout();
        login.login(username, password);
    }

    @Then("the accounts overview page is displayed")
    public void theAccountsOverviewPageIsDisplayed() {
        Assert.assertTrue(new AccountsOverviewPage(DriverFactory.getDriver()).isDisplayed(),
                "Accounts overview was not displayed");
    }

    @When("the customer logs in with username {string} and password {string}")
    public void theCustomerLogsInWith(String user, String pass) {
        loginPage().login(user, pass);
    }

    @Then("an error message containing {string} is displayed")
    public void anErrorMessageContainingIsDisplayed(String expected) {
        String actual = loginPage().getErrorMessage();
        Assert.assertTrue(actual.contains(expected), "Unexpected error message: " + actual);
    }

    // ---------- transfer funds ----------

    @When("the customer transfers {string} between accounts")
    public void theCustomerTransfersBetweenAccounts(String amount) {
        new TransferFundsPage(DriverFactory.getDriver()).open().transfer(amount);
    }

    @Then("the transfer is completed")
    public void theTransferIsCompleted() {
        String heading = new TransferFundsPage(DriverFactory.getDriver()).getResultHeading();
        Assert.assertEquals(heading, "Transfer Complete!");
    }

    // ---------- bill pay ----------

    @When("the customer pays {string} to the payee {string}")
    public void theCustomerPaysToThePayee(String amount, String payee) {
        new BillPayPage(DriverFactory.getDriver()).open().payBill(payee, amount);
    }

    @Then("the bill payment is confirmed")
    public void theBillPaymentIsConfirmed() {
        String heading = new BillPayPage(DriverFactory.getDriver()).getResultHeading();
        Assert.assertEquals(heading, "Bill Payment Complete");
    }

    @When("the customer submits the bill payment form without details")
    public void theCustomerSubmitsTheBillPaymentFormWithoutDetails() {
        new BillPayPage(DriverFactory.getDriver()).open().submitWithoutDetails();
    }

    @Then("validation errors are displayed")
    public void validationErrorsAreDisplayed() {
        Assert.assertTrue(new BillPayPage(DriverFactory.getDriver()).hasValidationErrors(),
                "Expected validation errors on the bill pay form");
    }

    // ---------- helpers ----------

    private void registerNewCustomer() {
        username = TestDataGenerator.uniqueUsername();
        password = TestDataGenerator.DEFAULT_PASSWORD;
        registerPage().open().register(username, password);
    }
}
