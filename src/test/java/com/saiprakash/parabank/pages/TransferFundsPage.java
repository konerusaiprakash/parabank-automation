package com.saiprakash.parabank.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/** Transfer funds between the logged-in customer's accounts. */
public class TransferFundsPage extends BasePage {

    private final By amount = By.id("amount");
    private final By fromAccount = By.id("fromAccountId");
    private final By toAccount = By.id("toAccountId");
    private final By transferButton = By.cssSelector("input[value='Transfer']");
    private final By result = By.cssSelector("#showResult h1.title");

    public TransferFundsPage(WebDriver driver) {
        super(driver);
    }

    public TransferFundsPage open() {
        driver.get(baseUrl + "/transfer.htm");
        // account drop-downs are filled by an Ajax call, so wait until they have options
        wait.until(d -> new Select(d.findElement(fromAccount)).getOptions().size() > 0);
        wait.until(d -> new Select(d.findElement(toAccount)).getOptions().size() > 0);
        return this;
    }

    /** Transfers from the first account in the list to the last one. */
    public void transfer(String value) {
        type(amount, value);
        Select from = new Select(visible(fromAccount));
        from.selectByIndex(0);
        Select to = new Select(visible(toAccount));
        List<?> options = to.getOptions();
        to.selectByIndex(options.size() - 1);
        click(transferButton);
    }

    public String getResultHeading() {
        return textOf(result);
    }
}
