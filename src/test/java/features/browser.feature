@test
Feature: Google site
  
 
  @launchBrowser
  Scenario: Verify if user is able to launch the site
    Given user is  on launches the browser
    When user enters "https://www.google.com"
    Then 200 OK is displayed 

    
    