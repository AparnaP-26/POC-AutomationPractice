Feature: Header Verification for different pages
Description: I want to verify the page headers

Scenario:
	Given the user logs into the application
	When user navigates to Women tab
	Then verify the header of the page is Women
	When user navigates to Dresses tab
	Then verify the header of the page is DRESSES
	When user navigates to shopping cart
	Then verify the header of the page is cart    