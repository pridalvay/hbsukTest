package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserPage {

	private WebDriverWait wait;
	public BrowserPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	    wait = new WebDriverWait(driver, 10);
	 }

	@FindBy(how = How.ID, using = "introAgreeButton")
		public WebElement agreeBtn; 
	
	@FindBy(how = How.ID, using = "searchform")
		public WebElement searchBar;

	 @FindBy(how = How.NAME, using = "btnK")
		public WebElement searchButton;
	
}
