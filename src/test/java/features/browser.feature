@launchBrowser
Feature: Login feature
  As a user I want to login

  Scenario Outline: Verify user if logged in
    Given user enters "https://accounts.ocado.com/auth-service/sso/login"
    When user enters username <username>
    When user enters password <password>
    Then the user <see> error 
		Examples:
   | username | password | see |
   #| "test" | "test" | "false" |
   | "ananceki@gmail.com" | "Password" | "true" |
    