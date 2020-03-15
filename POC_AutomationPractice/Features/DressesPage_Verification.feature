Feature: Dresses Page verification
Description: As a user I want to verify the options available in Dress page

Background: User opens the application
  Given the user has opened the application successfully
  When navigated to Summer Dresses page
     
  Scenario: Verify the Summer dress page for a user
    Then user is displayed with Summer Dresses page

  Scenario: Verify the filters displayed in the Summer Dresses page
    When user clicks on Size filter
    Then dresses with size filtered will only be displayed

  Scenario: Verify the sorting displayed in the Summer Dresses page
    When user clicks on sorting with price condition
    Then the page will be displayed in sorted order of price
