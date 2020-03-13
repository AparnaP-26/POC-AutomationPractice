Feature: Checkout journey verification
Description: As a user I want to verify the checkout journey

Scenario: Verify the checkout journey for a transaction
	Given the user has launched the application successfully
  When user added a product to the cart
  When user clicks on Checkout option
  Then user is displayed with Authentication page