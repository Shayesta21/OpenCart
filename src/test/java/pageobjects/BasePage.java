package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	//this is the parent of all page object classes as it extends all page object classes
    //this constructor will be used by all page object classes
	WebDriver driver;
	
	
	public BasePage (WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver,this);
		
	
		
	}
	
	
	
	
}
