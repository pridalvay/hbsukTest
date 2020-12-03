package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	    public static WebDriverUtility webDriverUtility;
	    public WebDriver driver;
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    
	    private WebDriverUtility(){
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\GBA15\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }

	    public static WebDriverUtility getInstanceOfScenarioContextClass(){
	        if (webDriverUtility == null) {
	        	webDriverUtility = new WebDriverUtility();
	        }
	        return webDriverUtility;
	    }

	    public WebDriver getDriver(){
	        return driver;
	    }
	
	    public void waitForPageToLoad() {
	    	WebDriverWait wait = new WebDriverWait(driver, 30);

	        wait.until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver wdriver) {
	                return ((JavascriptExecutor) driver).executeScript(
	                    "return document.readyState"
	                ).equals("complete");
	            }
	        });
	    }
	    
	    public void click(WebElement element)
		 {
			 try {
			 element.click();
			 Thread.sleep(5000);
			 	}
			 catch (InterruptedException e) 
			 {e.getMessage();}
		 }

		 public boolean elementIsDisplayed(WebElement element) throws InterruptedException
		 {
			 if(element.isDisplayed())
				 return true;
			 else 
				 return false;
		 }
	    
	    public void scrollByVisibleElement(WebElement Element) {
	    	js.executeScript("arguments[0].scrollIntoView();", Element);
	    }
	    
	    public void scrollByPage() {
	    	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    }
}
