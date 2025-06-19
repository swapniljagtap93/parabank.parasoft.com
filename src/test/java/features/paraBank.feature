Feature: Validate ParaBank Login functionality

  Background: Successful login with valid credentials
    Given User is on ParaBank Login page
    When User enters username "test4" and password "Happy@123"
    And User clicks the Login button
    Then User should be logged in and see the Accounts Overview page

  Scenario: User clicks on account number and navigates to account details page
    Given User is on the Accounts Overview page
    When User clicks on an account number in the account summary
    Then User should be navigated to the Account Details page
    And Account details should be displayed

  @Regression
    Scenario: Validate all navigation links in the left side panel after login
      Given User is on the Accounts Overview page
      When User clicks on "Open New Account" link
      Then User should be navigated to the "Open New Account" page

      When User clicks on "Transfer Funds" link
      Then User should be navigated to the "Transfer Funds" page

      When User clicks on "Bill Pay" link
      Then User should be navigated to the "Bill Pay" page

      When User clicks on "Find Transactions" link
      Then User should be navigated to the "Find Transactions" page

      When User clicks on "Update Contact Info" link
      Then User should be navigated to the "Update Contact Info" page

      When User clicks on "Request Loan" link
      Then User should be navigated to the "Request Loan" page

      When User clicks on "Log Out" link
      Then User should be navigated to the "Welcome" page

