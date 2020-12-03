package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.WebDriverUtility;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.BrowserPage;

public class Browser {
	WebDriverUtility webDriverUtility = WebDriverUtility.getInstanceOfScenarioContextClass();
    WebDriver driver = webDriverUtility.getDriver();
    BrowserPage browser = new BrowserPage(driver);   
	
    @Given("^user is  on launches the browser$")
    public void user_is_on_browser() throws Exception {         
    	webDriverUtility.waitForPageToLoad();
    	
    }
    
    @When("^user enters \"([^\"]*)\"$")
    public void user_enters_url(String url) throws Exception {

    	driver.get(url);
    	driver.manage().window().maximize();
	       
    	driver.switchTo().frame(0);
    	webDriverUtility.click(browser.agreeBtn);
    	
    }
    
    @Then("^200 OK is displayed$")
    public void ok_is_displayed() throws Exception {
    	
    	webDriverUtility.elementIsDisplayed(browser.searchBar);
    	driver.quit();
    }  
   
}
