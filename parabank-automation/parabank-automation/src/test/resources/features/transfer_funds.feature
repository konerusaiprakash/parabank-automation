@transfer
Feature: Transfer funds between accounts

  Background:
    Given a registered customer

  @smoke
  Scenario Outline: Customer transfers money between accounts
    When the customer transfers "<amount>" between accounts
    Then the transfer is completed

    Examples:
      | amount |
      | 10     |
      | 25     |
      | 100    |
