@Registration
Feature: Validate ParaBank website functionality

  Scenario: Validate Registration functionality of the ParaBank website
    Given User is on ParaBank Login page
    When User click on the Register link
    Then User should navigate to the Registration page
    And User enters enter all the fields on the registration page
      | John | Doe | 123 Main St | New York | NY | 10001 | 123-456-7890 | 123-45-6789 | test5 | Happy@123 | Happy@123 |
    And User submits the registration form
    Then User should see a confirmation message