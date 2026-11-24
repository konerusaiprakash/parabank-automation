@authentication
Feature: ParaBank customer registration and login

  @smoke
  Scenario: New customer can register
    When the customer registers a new account
    Then the registration success message is displayed

  @smoke
  Scenario: Registered customer can log in again
    Given a registered customer
    When the customer logs out and logs in with the same credentials
    Then the accounts overview page is displayed

  @negative
  Scenario Outline: Login fails with invalid credentials
    Given the ParaBank home page is open
    When the customer logs in with username "<username>" and password "<password>"
    Then an error message containing "could not be verified" is displayed

    Examples:
      | username     | password  |
      | invalid_user | wrong_123 |
      | admin_test   | pass@999  |
