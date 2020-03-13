Feature: Newsletter Subscription
Description: As a user I want to subscribe the newsletter

Scenario: Verify the user is able to subscribe the newsletter successfully
   Given the user has launched the AUT application successfully
   When user provides the email in the subscription field
   When user clicks on the Subscribe button
   Then verify the user subscription is successful