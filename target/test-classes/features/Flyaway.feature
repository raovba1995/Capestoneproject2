@Flyaway
Feature: This feature will be used to automate Flyaway Website

  Scenario: Validate the Signup scenario
    Given I have launched the application
    When I click on Signup link
    And I click on  Not a member?Signup link
    And I enter the details
      | Email id         | nccc@xyzzv.com |
      | Password         | abc@123        |
      | Confirm Password | abc@123        |
      | Name             | Vibha          |
      | Address          | mgraod         |
      | City             | Hubli          |
    And I click on Signup button
    Then I should see the link as "Login to continue checking flights"

  Scenario: Validate the Login success sceanrio
    Given I have launched the application
    And I click on login link
    When I enter emailid as "abc@xyz.com"
    And I enter the password as "abc@123"
    And I click on login button
    Then I should land on to Flyaway-Dashboard page

  Scenario: Validate the Login failure sceanrio
    Given I have launched the application
    And I click on login link
    When I enter emailid as "pqr@xyz.com"
    And I enter the password as "Abc@1234"
    And I click on login button
    Then I should get the error message as "Login failed"

  Scenario: This scenario is used for flight booking between Bangalore and Chennai
    Given I have launched the application
    And I click on login link
    When I enter emailid as "abc@xyz.com"
    And I enter the password as "abc@123"
    And I click on login button
    And I click on Home button
    And selected source as "Bangalore"
    And selected destination as "Chennai"
    And I click on submit button
    And I click on BookFlight link
    And I Click on Click to complete booking
    Then I should land on to Flyaway-Booking Confirmation page

  Scenario: This scenario check the your bookings
    Given I have launched the application
    And I click on login link
    When I enter emailid as "abc@xyz.com"
    And I enter the password as "abc@123"
    And I click on login button
    And I click on Home button
    And selected source as "Bangalore"
    And selected destination as "Chennai"
    And I click on submit button
    And I click on BookFlight link
    And I Click on Click to complete booking
    Then I should land on to Flyaway-Booking Confirmation page
    And i click on your bookings link
    Then I should land on to Flyaway-Your Bookings page
    And I should see Source as "Bangalore" and Destination as "Chennai" in the table
