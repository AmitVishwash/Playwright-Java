Feature: Landing Page of mail chimp

  Background:
    Given the user opens the mailchimp application

    Scenario: User should see the landing page of the application
      Then the user should land on the home page of the application

      Scenario: User should be able to land on login page after selecting Log In
        When the user clicks on Log In
        Then the user should land on Login page