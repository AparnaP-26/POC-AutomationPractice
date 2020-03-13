Feature: Footer Verification for different sections
Description: As a user I want to verify the page footer sections

Scenario: Verify the social media sharing section in the footer
	Given user is in the home page of the application
  Then social media section is displayed in the footer
  Then copyright section is displayed in the footer
	Then call us now section is displayed in the footer