@billpay
Feature: Pay bills

  Background:
    Given a registered customer

  @smoke
  Scenario: Customer pays a bill
    When the customer pays "50" to the payee "Electricity Board"
    Then the bill payment is confirmed

  @negative
  Scenario: Bill payment form validates mandatory fields
    When the customer submits the bill payment form without details
    Then validation errors are displayed
