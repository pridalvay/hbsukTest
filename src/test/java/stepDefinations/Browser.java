package stepDefinations;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import util.WebDriverUtility;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.BrowserPage;

public class Browser {
	WebDriverUtility webDriverUtility = WebDriverUtility.getInstanceOfScenarioContextClass();
    WebDriver driver = webDriverUtility.getDriver();
    BrowserPage browser = new BrowserPage(driver);   
	
    
    @Given("^user enters \"([^\"]*)\"$")
    public void user_is_on_browser(String url) throws Exception {         
    	webDriverUtility.waitForPageToLoad();

    	driver.get(url);
    	driver.manage().window().maximize();
	     
    }
    
    @When("^user enters username \"([^\"]*)\"$")
    public void user_enters_username(String username) throws Exception {
    	webDriverUtility.waitForPageToLoad();
    	webDriverUtility.sendKeys(browser.username, username);
//    	driver.findElement(By.xpath("//input[@id= 'login-input']")).sendKeys(username);
    	
    }
    
    @When("^user enters password \"([^\"]*)\"$")
    public void user_enters_password(String password) throws Exception {
    	webDriverUtility.waitForPageToLoad();
    	webDriverUtility.sendKeys(browser.password, password);
    	webDriverUtility.click(browser.loginBtn);
//    	driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys(password);
//    	driver.findElement(By.id("login-submit-button")).click();
    	
    }
    
    @Then("^the user \"([^\"]*)\" error$")
    public void the_user_see_error(Boolean status) throws Exception {
    	if (!status)
    	{
    		//error validation
    		
    	}else
    	{
    		//successfully navigated to next page
    		assertTrue("recaptcha not displayed", webDriverUtility.elementIsDisplayed(browser.recaptcha));
    	}
    	driver.quit();
    }  
   
}
